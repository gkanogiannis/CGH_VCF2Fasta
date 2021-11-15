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

public class Vcf2fastaRunner implements Runnable {

	private Vcf2fastaUI vcf2fastaUI;
	private Vcf2fastaInputBean vcf2fastaInputBean;
	
	private volatile boolean isStopped;

	public Vcf2fastaRunner(Vcf2fastaUI vcf2fastaUI, Vcf2fastaInputBean vcf2fastaInputBean) {
		this.vcf2fastaUI = vcf2fastaUI;
		this.vcf2fastaInputBean = vcf2fastaInputBean;
		this.isStopped = true;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		isStopped = false;
		try {

			IVcf2fastaWebServiceCall vcf2fastaCall = new Vcf2fastaWebServiceCall(vcf2fastaUI.getConfig()).makeVcf2fastaCall(vcf2fastaInputBean);
			
			while(!isStopped && vcf2fastaCall.getStatusCode() != 8){
				if(vcf2fastaCall.getStatusCode()==-1) {
					isStopped = true;
					break;
				}
				try {
					Thread.currentThread().sleep(500L);
				} 
				catch (InterruptedException localInterruptedException) {
				}
			}	
			
			String vcf2fastaResultURLcc = null;
			if(!isStopped) {
				vcf2fastaResultURLcc = vcf2fastaCall.getResultURL();
			}
			System.out.println(vcf2fastaResultURLcc);
			
			vcf2fastaUI.vcf2fastaEnd(vcf2fastaResultURLcc, vcf2fastaInputBean);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void vcf2fastaStop() {
		//currentThread.get().interrupt();
		isStopped = true;
	}
}
