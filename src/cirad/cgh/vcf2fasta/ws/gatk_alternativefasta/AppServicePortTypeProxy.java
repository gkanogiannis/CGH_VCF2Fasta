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
package cirad.cgh.vcf2fasta.ws.gatk_alternativefasta;

public class AppServicePortTypeProxy implements cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType {
  private String _endpoint = null;
  private cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType appServicePortType = null;
  
  public AppServicePortTypeProxy() {
    _initAppServicePortTypeProxy();
  }
  
  public AppServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAppServicePortTypeProxy();
  }
  
  private void _initAppServicePortTypeProxy() {
    try {
      appServicePortType = (new cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServiceLocator()).getAppServicePort();
      if (appServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)appServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)appServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (appServicePortType != null)
      ((javax.xml.rpc.Stub)appServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType getAppServicePortType() {
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType;
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppMetadataType getAppMetadata(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppMetadataInputType getAppMetadataInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.getAppMetadata(getAppMetadataInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppConfigType getAppConfig(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.AppConfigInputType getAppConfigInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.getAppConfig(getAppConfigInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.SystemInfoType getSystemInfo(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.SystemInfoInputType getSystemInfoInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.getSystemInfo(getSystemInfoInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobSubOutputType launchJob(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobInputType launchJobInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.launchJob(launchJobInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.BlockingOutputType launchJobBlocking(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobInputType launchJobBlockingInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.launchJobBlocking(launchJobBlockingInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType queryStatus(java.lang.String queryStatusInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.queryStatus(queryStatusInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobStatisticsType getJobStatistics(java.lang.String getJobStatisticsInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.getJobStatistics(getJobStatisticsInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType getOutputs(java.lang.String getOutputsInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.getOutputs(getOutputsInput);
  }
  
  public byte[] getOutputAsBase64ByName(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputsByNameInputType getOutputAsBase64ByNameInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.getOutputAsBase64ByName(getOutputAsBase64ByNameInput);
  }
  
  public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType destroy(java.lang.String destroyInput) throws java.rmi.RemoteException, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.FaultType{
    if (appServicePortType == null)
      _initAppServicePortTypeProxy();
    return appServicePortType.destroy(destroyInput);
  }
  
  
}