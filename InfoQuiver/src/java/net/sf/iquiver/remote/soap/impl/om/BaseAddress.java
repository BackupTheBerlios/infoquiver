/**
 * BaseAddress.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseAddress  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private java.lang.String addressCountry;
    private java.lang.String addressEmail;
    private long addressId;
    private java.lang.String addressMobile;
    private java.lang.String addressName;
    private java.lang.String addressNumber;
    private java.lang.String addressPhone;
    private java.lang.String addressPoBox;
    private java.lang.String addressPoBoxZip;
    private java.lang.String addressStreet;
    private java.lang.String addressUrl;
    private java.lang.String addressZip;
    private java.lang.Object[] clients;
    private net.sf.iquiver.remote.soap.impl.om.AddressPeer peer;
    private java.lang.Object[] publishers;
    private java.lang.Object[] users;

    public BaseAddress() {
    }

    public java.lang.String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(java.lang.String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public java.lang.String getAddressEmail() {
        return addressEmail;
    }

    public void setAddressEmail(java.lang.String addressEmail) {
        this.addressEmail = addressEmail;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public java.lang.String getAddressMobile() {
        return addressMobile;
    }

    public void setAddressMobile(java.lang.String addressMobile) {
        this.addressMobile = addressMobile;
    }

    public java.lang.String getAddressName() {
        return addressName;
    }

    public void setAddressName(java.lang.String addressName) {
        this.addressName = addressName;
    }

    public java.lang.String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(java.lang.String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public java.lang.String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(java.lang.String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public java.lang.String getAddressPoBox() {
        return addressPoBox;
    }

    public void setAddressPoBox(java.lang.String addressPoBox) {
        this.addressPoBox = addressPoBox;
    }

    public java.lang.String getAddressPoBoxZip() {
        return addressPoBoxZip;
    }

    public void setAddressPoBoxZip(java.lang.String addressPoBoxZip) {
        this.addressPoBoxZip = addressPoBoxZip;
    }

    public java.lang.String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(java.lang.String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public java.lang.String getAddressUrl() {
        return addressUrl;
    }

    public void setAddressUrl(java.lang.String addressUrl) {
        this.addressUrl = addressUrl;
    }

    public java.lang.String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(java.lang.String addressZip) {
        this.addressZip = addressZip;
    }

    public java.lang.Object[] getClients() {
        return clients;
    }

    public void setClients(java.lang.Object[] clients) {
        this.clients = clients;
    }

    public net.sf.iquiver.remote.soap.impl.om.AddressPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.AddressPeer peer) {
        this.peer = peer;
    }

    public java.lang.Object[] getPublishers() {
        return publishers;
    }

    public void setPublishers(java.lang.Object[] publishers) {
        this.publishers = publishers;
    }

    public java.lang.Object[] getUsers() {
        return users;
    }

    public void setUsers(java.lang.Object[] users) {
        this.users = users;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseAddress)) return false;
        BaseAddress other = (BaseAddress) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.addressCountry==null && other.getAddressCountry()==null) || 
             (this.addressCountry!=null &&
              this.addressCountry.equals(other.getAddressCountry()))) &&
            ((this.addressEmail==null && other.getAddressEmail()==null) || 
             (this.addressEmail!=null &&
              this.addressEmail.equals(other.getAddressEmail()))) &&
            this.addressId == other.getAddressId() &&
            ((this.addressMobile==null && other.getAddressMobile()==null) || 
             (this.addressMobile!=null &&
              this.addressMobile.equals(other.getAddressMobile()))) &&
            ((this.addressName==null && other.getAddressName()==null) || 
             (this.addressName!=null &&
              this.addressName.equals(other.getAddressName()))) &&
            ((this.addressNumber==null && other.getAddressNumber()==null) || 
             (this.addressNumber!=null &&
              this.addressNumber.equals(other.getAddressNumber()))) &&
            ((this.addressPhone==null && other.getAddressPhone()==null) || 
             (this.addressPhone!=null &&
              this.addressPhone.equals(other.getAddressPhone()))) &&
            ((this.addressPoBox==null && other.getAddressPoBox()==null) || 
             (this.addressPoBox!=null &&
              this.addressPoBox.equals(other.getAddressPoBox()))) &&
            ((this.addressPoBoxZip==null && other.getAddressPoBoxZip()==null) || 
             (this.addressPoBoxZip!=null &&
              this.addressPoBoxZip.equals(other.getAddressPoBoxZip()))) &&
            ((this.addressStreet==null && other.getAddressStreet()==null) || 
             (this.addressStreet!=null &&
              this.addressStreet.equals(other.getAddressStreet()))) &&
            ((this.addressUrl==null && other.getAddressUrl()==null) || 
             (this.addressUrl!=null &&
              this.addressUrl.equals(other.getAddressUrl()))) &&
            ((this.addressZip==null && other.getAddressZip()==null) || 
             (this.addressZip!=null &&
              this.addressZip.equals(other.getAddressZip()))) &&
            ((this.clients==null && other.getClients()==null) || 
             (this.clients!=null &&
              java.util.Arrays.equals(this.clients, other.getClients()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.publishers==null && other.getPublishers()==null) || 
             (this.publishers!=null &&
              java.util.Arrays.equals(this.publishers, other.getPublishers()))) &&
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
        if (getAddressCountry() != null) {
            _hashCode += getAddressCountry().hashCode();
        }
        if (getAddressEmail() != null) {
            _hashCode += getAddressEmail().hashCode();
        }
        _hashCode += new Long(getAddressId()).hashCode();
        if (getAddressMobile() != null) {
            _hashCode += getAddressMobile().hashCode();
        }
        if (getAddressName() != null) {
            _hashCode += getAddressName().hashCode();
        }
        if (getAddressNumber() != null) {
            _hashCode += getAddressNumber().hashCode();
        }
        if (getAddressPhone() != null) {
            _hashCode += getAddressPhone().hashCode();
        }
        if (getAddressPoBox() != null) {
            _hashCode += getAddressPoBox().hashCode();
        }
        if (getAddressPoBoxZip() != null) {
            _hashCode += getAddressPoBoxZip().hashCode();
        }
        if (getAddressStreet() != null) {
            _hashCode += getAddressStreet().hashCode();
        }
        if (getAddressUrl() != null) {
            _hashCode += getAddressUrl().hashCode();
        }
        if (getAddressZip() != null) {
            _hashCode += getAddressZip().hashCode();
        }
        if (getClients() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClients());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClients(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getPublishers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublishers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublishers(), i);
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
        new org.apache.axis.description.TypeDesc(BaseAddress.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseAddress"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressPoBox");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressPoBox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressPoBoxZip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressPoBoxZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressStreet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressStreet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressZip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clients");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clients"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "AddressPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publishers"));
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
