/**
 * UpdateCountServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.n_topus.DBS;

public class UpdateCountServiceLocator extends org.apache.axis.client.Service implements com.n_topus.DBS.UpdateCountService {

    // The update part of DBAuthService

    // Use to get a proxy class for UpdateCountPort
    private final java.lang.String UpdateCountPort_address = "http://localhost:65432/";

    public java.lang.String getUpdateCountPortAddress() {
        return UpdateCountPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UpdateCountPortWSDDServiceName = "UpdateCountPort";

    public java.lang.String getUpdateCountPortWSDDServiceName() {
        return UpdateCountPortWSDDServiceName;
    }

    public void setUpdateCountPortWSDDServiceName(java.lang.String name) {
        UpdateCountPortWSDDServiceName = name;
    }

    public com.n_topus.DBS.UpdateCountPortType getUpdateCountPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UpdateCountPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUpdateCountPort(endpoint);
    }

    public com.n_topus.DBS.UpdateCountPortType getUpdateCountPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.n_topus.DBS.UpdateCountBindingStub _stub = new com.n_topus.DBS.UpdateCountBindingStub(portAddress, this);
            _stub.setPortName(getUpdateCountPortWSDDServiceName());
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
            if (com.n_topus.DBS.UpdateCountPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.n_topus.DBS.UpdateCountBindingStub _stub = new com.n_topus.DBS.UpdateCountBindingStub(new java.net.URL(UpdateCountPort_address), this);
                _stub.setPortName(getUpdateCountPortWSDDServiceName());
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
        if ("UpdateCountPort".equals(inputPortName)) {
            return getUpdateCountPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://n-topus.com/DBS", "UpdateCountService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("UpdateCountPort"));
        }
        return ports.iterator();
    }

}
