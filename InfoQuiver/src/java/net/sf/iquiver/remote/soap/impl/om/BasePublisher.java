/**
 * BasePublisher.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BasePublisher  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.Address address;
    private long addressId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey addressKey;
    private java.lang.Object[] contentSources;
    private net.sf.iquiver.remote.soap.impl.om.PublisherPeer peer;
    private int publisherId;
    private byte[] publisherLogo;
    private java.lang.String publisherName;

    public BasePublisher() {
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

    public java.lang.Object[] getContentSources() {
        return contentSources;
    }

    public void setContentSources(java.lang.Object[] contentSources) {
        this.contentSources = contentSources;
    }

    public net.sf.iquiver.remote.soap.impl.om.PublisherPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.PublisherPeer peer) {
        this.peer = peer;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public byte[] getPublisherLogo() {
        return publisherLogo;
    }

    public void setPublisherLogo(byte[] publisherLogo) {
        this.publisherLogo = publisherLogo;
    }

    public java.lang.String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(java.lang.String publisherName) {
        this.publisherName = publisherName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BasePublisher)) return false;
        BasePublisher other = (BasePublisher) obj;
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
            ((this.contentSources==null && other.getContentSources()==null) || 
             (this.contentSources!=null &&
              java.util.Arrays.equals(this.contentSources, other.getContentSources()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            this.publisherId == other.getPublisherId() &&
            ((this.publisherLogo==null && other.getPublisherLogo()==null) || 
             (this.publisherLogo!=null &&
              java.util.Arrays.equals(this.publisherLogo, other.getPublisherLogo()))) &&
            ((this.publisherName==null && other.getPublisherName()==null) || 
             (this.publisherName!=null &&
              this.publisherName.equals(other.getPublisherName())));
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
        if (getContentSources() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContentSources());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContentSources(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        _hashCode += getPublisherId();
        if (getPublisherLogo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublisherLogo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublisherLogo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPublisherName() != null) {
            _hashCode += getPublisherName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BasePublisher.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BasePublisher"));
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
        elemField.setFieldName("contentSources");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSources"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "PublisherPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisherId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherLogo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisherLogo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisherName"));
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
