/**
 * BaseClient.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseClient  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.Address address;
    private long addressId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey addressKey;
    private java.lang.Object[] clientContentLnks;
    private int clientId;
    private java.lang.String clientName;
    private java.lang.Object[] clientTransportLnks;
    private net.sf.iquiver.remote.soap.impl.om.ClientPeer peer;
    private java.lang.Object[] userGroupClientLnks;
    private java.lang.Object[] userGroups;
    private java.lang.Object[] users;

    public BaseClient() {
    }

    public net.sf.iquiver.remote.soap.impl.om.Address getAddress() {
        return address;
    }

    public void setAddress(net.sf.iquiver.remote.soap.impl.om.Address address) {
        this.address = address;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey addressKey) {
        this.addressKey = addressKey;
    }

    public java.lang.Object[] getClientContentLnks() {
        return clientContentLnks;
    }

    public void setClientContentLnks(java.lang.Object[] clientContentLnks) {
        this.clientContentLnks = clientContentLnks;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public java.lang.String getClientName() {
        return clientName;
    }

    public void setClientName(java.lang.String clientName) {
        this.clientName = clientName;
    }

    public java.lang.Object[] getClientTransportLnks() {
        return clientTransportLnks;
    }

    public void setClientTransportLnks(java.lang.Object[] clientTransportLnks) {
        this.clientTransportLnks = clientTransportLnks;
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ClientPeer peer) {
        this.peer = peer;
    }

    public java.lang.Object[] getUserGroupClientLnks() {
        return userGroupClientLnks;
    }

    public void setUserGroupClientLnks(java.lang.Object[] userGroupClientLnks) {
        this.userGroupClientLnks = userGroupClientLnks;
    }

    public java.lang.Object[] getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(java.lang.Object[] userGroups) {
        this.userGroups = userGroups;
    }

    public java.lang.Object[] getUsers() {
        return users;
    }

    public void setUsers(java.lang.Object[] users) {
        this.users = users;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseClient)) return false;
        BaseClient other = (BaseClient) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            this.addressId == other.getAddressId() &&
            ((this.addressKey==null && other.getAddressKey()==null) || 
             (this.addressKey!=null &&
              this.addressKey.equals(other.getAddressKey()))) &&
            ((this.clientContentLnks==null && other.getClientContentLnks()==null) || 
             (this.clientContentLnks!=null &&
              java.util.Arrays.equals(this.clientContentLnks, other.getClientContentLnks()))) &&
            this.clientId == other.getClientId() &&
            ((this.clientName==null && other.getClientName()==null) || 
             (this.clientName!=null &&
              this.clientName.equals(other.getClientName()))) &&
            ((this.clientTransportLnks==null && other.getClientTransportLnks()==null) || 
             (this.clientTransportLnks!=null &&
              java.util.Arrays.equals(this.clientTransportLnks, other.getClientTransportLnks()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.userGroupClientLnks==null && other.getUserGroupClientLnks()==null) || 
             (this.userGroupClientLnks!=null &&
              java.util.Arrays.equals(this.userGroupClientLnks, other.getUserGroupClientLnks()))) &&
            ((this.userGroups==null && other.getUserGroups()==null) || 
             (this.userGroups!=null &&
              java.util.Arrays.equals(this.userGroups, other.getUserGroups()))) &&
            ((this.users==null && other.getUsers()==null) || 
             (this.users!=null &&
              java.util.Arrays.equals(this.users, other.getUsers())));
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        _hashCode += new Long(getAddressId()).hashCode();
        if (getAddressKey() != null) {
            _hashCode += getAddressKey().hashCode();
        }
        if (getClientContentLnks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientContentLnks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientContentLnks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getClientId();
        if (getClientName() != null) {
            _hashCode += getClientName().hashCode();
        }
        if (getClientTransportLnks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientTransportLnks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientTransportLnks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getUserGroups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserGroups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserGroups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUsers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUsers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUsers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseClient.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseClient"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Address"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientContentLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientContentLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientTransportLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientTransportLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ClientPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupClientLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupClientLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("users");
        elemField.setXmlName(new javax.xml.namespace.QName("", "users"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
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
