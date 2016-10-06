/**
 * StockQuoteSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.example.stockquote_wsdl;

public class StockQuoteSoapBindingSkeleton implements com.example.stockquote_wsdl.StockQuotePortType, org.apache.axis.wsdl.Skeleton {
    private com.example.stockquote_wsdl.StockQuotePortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://example.com/stockquote.xsd", "TradePriceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://example.com/stockquote.xsd", ">TradePriceRequest"), com.example.stockquote_xsd._TradePriceRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getLastTradePrice", _params, new javax.xml.namespace.QName("http://example.com/stockquote.xsd", "TradePrice"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://example.com/stockquote.xsd", ">TradePrice"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "GetLastTradePrice"));
        _oper.setSoapAction("http://example.com/GetLastTradePrice");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getLastTradePrice") == null) {
            _myOperations.put("getLastTradePrice", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getLastTradePrice")).add(_oper);
    }

    public StockQuoteSoapBindingSkeleton() {
        this.impl = new com.example.stockquote_wsdl.StockQuoteSoapBindingImpl();
    }

    public StockQuoteSoapBindingSkeleton(com.example.stockquote_wsdl.StockQuotePortType impl) {
        this.impl = impl;
    }
    public com.example.stockquote_xsd._TradePrice getLastTradePrice(com.example.stockquote_xsd._TradePriceRequest body) throws java.rmi.RemoteException
    {
        com.example.stockquote_xsd._TradePrice ret = impl.getLastTradePrice(body);
        return ret;
    }

}
