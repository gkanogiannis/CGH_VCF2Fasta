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
 * ParamType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cirad.cgh.vcf2fasta.ws.gatk_alternativefasta.types;

public class ParamType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ParamType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _INT = "INT";
    public static final java.lang.String _BOOL = "BOOL";
    public static final java.lang.String _FLOAT = "FLOAT";
    public static final java.lang.String _STRING = "STRING";
    public static final java.lang.String _FILE = "FILE";
    public static final java.lang.String _URL = "URL";
    public static final ParamType INT = new ParamType(_INT);
    public static final ParamType BOOL = new ParamType(_BOOL);
    public static final ParamType FLOAT = new ParamType(_FLOAT);
    public static final ParamType STRING = new ParamType(_STRING);
    public static final ParamType FILE = new ParamType(_FILE);
    public static final ParamType URL = new ParamType(_URL);
    public java.lang.String getValue() { return _value_;}
    public static ParamType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ParamType enumeration = (ParamType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ParamType fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParamType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nbcr.sdsc.edu/opal/types", "ParamType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
