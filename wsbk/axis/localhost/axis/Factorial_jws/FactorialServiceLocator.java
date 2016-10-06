/**
 * FactorialServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package localhost.axis.Factorial_jws;

public class FactorialServiceLocator extends org.apache.axis.client.Service implements localhost.axis.Factorial_jws.FactorialService {

    // Use to get a proxy class for Factorial
    private final java.lang.String Factorial_address = "http://localhost:8080/axis/Factorial.jws";

    public java.lang.String getFactorialAddress() {
        return Factorial_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FactorialWSDDServiceName = "Factorial";

    public java.lang.String getFactorialWSDDServiceName() {
        return FactorialWSDDServiceName;
    }

    public void setFactorialWSDDServiceName(java.lang.String name) {
        FactorialWSDDServiceName = name;
    }

    public localhost.axis.Factorial_jws.Factorial getFactorial() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Factorial_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFactorial(endpoint);
    }

    public localhost.axis.Factorial_jws.Factorial getFactorial(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.axis.Factorial_jws.FactorialSoapBindingStub _stub = new localhost.axis.Factorial_jws.FactorialSoapBindingStub(portAddress, this);
            _stub.setPortName(getFactorialWSDDServiceName());
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
            if (localhost.axis.Factorial_jws.Factorial.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.axis.Factorial_jws.FactorialSoapBindingStub _stub = new localhost.axis.Factorial_jws.FactorialSoapBindingStub(new java.net.URL(Factorial_address), this);
                _stub.setPortName(getFactorialWSDDServiceName());
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
        if ("Factorial".equals(inputPortName)) {
            return getFactorial();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/Factorial.jws", "FactorialService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("Factorial"));
        }
        return ports.iterator();
    }

}
