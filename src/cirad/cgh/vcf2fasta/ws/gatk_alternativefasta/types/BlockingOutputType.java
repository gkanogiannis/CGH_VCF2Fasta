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
 * BlockingOutputType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types;

public class BlockingOutputType  implements java.io.Serializable {
    private cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType status;

    private cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType jobOut;

    public BlockingOutputType() {
    }

    public BlockingOutputType(
           cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType status,
           cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType jobOut) {
           this.status = status;
           this.jobOut = jobOut;
    }


    /**
     * Gets the status value for this BlockingOutputType.
     * 
     * @return status
     */
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType getStatus() {
        return status;
    }


    /**
     * Sets the status value for this BlockingOutputType.
     * 
     * @param status
     */
    public void setStatus(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.StatusOutputType status) {
        this.status = status;
    }


    /**
     * Gets the jobOut value for this BlockingOutputType.
     * 
     * @return jobOut
     */
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType getJobOut() {
        return jobOut;
    }


    /**
     * Sets the jobOut value for this BlockingOutputType.
     * 
     * @param jobOut
     */
    public void setJobOut(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType jobOut) {
        this.jobOut = jobOut;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BlockingOutputType)) return false;
        BlockingOutputType other = (BlockingOutputType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.jobOut==null && other.getJobOut()==null) || 
             (this.jobOut!=null &&
              this.jobOut.equals(other.getJobOut())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getJobOut() != null) {
            _hashCode += getJobOut().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BlockingOutputType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "BlockingOutputType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "StatusOutputType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobOut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "JobOutputType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}