/*
 *
 * CGH_VCF2Fasta cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.JobOutputType
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

package cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types;

public class JobOutputType  implements java.io.Serializable {
    private org.apache.axis.types.URI stdOut;

    private org.apache.axis.types.URI stdErr;

    private cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType[] outputFile;

    public JobOutputType() {
    }

    public JobOutputType(
           org.apache.axis.types.URI stdOut,
           org.apache.axis.types.URI stdErr,
           cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType[] outputFile) {
           this.stdOut = stdOut;
           this.stdErr = stdErr;
           this.outputFile = outputFile;
    }


    /**
     * Gets the stdOut value for this JobOutputType.
     * 
     * @return stdOut
     */
    public org.apache.axis.types.URI getStdOut() {
        return stdOut;
    }


    /**
     * Sets the stdOut value for this JobOutputType.
     * 
     * @param stdOut
     */
    public void setStdOut(org.apache.axis.types.URI stdOut) {
        this.stdOut = stdOut;
    }


    /**
     * Gets the stdErr value for this JobOutputType.
     * 
     * @return stdErr
     */
    public org.apache.axis.types.URI getStdErr() {
        return stdErr;
    }


    /**
     * Sets the stdErr value for this JobOutputType.
     * 
     * @param stdErr
     */
    public void setStdErr(org.apache.axis.types.URI stdErr) {
        this.stdErr = stdErr;
    }


    /**
     * Gets the outputFile value for this JobOutputType.
     * 
     * @return outputFile
     */
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType[] getOutputFile() {
        return outputFile;
    }


    /**
     * Sets the outputFile value for this JobOutputType.
     * 
     * @param outputFile
     */
    public void setOutputFile(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType[] outputFile) {
        this.outputFile = outputFile;
    }

    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType getOutputFile(int i) {
        return this.outputFile[i];
    }

    public void setOutputFile(int i, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.OutputFileType _value) {
        this.outputFile[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JobOutputType)) return false;
        JobOutputType other = (JobOutputType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.stdOut==null && other.getStdOut()==null) || 
             (this.stdOut!=null &&
              this.stdOut.equals(other.getStdOut()))) &&
            ((this.stdErr==null && other.getStdErr()==null) || 
             (this.stdErr!=null &&
              this.stdErr.equals(other.getStdErr()))) &&
            ((this.outputFile==null && other.getOutputFile()==null) || 
             (this.outputFile!=null &&
              java.util.Arrays.equals(this.outputFile, other.getOutputFile())));
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
        if (getStdOut() != null) {
            _hashCode += getStdOut().hashCode();
        }
        if (getStdErr() != null) {
            _hashCode += getStdErr().hashCode();
        }
        if (getOutputFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOutputFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOutputFile(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JobOutputType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "JobOutputType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stdOut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stdOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stdErr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stdErr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputFile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outputFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "OutputFileType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
