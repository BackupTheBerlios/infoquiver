/**
 * BaseContentSource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseContentSource  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private java.lang.String contentSourceDesc;
    private long contentSourceId;
    private java.lang.String contentSourceName;
    private java.lang.Object[] contentSourceTransportConfigs;
    private net.sf.iquiver.remote.soap.impl.om.ContentSourceType contentSourceType;
    private int contentSourceTypeId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentSourceTypeKey;
    private long contentSourceUpdateTimespan;
    private java.lang.Object[] contents;
    private boolean isAuthentificationRequired;
    private net.sf.iquiver.remote.soap.impl.om.ContentSourcePeer peer;
    private net.sf.iquiver.remote.soap.impl.om.Publisher publisher;
    private int publisherId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey publisherKey;
    private net.sf.iquiver.remote.soap.impl.om.Transport transport;
    private int transportId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey transportKey;

    public BaseContentSource() {
    }

    public java.lang.String getContentSourceDesc() {
        return contentSourceDesc;
    }

    public void setContentSourceDesc(java.lang.String contentSourceDesc) {
        this.contentSourceDesc = contentSourceDesc;
    }

    public long getContentSourceId() {
        return contentSourceId;
    }

    public void setContentSourceId(long contentSourceId) {
        this.contentSourceId = contentSourceId;
    }

    public java.lang.String getContentSourceName() {
        return contentSourceName;
    }

    public void setContentSourceName(java.lang.String contentSourceName) {
        this.contentSourceName = contentSourceName;
    }

    public java.lang.Object[] getContentSourceTransportConfigs() {
        return contentSourceTransportConfigs;
    }

    public void setContentSourceTransportConfigs(java.lang.Object[] contentSourceTransportConfigs) {
        this.contentSourceTransportConfigs = contentSourceTransportConfigs;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceType getContentSourceType() {
        return contentSourceType;
    }

    public void setContentSourceType(net.sf.iquiver.remote.soap.impl.om.ContentSourceType contentSourceType) {
        this.contentSourceType = contentSourceType;
    }

    public int getContentSourceTypeId() {
        return contentSourceTypeId;
    }

    public void setContentSourceTypeId(int contentSourceTypeId) {
        this.contentSourceTypeId = contentSourceTypeId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getContentSourceTypeKey() {
        return contentSourceTypeKey;
    }

    public void setContentSourceTypeKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentSourceTypeKey) {
        this.contentSourceTypeKey = contentSourceTypeKey;
    }

    public long getContentSourceUpdateTimespan() {
        return contentSourceUpdateTimespan;
    }

    public void setContentSourceUpdateTimespan(long contentSourceUpdateTimespan) {
        this.contentSourceUpdateTimespan = contentSourceUpdateTimespan;
    }

    public java.lang.Object[] getContents() {
        return contents;
    }

    public void setContents(java.lang.Object[] contents) {
        this.contents = contents;
    }

    public boolean isIsAuthentificationRequired() {
        return isAuthentificationRequired;
    }

    public void setIsAuthentificationRequired(boolean isAuthentificationRequired) {
        this.isAuthentificationRequired = isAuthentificationRequired;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourcePeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ContentSourcePeer peer) {
        this.peer = peer;
    }

    public net.sf.iquiver.remote.soap.impl.om.Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(net.sf.iquiver.remote.soap.impl.om.Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getPublisherKey() {
        return publisherKey;
    }

    public void setPublisherKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey publisherKey) {
        this.publisherKey = publisherKey;
    }

    public net.sf.iquiver.remote.soap.impl.om.Transport getTransport() {
        return transport;
    }

    public void setTransport(net.sf.iquiver.remote.soap.impl.om.Transport transport) {
        this.transport = transport;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getTransportKey() {
        return transportKey;
    }

    public void setTransportKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey transportKey) {
        this.transportKey = transportKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseContentSource)) return false;
        BaseContentSource other = (BaseContentSource) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contentSourceDesc==null && other.getContentSourceDesc()==null) || 
             (this.contentSourceDesc!=null &&
              this.contentSourceDesc.equals(other.getContentSourceDesc()))) &&
            this.contentSourceId == other.getContentSourceId() &&
            ((this.contentSourceName==null && other.getContentSourceName()==null) || 
             (this.contentSourceName!=null &&
              this.contentSourceName.equals(other.getContentSourceName()))) &&
            ((this.contentSourceTransportConfigs==null && other.getContentSourceTransportConfigs()==null) || 
             (this.contentSourceTransportConfigs!=null &&
              java.util.Arrays.equals(this.contentSourceTransportConfigs, other.getContentSourceTransportConfigs()))) &&
            ((this.contentSourceType==null && other.getContentSourceType()==null) || 
             (this.contentSourceType!=null &&
              this.contentSourceType.equals(other.getContentSourceType()))) &&
            this.contentSourceTypeId == other.getContentSourceTypeId() &&
            ((this.contentSourceTypeKey==null && other.getContentSourceTypeKey()==null) || 
             (this.contentSourceTypeKey!=null &&
              this.contentSourceTypeKey.equals(other.getContentSourceTypeKey()))) &&
            this.contentSourceUpdateTimespan == other.getContentSourceUpdateTimespan() &&
            ((this.contents==null && other.getContents()==null) || 
             (this.contents!=null &&
              java.util.Arrays.equals(this.contents, other.getContents()))) &&
            this.isAuthentificationRequired == other.isIsAuthentificationRequired() &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.publisher==null && other.getPublisher()==null) || 
             (this.publisher!=null &&
              this.publisher.equals(other.getPublisher()))) &&
            this.publisherId == other.getPublisherId() &&
            ((this.publisherKey==null && other.getPublisherKey()==null) || 
             (this.publisherKey!=null &&
              this.publisherKey.equals(other.getPublisherKey()))) &&
            ((this.transport==null && other.getTransport()==null) || 
             (this.transport!=null &&
              this.transport.equals(other.getTransport()))) &&
            this.transportId == other.getTransportId() &&
            ((this.transportKey==null && other.getTransportKey()==null) || 
             (this.transportKey!=null &&
              this.transportKey.equals(other.getTransportKey())));
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
        if (getContentSourceDesc() != null) {
            _hashCode += getContentSourceDesc().hashCode();
        }
        _hashCode += new Long(getContentSourceId()).hashCode();
        if (getContentSourceName() != null) {
            _hashCode += getContentSourceName().hashCode();
        }
        if (getContentSourceTransportConfigs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContentSourceTransportConfigs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContentSourceTransportConfigs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContentSourceType() != null) {
            _hashCode += getContentSourceType().hashCode();
        }
        _hashCode += getContentSourceTypeId();
        if (getContentSourceTypeKey() != null) {
            _hashCode += getContentSourceTypeKey().hashCode();
        }
        _hashCode += new Long(getContentSourceUpdateTimespan()).hashCode();
        if (getContents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Boolean(isIsAuthentificationRequired()).hashCode();
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getPublisher() != null) {
            _hashCode += getPublisher().hashCode();
        }
        _hashCode += getPublisherId();
        if (getPublisherKey() != null) {
            _hashCode += getPublisherKey().hashCode();
        }
        if (getTransport() != null) {
            _hashCode += getTransport().hashCode();
        }
        _hashCode += getTransportId();
        if (getTransportKey() != null) {
            _hashCode += getTransportKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseContentSource.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSource"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTransportConfigs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTransportConfigs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceUpdateTimespan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceUpdateTimespan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAuthentificationRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAuthentificationRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourcePeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisher");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisher"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Publisher"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisherId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publisherKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Transport"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportKey"));
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
