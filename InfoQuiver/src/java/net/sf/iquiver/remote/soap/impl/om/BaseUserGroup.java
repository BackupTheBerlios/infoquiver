/**
 * BaseUserGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseUserGroup  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.Client client;
    private int clientId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey clientKey;
    private net.sf.iquiver.remote.soap.impl.om.UserGroupPeer peer;
    private java.lang.Object[] userGroupClientLnks;
    private java.lang.String userGroupDesc;
    private long userGroupId;
    private java.lang.Object[] userGroupLnks;
    private java.lang.String userGroupName;

    public BaseUserGroup() {
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

    public net.sf.iquiver.remote.soap.impl.om.UserGroupPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.UserGroupPeer peer) {
        this.peer = peer;
    }

    public java.lang.Object[] getUserGroupClientLnks() {
        return userGroupClientLnks;
    }

    public void setUserGroupClientLnks(java.lang.Object[] userGroupClientLnks) {
        this.userGroupClientLnks = userGroupClientLnks;
    }

    public java.lang.String getUserGroupDesc() {
        return userGroupDesc;
    }

    public void setUserGroupDesc(java.lang.String userGroupDesc) {
        this.userGroupDesc = userGroupDesc;
    }

    public long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public java.lang.Object[] getUserGroupLnks() {
        return userGroupLnks;
    }

    public void setUserGroupLnks(java.lang.Object[] userGroupLnks) {
        this.userGroupLnks = userGroupLnks;
    }

    public java.lang.String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(java.lang.String userGroupName) {
        this.userGroupName = userGroupName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseUserGroup)) return false;
        BaseUserGroup other = (BaseUserGroup) obj;
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
            ((this.userGroupClientLnks==null && other.getUserGroupClientLnks()==null) || 
             (this.userGroupClientLnks!=null &&
              java.util.Arrays.equals(this.userGroupClientLnks, other.getUserGroupClientLnks()))) &&
            ((this.userGroupDesc==null && other.getUserGroupDesc()==null) || 
             (this.userGroupDesc!=null &&
              this.userGroupDesc.equals(other.getUserGroupDesc()))) &&
            this.userGroupId == other.getUserGroupId() &&
            ((this.userGroupLnks==null && other.getUserGroupLnks()==null) || 
             (this.userGroupLnks!=null &&
              java.util.Arrays.equals(this.userGroupLnks, other.getUserGroupLnks()))) &&
            ((this.userGroupName==null && other.getUserGroupName()==null) || 
             (this.userGroupName!=null &&
              this.userGroupName.equals(other.getUserGroupName())));
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
        if (getUserGroupClientLnks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserGroupClientLnks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserGroupClientLnks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUserGroupDesc() != null) {
            _hashCode += getUserGroupDesc().hashCode();
        }
        _hashCode += new Long(getUserGroupId()).hashCode();
        if (getUserGroupLnks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserGroupLnks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserGroupLnks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUserGroupName() != null) {
            _hashCode += getUserGroupName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseUserGroup.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroup"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupClientLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupClientLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
