/**
 * IQuiverServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl;

public class IQuiverServiceLocator extends org.apache.axis.client.Service implements net.sf.iquiver.remote.soap.impl.IQuiverService {

    // Use to get a proxy class for IQuiver
    private final java.lang.String IQuiver_address = "http://localhost:8080/simpleservice/services/IQuiver";

    public java.lang.String getIQuiverAddress() {
        return IQuiver_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IQuiverWSDDServiceName = "IQuiver";

    public java.lang.String getIQuiverWSDDServiceName() {
        return IQuiverWSDDServiceName;
    }

    public void setIQuiverWSDDServiceName(java.lang.String name) {
        IQuiverWSDDServiceName = name;
    }

    public net.sf.iquiver.remote.soap.impl.IQuiver getIQuiver() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IQuiver_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIQuiver(endpoint);
    }

    public net.sf.iquiver.remote.soap.impl.IQuiver getIQuiver(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.sf.iquiver.remote.soap.impl.IQuiverSoapBindingStub _stub = new net.sf.iquiver.remote.soap.impl.IQuiverSoapBindingStub(portAddress, this);
            _stub.setPortName(getIQuiverWSDDServiceName());
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
            if (net.sf.iquiver.remote.soap.impl.IQuiver.class.isAssignableFrom(serviceEndpointInterface)) {
                net.sf.iquiver.remote.soap.impl.IQuiverSoapBindingStub _stub = new net.sf.iquiver.remote.soap.impl.IQuiverSoapBindingStub(new java.net.URL(IQuiver_address), this);
                _stub.setPortName(getIQuiverWSDDServiceName());
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
        if ("IQuiver".equals(inputPortName)) {
            return getIQuiver();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://iquiver", "IQuiverService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("IQuiver"));
        }
        return ports.iterator();
    }

}
