/**
 * BaseTransport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseTransport  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private java.lang.Object[] clientTransportLnks;
    private java.lang.Object[] contentSources;
    private boolean isAuthentificationRequired;
    private net.sf.iquiver.remote.soap.impl.om.TransportPeer peer;
    private java.lang.Object[] transportAttributes;
    private java.lang.String transportDesc;
    private int transportId;
    private java.lang.String transportImplementation;
    private java.lang.String transportName;
    private java.util.Calendar transportStartTimeout;
    private byte transportType;

    public BaseTransport() {
    }

    public java.lang.Object[] getClientTransportLnks() {
        return clientTransportLnks;
    }

    public void setClientTransportLnks(java.lang.Object[] clientTransportLnks) {
        this.clientTransportLnks = clientTransportLnks;
    }

    public java.lang.Object[] getContentSources() {
        return contentSources;
    }

    public void setContentSources(java.lang.Object[] contentSources) {
        this.contentSources = contentSources;
    }

    public boolean isIsAuthentificationRequired() {
        return isAuthentificationRequired;
    }

    public void setIsAuthentificationRequired(boolean isAuthentificationRequired) {
        this.isAuthentificationRequired = isAuthentificationRequired;
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.TransportPeer peer) {
        this.peer = peer;
    }

    public java.lang.Object[] getTransportAttributes() {
        return transportAttributes;
    }

    public void setTransportAttributes(java.lang.Object[] transportAttributes) {
        this.transportAttributes = transportAttributes;
    }

    public java.lang.String getTransportDesc() {
        return transportDesc;
    }

    public void setTransportDesc(java.lang.String transportDesc) {
        this.transportDesc = transportDesc;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public java.lang.String getTransportImplementation() {
        return transportImplementation;
    }

    public void setTransportImplementation(java.lang.String transportImplementation) {
        this.transportImplementation = transportImplementation;
    }

    public java.lang.String getTransportName() {
        return transportName;
    }

    public void setTransportName(java.lang.String transportName) {
        this.transportName = transportName;
    }

    public java.util.Calendar getTransportStartTimeout() {
        return transportStartTimeout;
    }

    public void setTransportStartTimeout(java.util.Calendar transportStartTimeout) {
        this.transportStartTimeout = transportStartTimeout;
    }

    public byte getTransportType() {
        return transportType;
    }

    public void setTransportType(byte transportType) {
        this.transportType = transportType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseTransport)) return false;
        BaseTransport other = (BaseTransport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientTransportLnks==null && other.getClientTransportLnks()==null) || 
             (this.clientTransportLnks!=null &&
              java.util.Arrays.equals(this.clientTransportLnks, other.getClientTransportLnks()))) &&
            ((this.contentSources==null && other.getContentSources()==null) || 
             (this.contentSources!=null &&
              java.util.Arrays.equals(this.contentSources, other.getContentSources()))) &&
            this.isAuthentificationRequired == other.isIsAuthentificationRequired() &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.transportAttributes==null && other.getTransportAttributes()==null) || 
             (this.transportAttributes!=null &&
              java.util.Arrays.equals(this.transportAttributes, other.getTransportAttributes()))) &&
            ((this.transportDesc==null && other.getTransportDesc()==null) || 
             (this.transportDesc!=null &&
              this.transportDesc.equals(other.getTransportDesc()))) &&
            this.transportId == other.getTransportId() &&
            ((this.transportImplementation==null && other.getTransportImplementation()==null) || 
             (this.transportImplementation!=null &&
              this.transportImplementation.equals(other.getTransportImplementation()))) &&
            ((this.transportName==null && other.getTransportName()==null) || 
             (this.transportName!=null &&
              this.transportName.equals(other.getTransportName()))) &&
            ((this.transportStartTimeout==null && other.getTransportStartTimeout()==null) || 
             (this.transportStartTimeout!=null &&
              this.transportStartTimeout.equals(other.getTransportStartTimeout()))) &&
            this.transportType == other.getTransportType();
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
        if (getClientTransportLnks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientTransportLnks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientTransportLnks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        _hashCode += new Boolean(isIsAuthentificationRequired()).hashCode();
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getTransportAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTransportAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTransportAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTransportDesc() != null) {
            _hashCode += getTransportDesc().hashCode();
        }
        _hashCode += getTransportId();
        if (getTransportImplementation() != null) {
            _hashCode += getTransportImplementation().hashCode();
        }
        if (getTransportName() != null) {
            _hashCode += getTransportName().hashCode();
        }
        if (getTransportStartTimeout() != null) {
            _hashCode += getTransportStartTimeout().hashCode();
        }
        _hashCode += getTransportType();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseTransport.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseTransport"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientTransportLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientTransportLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentSources");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentSources"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "TransportPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportAttributes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportAttributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportImplementation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportImplementation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportStartTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportStartTimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transportType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transportType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
