/**
 * IQuiverService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl;

public interface IQuiverService extends javax.xml.rpc.Service {
    public java.lang.String getIQuiverAddress();

    public net.sf.iquiver.remote.soap.impl.IQuiver getIQuiver() throws javax.xml.rpc.ServiceException;

    public net.sf.iquiver.remote.soap.impl.IQuiver getIQuiver(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
