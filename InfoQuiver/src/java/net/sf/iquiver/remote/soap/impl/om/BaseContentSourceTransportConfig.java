/**
 * BaseContentSourceTransportConfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseContentSourceTransportConfig  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.ContentSource contentSource;
    private long contentSourceId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentSourceKey;
    private net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfigPeer peer;
    private net.sf.iquiver.remote.soap.impl.om.TransportAttribute transportAttribute;
    private int transportAttributeId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey transportAttributeKey;
    private java.lang.String transportAttributeValue;

    public BaseContentSourceTransportConfig() {
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSource getContentSource() {
        return contentSource;
    }

    public void setContentSource(net.sf.iquiver.remote.soap.impl.om.ContentSource contentSource) {
        this.contentSource = contentSource;
    }

    public long getContentSourceId() {
        return contentSourceId;
    }

    public void setContentSourceId(long contentSourceId) {
        this.contentSourceId = contentSourceId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getContentSourceKey() {
        return contentSourceKey;
    }

    public void setContentSourceKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentSourceKey) {
        this.contentSourceKey = contentSourceKey;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfigPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfigPeer peer) {
        this.peer = peer;
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportAttribute getTransportAttribute() {
        return transportAttribute;
    }

    public void setTransportAttribute(net.sf.iquiver.remote.soap.impl.om.TransportAttribute transportAttribute) {
        this.transportAttribute = transportAttribute;
    }

    public int getTransportAttributeId() {
        return transportAttributeId;
    }

    public void setTransportAttributeId(int transportAttributeId) {
        this.transportAttributeId = transportAttributeId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getTransportAttributeKey() {
        return transportAttributeKey;
    }

    public void setTransportAttributeKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey transportAttributeKey) {
        this.transportAttributeKey = transportAttributeKey;
    }

    public java.lang.String getTransportAttributeValue() {
        return transportAttributeValue;
    }

    public void setTransportAttributeValue(java.lang.String transportAttributeValue) {
        this.transportAttributeValue = transportAttributeValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseContentSourceTransportConfig)) return false;
        BaseContentSourceTransportConfig other = (BaseContentSourceTransportConfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contentSource==null && other.getContentSource()==null) || 
             (this.contentSource!=null &&
              this.contentSource.equals(other.getContentSource()))) &&
            this.contentSourceId == other.getContentSourceId() &&
            ((this.contentSourceKey==null && other.getContentSourceKey()==null) || 
             (this.contentSourceKey!=null &&
              this.contentSourceKey.equals(other.getContentSourceKey()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.transportAttribute==null && other.getTransportAttribute()==null) || 
             (this.transportAttribute!=null &&
              this.transportAttribute.equals(other.getTransportAttribute()))) &&
            this.transportAttributeId == other.getTransportAttributeId() &&
            ((this.transportAttributeKey==null && other.getTransportAttributeKey()==null) || 
             (this.transportAttributeKey!=null &&
              this.transportAttributeKey.equals(other.getTransportAttributeKey()))) &&
            ((this.transportAttributeValue==null && other.getTransportAttributeValue()==null) || 
             (this.transportAttributeValue!=null &&
              this.transportAttributeValue.equals(other.getTransportAttributeValue())));
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
        if (getContentSource() != null) {
            _hashCode += getContentSource().hashCode();
        }
        _hashCode += new Long(getContentSourceId()).hashCode();
        if (getContentSourceKey() != null) {
            _hashCode += getContentSourceKey().hashCode();
        }
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getTransportAttribute() != null) {
            _hashCode += getTransportAttribute().hashCode();
        }
        _hashCode += getTransportAttributeId();
        if (getTransportAttributeKey() != null) {
            _hashCode += getTransportAttributeKey().hashCode();
        }
        if (getTransportAttributeValue() != null) {
            _hashCode += getTransportAttributeValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseContentSourceTransportConfig.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourceTransportConfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfigPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttribute");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributeValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributeValue"));
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
