/**
 * BaseContentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseContentType  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.ContentParser contentParser;
    private int contentParserId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentParserKey;
    private java.lang.String contentTypeDesc;
    private int contentTypeId;
    private java.lang.String contentTypeName;
    private net.sf.iquiver.remote.soap.impl.om.ContentTypePeer peer;

    public BaseContentType() {
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentParser getContentParser() {
        return contentParser;
    }

    public void setContentParser(net.sf.iquiver.remote.soap.impl.om.ContentParser contentParser) {
        this.contentParser = contentParser;
    }

    public int getContentParserId() {
        return contentParserId;
    }

    public void setContentParserId(int contentParserId) {
        this.contentParserId = contentParserId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getContentParserKey() {
        return contentParserKey;
    }

    public void setContentParserKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentParserKey) {
        this.contentParserKey = contentParserKey;
    }

    public java.lang.String getContentTypeDesc() {
        return contentTypeDesc;
    }

    public void setContentTypeDesc(java.lang.String contentTypeDesc) {
        this.contentTypeDesc = contentTypeDesc;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public java.lang.String getContentTypeName() {
        return contentTypeName;
    }

    public void setContentTypeName(java.lang.String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentTypePeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ContentTypePeer peer) {
        this.peer = peer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseContentType)) return false;
        BaseContentType other = (BaseContentType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contentParser==null && other.getContentParser()==null) || 
             (this.contentParser!=null &&
              this.contentParser.equals(other.getContentParser()))) &&
            this.contentParserId == other.getContentParserId() &&
            ((this.contentParserKey==null && other.getContentParserKey()==null) || 
             (this.contentParserKey!=null &&
              this.contentParserKey.equals(other.getContentParserKey()))) &&
            ((this.contentTypeDesc==null && other.getContentTypeDesc()==null) || 
             (this.contentTypeDesc!=null &&
              this.contentTypeDesc.equals(other.getContentTypeDesc()))) &&
            this.contentTypeId == other.getContentTypeId() &&
            ((this.contentTypeName==null && other.getContentTypeName()==null) || 
             (this.contentTypeName!=null &&
              this.contentTypeName.equals(other.getContentTypeName()))) &&
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
        if (getContentParser() != null) {
            _hashCode += getContentParser().hashCode();
        }
        _hashCode += getContentParserId();
        if (getContentParserKey() != null) {
            _hashCode += getContentParserKey().hashCode();
        }
        if (getContentTypeDesc() != null) {
            _hashCode += getContentTypeDesc().hashCode();
        }
        _hashCode += getContentTypeId();
        if (getContentTypeName() != null) {
            _hashCode += getContentTypeName().hashCode();
        }
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseContentType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseContentType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentParser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentParser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentParserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentParserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentParserKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentParserKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTypeDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTypeDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentTypePeer"));
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
