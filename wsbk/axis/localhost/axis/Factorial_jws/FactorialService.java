/**
 * FactorialService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package localhost.axis.Factorial_jws;

public interface FactorialService extends javax.xml.rpc.Service {
    public java.lang.String getFactorialAddress();

    public localhost.axis.Factorial_jws.Factorial getFactorial() throws javax.xml.rpc.ServiceException;

    public localhost.axis.Factorial_jws.Factorial getFactorial(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
