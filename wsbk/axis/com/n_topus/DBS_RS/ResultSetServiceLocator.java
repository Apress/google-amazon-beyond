/**
 * ResultSetServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.n_topus.DBS_RS;

public class ResultSetServiceLocator extends org.apache.axis.client.Service implements com.n_topus.DBS_RS.ResultSetService {

    // The update part of DBAuthService

    // Use to get a proxy class for ResultSetPort
    private final java.lang.String ResultSetPort_address = "http://localhost:65432/";

    public java.lang.String getResultSetPortAddress() {
        return ResultSetPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ResultSetPortWSDDServiceName = "ResultSetPort";

    public java.lang.String getResultSetPortWSDDServiceName() {
        return ResultSetPortWSDDServiceName;
    }

    public void setResultSetPortWSDDServiceName(java.lang.String name) {
        ResultSetPortWSDDServiceName = name;
    }

    public com.n_topus.DBS_RS.ResultSetPortType getResultSetPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ResultSetPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getResultSetPort(endpoint);
    }

    public com.n_topus.DBS_RS.ResultSetPortType getResultSetPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.n_topus.DBS_RS.ResultSetBindingStub _stub = new com.n_topus.DBS_RS.ResultSetBindingStub(portAddress, this);
            _stub.setPortName(getResultSetPortWSDDServiceName());
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
            if (com.n_topus.DBS_RS.ResultSetPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.n_topus.DBS_RS.ResultSetBindingStub _stub = new com.n_topus.DBS_RS.ResultSetBindingStub(new java.net.URL(ResultSetPort_address), this);
                _stub.setPortName(getResultSetPortWSDDServiceName());
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
        if ("ResultSetPort".equals(inputPortName)) {
            return getResultSetPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://n-topus.com/DBS", "ResultSetService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("ResultSetPort"));
        }
        return ports.iterator();
    }

}
