/*
 *
 * CGH_VCF2Fasta cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType
 *
 * Copyright (C) 2021 Anestis Gkanogiannis <anestis@gkanogiannis.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *
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
