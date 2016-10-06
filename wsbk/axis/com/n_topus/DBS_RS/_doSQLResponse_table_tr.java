/**
 * _doSQLResponse_table_tr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 * Modified to handle "td" as well as "th" within "tr", by Tom Myers 8/10/03
 */

package com.n_topus.DBS_RS;

public class _doSQLResponse_table_tr  implements java.io.Serializable {
    private java.lang.String[] th;

    public _doSQLResponse_table_tr() {
    }

    public java.lang.String[] getTh() {
        return th;
    }

    public void setTh(java.lang.String[] th) {
        this.th = th;
    }

    public java.lang.String getTh(int i) {
        return th[i];
    }

    public void setTh(int i, java.lang.String value) {
        this.th[i] = value;
    }
/* Inserted Code to handle "td" elements just like "th" */
    public boolean isHeaderRow(){
      return getTh()!=null && getTh().length > 0;
    }

    private java.lang.String[] td;

 
    public java.lang.String[] getTd() {
        return td;
    }

    public void setTd(java.lang.String[] td) {
        this.td = td;
    }

    public java.lang.String getTd(int i) {
        return td[i];
    }

    public void setTd(int i, java.lang.String value) {
        this.td[i] = value;
    }
/*  end inserted code */

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof _doSQLResponse_table_tr)) return false;
        _doSQLResponse_table_tr other = (_doSQLResponse_table_tr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.th==null && other.getTh()==null) || 
             (this.th!=null &&
              java.util.Arrays.equals(this.th, other.getTh())))
/* inserted test for equality on Td contents */ && 
            ((this.td==null && other.getTd()==null) || 
             (this.td!=null &&
              java.util.Arrays.equals(this.td, other.getTd())));
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
        if (getTh() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTh());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTh(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
/* inserted hashCode calc for td elements */
        if (getTd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd(), i);
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
        new org.apache.axis.description.TypeDesc(_doSQLResponse_table_tr.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://n-topus.com/DBS", ">doSQLResponse>table>tr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("th");
        elemField.setXmlName(new javax.xml.namespace.QName("", "th"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2000/10/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
/* inserted elemField2, duplicating "th" with "td" */
        org.apache.axis.description.ElementDesc elemField2 = new org.apache.axis.description.ElementDesc();
        elemField2.setFieldName("td");
        elemField2.setXmlName(new javax.xml.namespace.QName("", "td"));
        elemField2.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2000/10/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField2);
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
