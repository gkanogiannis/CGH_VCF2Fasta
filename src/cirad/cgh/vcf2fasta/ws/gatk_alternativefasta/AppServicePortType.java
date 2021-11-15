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
/**
 * AppServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cirad.cgh.vcf2fasta.ws.gatk_alternativefasta;

public interface AppServicePortType extends java.rmi.Remote {
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppMetadataType getAppMetadata(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppMetadataInputType getAppMetadataInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppConfigType getAppConfig(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppConfigInputType getAppConfigInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.SystemInfoType getSystemInfo(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.SystemInfoInputType getSystemInfoInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobSubOutputType launchJob(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobInputType launchJobInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.BlockingOutputType launchJobBlocking(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobInputType launchJobBlockingInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType queryStatus(java.lang.String queryStatusInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobStatisticsType getJobStatistics(java.lang.String getJobStatisticsInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType getOutputs(java.lang.String getOutputsInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public byte[] getOutputAsBase64ByName(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputsByNameInputType getOutputAsBase64ByNameInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType destroy(java.lang.String destroyInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType;
}
