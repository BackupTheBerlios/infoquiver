/**
 * BaseTransportAttribute.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseTransportAttribute  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private java.lang.Object[] contentSourceTransportConfigs;
    private boolean isMandatory;
    private boolean isPartOfAuthentification;
    private net.sf.iquiver.remote.soap.impl.om.TransportAttributePeer peer;
    private net.sf.iquiver.remote.soap.impl.om.Transport transport;
    private int transportAttributeId;
    private java.lang.String transportAttributeName;
    private java.lang.String transportAttributeType;
    private int transportId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey transportKey;

    public BaseTransportAttribute() {
    }

    public java.lang.Object[] getContentSourceTransportConfigs() {
        return contentSourceTransportConfigs;
    }

    public void setContentSourceTransportConfigs(java.lang.Object[] contentSourceTransportConfigs) {
        this.contentSourceTransportConfigs = contentSourceTransportConfigs;
    }

    public boolean isIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public boolean isIsPartOfAuthentification() {
        return isPartOfAuthentification;
    }

    public void setIsPartOfAuthentification(boolean isPartOfAuthentification) {
        this.isPartOfAuthentification = isPartOfAuthentification;
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportAttributePeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.TransportAttributePeer peer) {
        this.peer = peer;
    }

    public net.sf.iquiver.remote.soap.impl.om.Transport getTransport() {
        return transport;
    }

    public void setTransport(net.sf.iquiver.remote.soap.impl.om.Transport transport) {
        this.transport = transport;
    }

    public int getTransportAttributeId() {
        return transportAttributeId;
    }

    public void setTransportAttributeId(int transportAttributeId) {
        this.transportAttributeId = transportAttributeId;
    }

    public java.lang.String getTransportAttributeName() {
        return transportAttributeName;
    }

    public void setTransportAttributeName(java.lang.String transportAttributeName) {
        this.transportAttributeName = transportAttributeName;
    }

    public java.lang.String getTransportAttributeType() {
        return transportAttributeType;
    }

    public void setTransportAttributeType(java.lang.String transportAttributeType) {
        this.transportAttributeType = transportAttributeType;
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
        if (!(obj instanceof BaseTransportAttribute)) return false;
        BaseTransportAttribute other = (BaseTransportAttribute) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contentSourceTransportConfigs==null && other.getContentSourceTransportConfigs()==null) || 
             (this.contentSourceTransportConfigs!=null &&
              java.util.Arrays.equals(this.contentSourceTransportConfigs, other.getContentSourceTransportConfigs()))) &&
            this.isMandatory == other.isIsMandatory() &&
            this.isPartOfAuthentification == other.isIsPartOfAuthentification() &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.transport==null && other.getTransport()==null) || 
             (this.transport!=null &&
              this.transport.equals(other.getTransport()))) &&
            this.transportAttributeId == other.getTransportAttributeId() &&
            ((this.transportAttributeName==null && other.getTransportAttributeName()==null) || 
             (this.transportAttributeName!=null &&
              this.transportAttributeName.equals(other.getTransportAttributeName()))) &&
            ((this.transportAttributeType==null && other.getTransportAttributeType()==null) || 
             (this.transportAttributeType!=null &&
              this.transportAttributeType.equals(other.getTransportAttributeType()))) &&
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
        _hashCode += new Boolean(isIsMandatory()).hashCode();
        _hashCode += new Boolean(isIsPartOfAuthentification()).hashCode();
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getTransport() != null) {
            _hashCode += getTransport().hashCode();
        }
        _hashCode += getTransportAttributeId();
        if (getTransportAttributeName() != null) {
            _hashCode += getTransportAttributeName().hashCode();
        }
        if (getTransportAttributeType() != null) {
            _hashCode += getTransportAttributeType().hashCode();
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
        new org.apache.axis.description.TypeDesc(BaseTransportAttribute.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseTransportAttribute"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTransportConfigs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTransportConfigs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMandatory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMandatory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPartOfAuthentification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPartOfAuthentification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "TransportAttributePeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Transport"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
