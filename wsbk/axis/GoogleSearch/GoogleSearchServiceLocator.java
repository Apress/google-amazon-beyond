/**
 * GoogleSearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package GoogleSearch;

public class GoogleSearchServiceLocator extends org.apache.axis.client.Service implements GoogleSearch.GoogleSearchService {

    // Use to get a proxy class for GoogleSearchPort
    private final java.lang.String GoogleSearchPort_address = "http://api.google.com/search/beta2";

    public java.lang.String getGoogleSearchPortAddress() {
        return GoogleSearchPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GoogleSearchPortWSDDServiceName = "GoogleSearchPort";

    public java.lang.String getGoogleSearchPortWSDDServiceName() {
        return GoogleSearchPortWSDDServiceName;
    }

    public void setGoogleSearchPortWSDDServiceName(java.lang.String name) {
        GoogleSearchPortWSDDServiceName = name;
    }

    public GoogleSearch.GoogleSearchPort getGoogleSearchPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GoogleSearchPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGoogleSearchPort(endpoint);
    }

    public GoogleSearch.GoogleSearchPort getGoogleSearchPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            GoogleSearch.GoogleSearchBindingStub _stub = new GoogleSearch.GoogleSearchBindingStub(portAddress, this);
            _stub.setPortName(getGoogleSearchPortWSDDServiceName());
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
            if (GoogleSearch.GoogleSearchPort.class.isAssignableFrom(serviceEndpointInterface)) {
                GoogleSearch.GoogleSearchBindingStub _stub = new GoogleSearch.GoogleSearchBindingStub(new java.net.URL(GoogleSearchPort_address), this);
                _stub.setPortName(getGoogleSearchPortWSDDServiceName());
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
        if ("GoogleSearchPort".equals(inputPortName)) {
            return getGoogleSearchPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:GoogleSearch", "GoogleSearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("GoogleSearchPort"));
        }
        return ports.iterator();
    }

}
