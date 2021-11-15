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
 * AppService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cirad.cgh.vcf2fasta.ws.gatk_alternativefasta;

public interface AppService extends javax.xml.rpc.Service {
    public java.lang.String getAppServicePortAddress();

    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType getAppServicePort() throws javax.xml.rpc.ServiceException;

    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.AppServicePortType getAppServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
