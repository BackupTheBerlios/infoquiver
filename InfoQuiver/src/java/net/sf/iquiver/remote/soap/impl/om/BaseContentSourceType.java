/**
 * BaseContentSourceType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseContentSourceType  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private java.lang.String contentSourceTypeDesc;
    private int contentSourceTypeId;
    private java.lang.String contentSourceTypeName;
    private java.lang.Object[] contentSources;
    private net.sf.iquiver.remote.soap.impl.om.ContentSourceTypePeer peer;

    public BaseContentSourceType() {
    }

    public java.lang.String getContentSourceTypeDesc() {
        return contentSourceTypeDesc;
    }

    public void setContentSourceTypeDesc(java.lang.String contentSourceTypeDesc) {
        this.contentSourceTypeDesc = contentSourceTypeDesc;
    }

    public int getContentSourceTypeId() {
        return contentSourceTypeId;
    }

    public void setContentSourceTypeId(int contentSourceTypeId) {
        this.contentSourceTypeId = contentSourceTypeId;
    }

    public java.lang.String getContentSourceTypeName() {
        return contentSourceTypeName;
    }

    public void setContentSourceTypeName(java.lang.String contentSourceTypeName) {
        this.contentSourceTypeName = contentSourceTypeName;
    }

    public java.lang.Object[] getContentSources() {
        return contentSources;
    }

    public void setContentSources(java.lang.Object[] contentSources) {
        this.contentSources = contentSources;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceTypePeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ContentSourceTypePeer peer) {
        this.peer = peer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseContentSourceType)) return false;
        BaseContentSourceType other = (BaseContentSourceType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contentSourceTypeDesc==null && other.getContentSourceTypeDesc()==null) || 
             (this.contentSourceTypeDesc!=null &&
              this.contentSourceTypeDesc.equals(other.getContentSourceTypeDesc()))) &&
            this.contentSourceTypeId == other.getContentSourceTypeId() &&
            ((this.contentSourceTypeName==null && other.getContentSourceTypeName()==null) || 
             (this.contentSourceTypeName!=null &&
              this.contentSourceTypeName.equals(other.getContentSourceTypeName()))) &&
            ((this.contentSources==null && other.getContentSources()==null) || 
             (this.contentSources!=null &&
              java.util.Arrays.equals(this.contentSources, other.getContentSources()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer())));
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
        if (getContentSourceTypeDesc() != null) {
            _hashCode += getContentSourceTypeDesc().hashCode();
        }
        _hashCode += getContentSourceTypeId();
        if (getContentSourceTypeName() != null) {
            _hashCode += getContentSourceTypeName().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseContentSourceType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourceType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTypeDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTypeDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSourceTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSourceTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSources");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSources"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTypePeer"));
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
