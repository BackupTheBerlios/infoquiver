/**
 * BaseClientContentLnk.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseClientContentLnk  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private net.sf.iquiver.remote.soap.impl.om.Client client;
    private int clientId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey clientKey;
    private net.sf.iquiver.remote.soap.impl.om.Content content;
    private long contentId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentKey;
    private net.sf.iquiver.remote.soap.impl.om.ClientContentLnkPeer peer;
    private java.util.Calendar requestDatetime;

    public BaseClientContentLnk() {
    }

    public net.sf.iquiver.remote.soap.impl.om.Client getClient() {
        return client;
    }

    public void setClient(net.sf.iquiver.remote.soap.impl.om.Client client) {
        this.client = client;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey clientKey) {
        this.clientKey = clientKey;
    }

    public net.sf.iquiver.remote.soap.impl.om.Content getContent() {
        return content;
    }

    public void setContent(net.sf.iquiver.remote.soap.impl.om.Content content) {
        this.content = content;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey getContentKey() {
        return contentKey;
    }

    public void setContentKey(net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentKey) {
        this.contentKey = contentKey;
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientContentLnkPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ClientContentLnkPeer peer) {
        this.peer = peer;
    }

    public java.util.Calendar getRequestDatetime() {
        return requestDatetime;
    }

    public void setRequestDatetime(java.util.Calendar requestDatetime) {
        this.requestDatetime = requestDatetime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseClientContentLnk)) return false;
        BaseClientContentLnk other = (BaseClientContentLnk) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient()))) &&
            this.clientId == other.getClientId() &&
            ((this.clientKey==null && other.getClientKey()==null) || 
             (this.clientKey!=null &&
              this.clientKey.equals(other.getClientKey()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            this.contentId == other.getContentId() &&
            ((this.contentKey==null && other.getContentKey()==null) || 
             (this.contentKey!=null &&
              this.contentKey.equals(other.getContentKey()))) &&
            ((this.peer==null && other.getPeer()==null) || 
             (this.peer!=null &&
              this.peer.equals(other.getPeer()))) &&
            ((this.requestDatetime==null && other.getRequestDatetime()==null) || 
             (this.requestDatetime!=null &&
              this.requestDatetime.equals(other.getRequestDatetime())));
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
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        _hashCode += getClientId();
        if (getClientKey() != null) {
            _hashCode += getClientKey().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        _hashCode += new Long(getContentId()).hashCode();
        if (getContentKey() != null) {
            _hashCode += getContentKey().hashCode();
        }
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        if (getRequestDatetime() != null) {
            _hashCode += getRequestDatetime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseClientContentLnk.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseClientContentLnk"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Client"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "Content"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnkPeer"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestDatetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestDatetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
