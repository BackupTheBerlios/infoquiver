/**
 * BaseContentParser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseContentParser  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private int contentParserId;
    private java.lang.String contentParserImplementation;
    private java.lang.String contentParserName;
    private java.lang.Object[] contentTypes;
    private net.sf.iquiver.remote.soap.impl.om.ContentParserPeer peer;

    public BaseContentParser() {
    }

    public int getContentParserId() {
        return contentParserId;
    }

    public void setContentParserId(int contentParserId) {
        this.contentParserId = contentParserId;
    }

    public java.lang.String getContentParserImplementation() {
        return contentParserImplementation;
    }

    public void setContentParserImplementation(java.lang.String contentParserImplementation) {
        this.contentParserImplementation = contentParserImplementation;
    }

    public java.lang.String getContentParserName() {
        return contentParserName;
    }

    public void setContentParserName(java.lang.String contentParserName) {
        this.contentParserName = contentParserName;
    }

    public java.lang.Object[] getContentTypes() {
        return contentTypes;
    }

    public void setContentTypes(java.lang.Object[] contentTypes) {
        this.contentTypes = contentTypes;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentParserPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ContentParserPeer peer) {
        this.peer = peer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseContentParser)) return false;
        BaseContentParser other = (BaseContentParser) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.contentParserId == other.getContentParserId() &&
            ((this.contentParserImplementation==null && other.getContentParserImplementation()==null) || 
             (this.contentParserImplementation!=null &&
              this.contentParserImplementation.equals(other.getContentParserImplementation()))) &&
            ((this.contentParserName==null && other.getContentParserName()==null) || 
             (this.contentParserName!=null &&
              this.contentParserName.equals(other.getContentParserName()))) &&
            ((this.contentTypes==null && other.getContentTypes()==null) || 
             (this.contentTypes!=null &&
              java.util.Arrays.equals(this.contentTypes, other.getContentTypes()))) &&
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
        _hashCode += getContentParserId();
        if (getContentParserImplementation() != null) {
            _hashCode += getContentParserImplementation().hashCode();
        }
        if (getContentParserName() != null) {
            _hashCode += getContentParserName().hashCode();
        }
        if (getContentTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContentTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContentTypes(), i);
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
        new org.apache.axis.description.TypeDesc(BaseContentParser.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseContentParser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentParserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentParserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentParserImplementation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentParserImplementation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentParserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentParserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentParserPeer"));
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
