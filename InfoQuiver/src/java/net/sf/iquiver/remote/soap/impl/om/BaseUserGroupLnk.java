/**
 * BaseUserGroupLnk.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseUserGroupLnk  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.UserGroupLnkPeer peer;
    private net.sf.iquiver.remote.soap.impl.om.User user;
    private net.sf.iquiver.remote.soap.impl.om.UserGroup userGroup;
    private long userGroupId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey userGroupKey;
    private long userId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey userKey;

    public BaseUserGroupLnk() {
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupLnkPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.UserGroupLnkPeer peer) {
        this.peer = peer;
    }

    public net.sf.iquiver.remote.soap.impl.om.User getUser() {
        return user;
    }

    public void setUser(net.sf.iquiver.remote.soap.impl.om.User user) {
        this.user = user;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getUserKey() {
        return userKey;
    }

    public void setUserKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey userKey) {
        this.userKey = userKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseUserGroupLnk)) return false;
        BaseUserGroupLnk other = (BaseUserGroupLnk) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.userGroup==null && other.getUserGroup()==null) || 
             (this.userGroup!=null &&
              this.userGroup.equals(other.getUserGroup()))) &&
            this.userGroupId == other.getUserGroupId() &&
            ((this.userGroupKey==null && other.getUserGroupKey()==null) || 
             (this.userGroupKey!=null &&
              this.userGroupKey.equals(other.getUserGroupKey()))) &&
            this.userId == other.getUserId() &&
            ((this.userKey==null && other.getUserKey()==null) || 
             (this.userKey!=null &&
              this.userKey.equals(other.getUserKey())));
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
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getUserGroup() != null) {
            _hashCode += getUserGroup().hashCode();
        }
        _hashCode += new Long(getUserGroupId()).hashCode();
        if (getUserGroupKey() != null) {
            _hashCode += getUserGroupKey().hashCode();
        }
        _hashCode += new Long(getUserId()).hashCode();
        if (getUserKey() != null) {
            _hashCode += getUserKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseUserGroupLnk.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupLnk"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnkPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "User"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userKey"));
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
