/**
 * ContentSource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public class ContentSource  extends net.sf.iquiver.remote.soap.impl.om.BaseContentSource  implements java.io.Serializable {
    private java.lang.Object[] authentificationAttributes;
    private java.util.HashMap authentificationAttributesAsNamedMap;
    private java.lang.Object[] nonAuthentificationAttributes;
    private java.util.HashMap nonAuthentificationAttributesAsNamedMap;

    public ContentSource() {
    }

    public java.lang.Object[] getAuthentificationAttributes() {
        return authentificationAttributes;
    }

    public void setAuthentificationAttributes(java.lang.Object[] authentificationAttributes) {
        this.authentificationAttributes = authentificationAttributes;
    }

    public java.util.HashMap getAuthentificationAttributesAsNamedMap() {
        return authentificationAttributesAsNamedMap;
    }

    public void setAuthentificationAttributesAsNamedMap(java.util.HashMap authentificationAttributesAsNamedMap) {
        this.authentificationAttributesAsNamedMap = authentificationAttributesAsNamedMap;
    }

    public java.lang.Object[] getNonAuthentificationAttributes() {
        return nonAuthentificationAttributes;
    }

    public void setNonAuthentificationAttributes(java.lang.Object[] nonAuthentificationAttributes) {
        this.nonAuthentificationAttributes = nonAuthentificationAttributes;
    }

    public java.util.HashMap getNonAuthentificationAttributesAsNamedMap() {
        return nonAuthentificationAttributesAsNamedMap;
    }

    public void setNonAuthentificationAttributesAsNamedMap(java.util.HashMap nonAuthentificationAttributesAsNamedMap) {
        this.nonAuthentificationAttributesAsNamedMap = nonAuthentificationAttributesAsNamedMap;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContentSource)) return false;
        ContentSource other = (ContentSource) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.authentificationAttributes==null && other.getAuthentificationAttributes()==null) || 
             (this.authentificationAttributes!=null &&
              java.util.Arrays.equals(this.authentificationAttributes, other.getAuthentificationAttributes()))) &&
            ((this.authentificationAttributesAsNamedMap==null && other.getAuthentificationAttributesAsNamedMap()==null) || 
             (this.authentificationAttributesAsNamedMap!=null &&
              this.authentificationAttributesAsNamedMap.equals(other.getAuthentificationAttributesAsNamedMap()))) &&
            ((this.nonAuthentificationAttributes==null && other.getNonAuthentificationAttributes()==null) || 
             (this.nonAuthentificationAttributes!=null &&
              java.util.Arrays.equals(this.nonAuthentificationAttributes, other.getNonAuthentificationAttributes()))) &&
            ((this.nonAuthentificationAttributesAsNamedMap==null && other.getNonAuthentificationAttributesAsNamedMap()==null) || 
             (this.nonAuthentificationAttributesAsNamedMap!=null &&
              this.nonAuthentificationAttributesAsNamedMap.equals(other.getNonAuthentificationAttributesAsNamedMap())));
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
        if (getAuthentificationAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuthentificationAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuthentificationAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAuthentificationAttributesAsNamedMap() != null) {
            _hashCode += getAuthentificationAttributesAsNamedMap().hashCode();
        }
        if (getNonAuthentificationAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNonAuthentificationAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNonAuthentificationAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNonAuthentificationAttributesAsNamedMap() != null) {
            _hashCode += getNonAuthentificationAttributesAsNamedMap().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContentSource.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authentificationAttributes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authentificationAttributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authentificationAttributesAsNamedMap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authentificationAttributesAsNamedMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nonAuthentificationAttributes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nonAuthentificationAttributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nonAuthentificationAttributesAsNamedMap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nonAuthentificationAttributesAsNamedMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"));
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
