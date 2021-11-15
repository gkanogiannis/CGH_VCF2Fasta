/*******************************************************************************
 * Copyright (C) 2016 <CIRAD>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3 as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * See <http://www.gnu.org/licenses/gpl-3.0.html> for details about
 * GNU Affero General Public License V3.
 *
 * Contributors:
 *     Anestis Gkanogiannis <ganoyan@gmail.com>
 *******************************************************************************/
package cirad.cgh.vcf2fasta;

import cirad.cgh.vcf2fasta.beans.Vcf2fastaInputBean;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServiceLocator;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.InputFileType;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobInputType;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobSubOutputType;
import cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.rpc.ServiceException;

import org.apache.commons.configuration.XMLConfiguration;

public class Vcf2fastaWebServiceCall implements Serializable {

	private static final long serialVersionUID = 3526225275691004383L;

	private XMLConfiguration config;

	public Vcf2fastaWebServiceCall(XMLConfiguration config) {
		this.config = config;
	}

	@SuppressWarnings("unused")
	public IVcf2fastaWebServiceCall makeVcf2fastaCall(Vcf2fastaInputBean vcf2fastaInputBean) throws Exception {
		String program = vcf2fastaInputBean.getAccession();
		
		IVcf2fastaWebServiceCall vcf2fastaCall = null;
		String jobID = null;
		vcf2fastaCall = new Vcf2fastaCall(config);
		jobID = vcf2fastaCall.makeVcf2fastaCall(vcf2fastaInputBean);
			
		return vcf2fastaCall;
	}
	
}

interface IVcf2fastaWebServiceCall {
	public int getStatusCode();
	public String makeVcf2fastaCall(Vcf2fastaInputBean vcf2fastaInputBean);
	public String getResultURL();
}

class Vcf2fastaCall implements IVcf2fastaWebServiceCall {
	
	private XMLConfiguration config;
	
	private AppServicePortType servicePort;
	private String jobID = null;
	
	static {
	    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
	        {
	            public boolean verify(String hostname, SSLSession session)
	            {
	                // ip address of the service URL(like.23.28.244.244)
	                if (hostname.equals("172.22.55.12"))
	                    return true;
	                return false;
	            	
	            	//return true;
	            }
	        });
	}
	
	public Vcf2fastaCall(XMLConfiguration config) {
		this.config = config;
	}
	
	public synchronized AppServicePortType getService() {
		if (servicePort == null) {
			try {
				servicePort = new AppServiceLocator().getAppServicePort();
			} 
			catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return servicePort;
	}
	
	public synchronized int getStatusCode() {
		if(jobID == null) {
			return -1;
		}
		try {
			if (servicePort == null) {
				servicePort = getService();
			}
			return servicePort.queryStatus(jobID).getCode();
		} 
		catch (Exception e) {
			return -1;
		}
	}
	
	public synchronized String getResultURL() {
		if (servicePort == null) {
			servicePort = getService();
		}
		
		OutputFileType outFile = null;
		JobOutputType outputs = null;
		try {
			outputs = servicePort.getOutputs(jobID);
		} 
		catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
		for(OutputFileType tmp : outputs.getOutputFile()){
			if(tmp.getUrl().toString().endsWith("out.fasta"))
				outFile = tmp;
		}
		
		if(outFile != null){
			return outFile.getUrl().toString();
		}
		else{
			return null;
		}
	}

	//Returns jobID
	@SuppressWarnings("unused")
	public synchronized String makeVcf2fastaCall(Vcf2fastaInputBean vcf2fastaInputBean) {
		if (servicePort == null) {
			servicePort = getService();
		}
		
		String accession = vcf2fastaInputBean.getAccession();
		String contig = vcf2fastaInputBean.getContig();
		String interval = vcf2fastaInputBean.getInterval();
		
		String vcf_prefix = config.getString("analyses/analysis[@name='" + vcf2fastaInputBean.getAnalysis() + "']/vcf_prefix");
		String vcf_suffix = config.getString("analyses/analysis[@name='" + vcf2fastaInputBean.getAnalysis() + "']/vcf_suffix");
		
		StringBuilder arguments = new StringBuilder();
		arguments.append(" -o out.fasta");
		arguments.append(" -V \"" + vcf_prefix + "/" + accession + vcf_suffix + "\"");
		if(contig!=null && contig!=""){
			arguments.append(" -L " + contig + ":" + interval);
		}
		
		//System.out.println(arguments.toString());
		
		JobInputType jobIn = new JobInputType(
				arguments.toString(),//argList, 
				1,//numProcs, 
				null,//userEmail, 
				null,//password, 
				null,//wallClockTime, 
				null,//inputFile, 
				null,//extractInputs, 
				null);//sendNotification);
		
	
		//Non Blocking
		JobSubOutputType jobOut;
		try {
			jobOut = servicePort.launchJob(jobIn);
			jobID = jobOut.getJobID();
			return jobID;
		} 
		catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
		
		/*
		//Blocking
		JobOutputType jobOut = servicePort.launchJobBlocking(jobIn).getJobOut();

		OutputFileType outFile = null;
		for(OutputFileType tmp : jobOut.getOutputFile()){
			if(tmp.getUrl().toString().endsWith("result.txt"))
				outFile = tmp;
		}
		
		if(outFile != null){
			//System.out.println(outFile.getUrl().toString());
			return outFile.getUrl().toString();
		}
		else{
			return null;
		}
		*/
	}


}

