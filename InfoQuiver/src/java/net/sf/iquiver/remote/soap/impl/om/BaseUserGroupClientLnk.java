/**
 * BaseUserGroupClientLnk.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseUserGroupClientLnk  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.Client client;
    private int clientId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey clientKey;
    private net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnkPeer peer;
    private net.sf.iquiver.remote.soap.impl.om.UserGroup userGroup;
    private long userGroupId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey userGroupKey;

    public BaseUserGroupClientLnk() {
    }

    public net.sf.iquiver.remote.soap.impl.om.Client getClient() {
        return client;
    }

    public void setClient(net.sf.iquiver.remote.soap.impl.om.Client client) {
        this.client = client;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey clientKey) {
        this.clientKey = clientKey;
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnkPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnkPeer peer) {
        this.peer = peer;
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(net.sf.iquiver.remote.soap.impl.om.UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getUserGroupKey() {
        return userGroupKey;
    }

    public void setUserGroupKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey userGroupKey) {
        this.userGroupKey = userGroupKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseUserGroupClientLnk)) return false;
        BaseUserGroupClientLnk other = (BaseUserGroupClientLnk) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient()))) &&
            this.clientId == other.getClientId() &&
            ((this.clientKey==null && other.getClientKey()==null) || 
             (this.clientKey!=null &&
              this.clientKey.equals(other.getClientKey()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.userGroup==null && other.getUserGroup()==null) || 
             (this.userGroup!=null &&
              this.userGroup.equals(other.getUserGroup()))) &&
            this.userGroupId == other.getUserGroupId() &&
            ((this.userGroupKey==null && other.getUserGroupKey()==null) || 
             (this.userGroupKey!=null &&
              this.userGroupKey.equals(other.getUserGroupKey())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        _hashCode += getClientId();
        if (getClientKey() != null) {
            _hashCode += getClientKey().hashCode();
        }
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getUserGroup() != null) {
            _hashCode += getUserGroup().hashCode();
        }
        _hashCode += new Long(getUserGroupId()).hashCode();
        if (getUserGroupKey() != null) {
            _hashCode += getUserGroupKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseUserGroupClientLnk.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupClientLnk"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Client"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnkPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
