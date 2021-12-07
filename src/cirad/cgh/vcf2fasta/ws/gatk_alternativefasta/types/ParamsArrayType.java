/*
 *
 * CGH_VCF2Fasta cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsArrayType
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

public class ParamsArrayType  implements java.io.Serializable {
    private java.lang.String separator;

    private cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsType[] param;

    public ParamsArrayType() {
    }

    public ParamsArrayType(
           java.lang.String separator,
           cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsType[] param) {
           this.separator = separator;
           this.param = param;
    }


    /**
     * Gets the separator value for this ParamsArrayType.
     * 
     * @return separator
     */
    public java.lang.String getSeparator() {
        return separator;
    }


    /**
     * Sets the separator value for this ParamsArrayType.
     * 
     * @param separator
     */
    public void setSeparator(java.lang.String separator) {
        this.separator = separator;
    }


    /**
     * Gets the param value for this ParamsArrayType.
     * 
     * @return param
     */
    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsType[] getParam() {
        return param;
    }


    /**
     * Sets the param value for this ParamsArrayType.
     * 
     * @param param
     */
    public void setParam(cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsType[] param) {
        this.param = param;
    }

    public cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsType getParam(int i) {
        return this.param[i];
    }

    public void setParam(int i, cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types.ParamsType _value) {
        this.param[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParamsArrayType)) return false;
        ParamsArrayType other = (ParamsArrayType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.separator==null && other.getSeparator()==null) || 
             (this.separator!=null &&
              this.separator.equals(other.getSeparator()))) &&
            ((this.param==null && other.getParam()==null) || 
             (this.param!=null &&
              java.util.Arrays.equals(this.param, other.getParam())));
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
        if (getSeparator() != null) {
            _hashCode += getSeparator().hashCode();
        }
        if (getParam() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParam());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParam(), i);
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
        new org.apache.axis.description.TypeDesc(ParamsArrayType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "ParamsArrayType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("separator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "separator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "ParamsType"));
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
