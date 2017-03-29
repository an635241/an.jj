/**
 * N_frdifLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempurl;

public class N_frdifLocator extends org.apache.axis.client.Service implements org.tempurl.N_frdif {

    public N_frdifLocator() {
    }


    public N_frdifLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public N_frdifLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for n_frdifSoap
//    private java.lang.String n_frdifSoap_address = "http://192.168.4.77:7000/frdif/n_frdif.asmx";//正式库
    private java.lang.String n_frdifSoap_address = "http://172.24.241.79:7001/frdif/n_frdif.asmx";//测试库

    public java.lang.String getn_frdifSoapAddress() {
        return n_frdifSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String n_frdifSoapWSDDServiceName = "n_frdifSoap";

    public java.lang.String getn_frdifSoapWSDDServiceName() {
        return n_frdifSoapWSDDServiceName;
    }

    public void setn_frdifSoapWSDDServiceName(java.lang.String name) {
        n_frdifSoapWSDDServiceName = name;
    }

    public org.tempurl.N_frdifSoap getn_frdifSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(n_frdifSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getn_frdifSoap(endpoint);
    }

    public org.tempurl.N_frdifSoap getn_frdifSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempurl.N_frdifSoapStub _stub = new org.tempurl.N_frdifSoapStub(portAddress, this);
            _stub.setPortName(getn_frdifSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setn_frdifSoapEndpointAddress(java.lang.String address) {
        n_frdifSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempurl.N_frdifSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempurl.N_frdifSoapStub _stub = new org.tempurl.N_frdifSoapStub(new java.net.URL(n_frdifSoap_address), this);
                _stub.setPortName(getn_frdifSoapWSDDServiceName());
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("n_frdifSoap".equals(inputPortName)) {
            return getn_frdifSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempurl.org", "n_frdif");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempurl.org", "n_frdifSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("n_frdifSoap".equals(portName)) {
            setn_frdifSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
