/**
 * BaseUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseUser  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.Address address;
    private long addressId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey addressKey;
    private net.sf.iquiver.remote.soap.impl.om.Client client;
    private int clientId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey clientKey;
    private net.sf.iquiver.remote.soap.impl.om.UserPeer peer;
    private java.util.Calendar userDateOfBirth;
    private java.lang.String userFirstName;
    private java.lang.String userGender;
    private java.lang.Object[] userGroupLnks;
    private long userId;
    private java.lang.String userLastName;
    private java.lang.String userLogin;
    private java.lang.String userMidName;
    private java.lang.String userPassword;
    private byte[] userPicture;

    public BaseUser() {
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

    public net.sf.iquiver.remote.soap.impl.om.UserPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.UserPeer peer) {
        this.peer = peer;
    }

    public java.util.Calendar getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(java.util.Calendar userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public java.lang.String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(java.lang.String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public java.lang.String getUserGender() {
        return userGender;
    }

    public void setUserGender(java.lang.String userGender) {
        this.userGender = userGender;
    }

    public java.lang.Object[] getUserGroupLnks() {
        return userGroupLnks;
    }

    public void setUserGroupLnks(java.lang.Object[] userGroupLnks) {
        this.userGroupLnks = userGroupLnks;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public java.lang.String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(java.lang.String userLastName) {
        this.userLastName = userLastName;
    }

    public java.lang.String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(java.lang.String userLogin) {
        this.userLogin = userLogin;
    }

    public java.lang.String getUserMidName() {
        return userMidName;
    }

    public void setUserMidName(java.lang.String userMidName) {
        this.userMidName = userMidName;
    }

    public java.lang.String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(java.lang.String userPassword) {
        this.userPassword = userPassword;
    }

    public byte[] getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(byte[] userPicture) {
        this.userPicture = userPicture;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseUser)) return false;
        BaseUser other = (BaseUser) obj;
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
            ((this.userDateOfBirth==null && other.getUserDateOfBirth()==null) || 
             (this.userDateOfBirth!=null &&
              this.userDateOfBirth.equals(other.getUserDateOfBirth()))) &&
            ((this.userFirstName==null && other.getUserFirstName()==null) || 
             (this.userFirstName!=null &&
              this.userFirstName.equals(other.getUserFirstName()))) &&
            ((this.userGender==null && other.getUserGender()==null) || 
             (this.userGender!=null &&
              this.userGender.equals(other.getUserGender()))) &&
            ((this.userGroupLnks==null && other.getUserGroupLnks()==null) || 
             (this.userGroupLnks!=null &&
              java.util.Arrays.equals(this.userGroupLnks, other.getUserGroupLnks()))) &&
            this.userId == other.getUserId() &&
            ((this.userLastName==null && other.getUserLastName()==null) || 
             (this.userLastName!=null &&
              this.userLastName.equals(other.getUserLastName()))) &&
            ((this.userLogin==null && other.getUserLogin()==null) || 
             (this.userLogin!=null &&
              this.userLogin.equals(other.getUserLogin()))) &&
            ((this.userMidName==null && other.getUserMidName()==null) || 
             (this.userMidName!=null &&
              this.userMidName.equals(other.getUserMidName()))) &&
            ((this.userPassword==null && other.getUserPassword()==null) || 
             (this.userPassword!=null &&
              this.userPassword.equals(other.getUserPassword()))) &&
            ((this.userPicture==null && other.getUserPicture()==null) || 
             (this.userPicture!=null &&
              java.util.Arrays.equals(this.userPicture, other.getUserPicture())));
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
        if (getUserDateOfBirth() != null) {
            _hashCode += getUserDateOfBirth().hashCode();
        }
        if (getUserFirstName() != null) {
            _hashCode += getUserFirstName().hashCode();
        }
        if (getUserGender() != null) {
            _hashCode += getUserGender().hashCode();
        }
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
        _hashCode += new Long(getUserId()).hashCode();
        if (getUserLastName() != null) {
            _hashCode += getUserLastName().hashCode();
        }
        if (getUserLogin() != null) {
            _hashCode += getUserLogin().hashCode();
        }
        if (getUserMidName() != null) {
            _hashCode += getUserMidName().hashCode();
        }
        if (getUserPassword() != null) {
            _hashCode += getUserPassword().hashCode();
        }
        if (getUserPicture() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserPicture());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserPicture(), i);
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
        new org.apache.axis.description.TypeDesc(BaseUser.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseUser"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "UserPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userDateOfBirth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userDateOfBirth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userFirstName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userFirstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userGroupLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userGroupLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userLastName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userLastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userLogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userLogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userMidName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userMidName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userPicture");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userPicture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
