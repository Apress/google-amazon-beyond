/**
 * StockQuoteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.example.stockquote_wsdl;

public class StockQuoteServiceLocator extends org.apache.axis.client.Service implements com.example.stockquote_wsdl.StockQuoteService {

    // My first service

    // Use to get a proxy class for StockQuotePort
    private final java.lang.String StockQuotePort_address = "http://example.com/stockquote";

    public java.lang.String getStockQuotePortAddress() {
        return StockQuotePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockQuotePortWSDDServiceName = "StockQuotePort";

    public java.lang.String getStockQuotePortWSDDServiceName() {
        return StockQuotePortWSDDServiceName;
    }

    public void setStockQuotePortWSDDServiceName(java.lang.String name) {
        StockQuotePortWSDDServiceName = name;
    }

    public com.example.stockquote_wsdl.StockQuotePortType getStockQuotePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockQuotePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockQuotePort(endpoint);
    }

    public com.example.stockquote_wsdl.StockQuotePortType getStockQuotePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.example.stockquote_wsdl.StockQuoteSoapBindingStub _stub = new com.example.stockquote_wsdl.StockQuoteSoapBindingStub(portAddress, this);
            _stub.setPortName(getStockQuotePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.example.stockquote_wsdl.StockQuotePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.example.stockquote_wsdl.StockQuoteSoapBindingStub _stub = new com.example.stockquote_wsdl.StockQuoteSoapBindingStub(new java.net.URL(StockQuotePort_address), this);
                _stub.setPortName(getStockQuotePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("StockQuotePort".equals(inputPortName)) {
            return getStockQuotePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://example.com/stockquote.wsdl", "StockQuoteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("StockQuotePort"));
        }
        return ports.iterator();
    }

}
