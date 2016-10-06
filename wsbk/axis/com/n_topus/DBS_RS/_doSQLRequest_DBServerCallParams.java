/**
 * _doSQLRequest_DBServerCallParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.n_topus.DBS_RS;

public class _doSQLRequest_DBServerCallParams  implements java.io.Serializable {
    private java.lang.String[] dbParam;

    public _doSQLRequest_DBServerCallParams() {
    }

    public java.lang.String[] getDbParam() {
        return dbParam;
    }

    public void setDbParam(java.lang.String[] dbParam) {
        this.dbParam = dbParam;
    }

    public java.lang.String getDbParam(int i) {
        return dbParam[i];
    }

    public void setDbParam(int i, java.lang.String value) {
        this.dbParam[i] = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof _doSQLRequest_DBServerCallParams)) return false;
        _doSQLRequest_DBServerCallParams other = (_doSQLRequest_DBServerCallParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dbParam==null && other.getDbParam()==null) || 
             (this.dbParam!=null &&
              java.util.Arrays.equals(this.dbParam, other.getDbParam())));
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
        if (getDbParam() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDbParam());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDbParam(), i);
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
        new org.apache.axis.description.TypeDesc(_doSQLRequest_DBServerCallParams.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://n-topus.com/DBS", ">doSQLRequest>DBServerCallParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbParam");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dbParam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2000/10/XMLSchema", "string"));
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
