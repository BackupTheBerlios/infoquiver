/**
 * BaseContent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl.om;

public abstract class BaseContent  extends net.sf.iquiver.remote.soap.impl.torque.om.BaseObject  implements java.io.Serializable {
    private java.lang.Object[] clientContentLnks;
    private java.lang.String contentAuthor;
    private java.lang.String contentContent;
    private java.util.Calendar contentDateOfCreation;
    private java.util.Calendar contentDateOfLastModification;
    private long contentId;
    private java.lang.String contentInfoUrl;
    private java.lang.String contentLocale;
    private java.lang.String contentName;
    private java.util.Calendar contentReceiveDatetime;
    private java.lang.String contentShortDescription;
    private net.sf.iquiver.remote.soap.impl.om.ContentSource contentSource;
    private long contentSourceId;
    private net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey contentSourceKey;
    private java.lang.String contentTitle;
    private int contentTypeId;
    private net.sf.iquiver.remote.soap.impl.om.ContentPeer peer;

    public BaseContent() {
    }

    public java.lang.Object[] getClientContentLnks() {
        return clientContentLnks;
    }

    public void setClientContentLnks(java.lang.Object[] clientContentLnks) {
        this.clientContentLnks = clientContentLnks;
    }

    public java.lang.String getContentAuthor() {
        return contentAuthor;
    }

    public void setContentAuthor(java.lang.String contentAuthor) {
        this.contentAuthor = contentAuthor;
    }

    public java.lang.String getContentContent() {
        return contentContent;
    }

    public void setContentContent(java.lang.String contentContent) {
        this.contentContent = contentContent;
    }

    public java.util.Calendar getContentDateOfCreation() {
        return contentDateOfCreation;
    }

    public void setContentDateOfCreation(java.util.Calendar contentDateOfCreation) {
        this.contentDateOfCreation = contentDateOfCreation;
    }

    public java.util.Calendar getContentDateOfLastModification() {
        return contentDateOfLastModification;
    }

    public void setContentDateOfLastModification(java.util.Calendar contentDateOfLastModification) {
        this.contentDateOfLastModification = contentDateOfLastModification;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public java.lang.String getContentInfoUrl() {
        return contentInfoUrl;
    }

    public void setContentInfoUrl(java.lang.String contentInfoUrl) {
        this.contentInfoUrl = contentInfoUrl;
    }

    public java.lang.String getContentLocale() {
        return contentLocale;
    }

    public void setContentLocale(java.lang.String contentLocale) {
        this.contentLocale = contentLocale;
    }

    public java.lang.String getContentName() {
        return contentName;
    }

    public void setContentName(java.lang.String contentName) {
        this.contentName = contentName;
    }

    public java.util.Calendar getContentReceiveDatetime() {
        return contentReceiveDatetime;
    }

    public void setContentReceiveDatetime(java.util.Calendar contentReceiveDatetime) {
        this.contentReceiveDatetime = contentReceiveDatetime;
    }

    public java.lang.String getContentShortDescription() {
        return contentShortDescription;
    }

    public void setContentShortDescription(java.lang.String contentShortDescription) {
        this.contentShortDescription = contentShortDescription;
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

    public java.lang.String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(java.lang.String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentPeer getPeer() {
        return peer;
    }

    public void setPeer(net.sf.iquiver.remote.soap.impl.om.ContentPeer peer) {
        this.peer = peer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseContent)) return false;
        BaseContent other = (BaseContent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientContentLnks==null && other.getClientContentLnks()==null) || 
             (this.clientContentLnks!=null &&
              java.util.Arrays.equals(this.clientContentLnks, other.getClientContentLnks()))) &&
            ((this.contentAuthor==null && other.getContentAuthor()==null) || 
             (this.contentAuthor!=null &&
              this.contentAuthor.equals(other.getContentAuthor()))) &&
            ((this.contentContent==null && other.getContentContent()==null) || 
             (this.contentContent!=null &&
              this.contentContent.equals(other.getContentContent()))) &&
            ((this.contentDateOfCreation==null && other.getContentDateOfCreation()==null) || 
             (this.contentDateOfCreation!=null &&
              this.contentDateOfCreation.equals(other.getContentDateOfCreation()))) &&
            ((this.contentDateOfLastModification==null && other.getContentDateOfLastModification()==null) || 
             (this.contentDateOfLastModification!=null &&
              this.contentDateOfLastModification.equals(other.getContentDateOfLastModification()))) &&
            this.contentId == other.getContentId() &&
            ((this.contentInfoUrl==null && other.getContentInfoUrl()==null) || 
             (this.contentInfoUrl!=null &&
              this.contentInfoUrl.equals(other.getContentInfoUrl()))) &&
            ((this.contentLocale==null && other.getContentLocale()==null) || 
             (this.contentLocale!=null &&
              this.contentLocale.equals(other.getContentLocale()))) &&
            ((this.contentName==null && other.getContentName()==null) || 
             (this.contentName!=null &&
              this.contentName.equals(other.getContentName()))) &&
            ((this.contentReceiveDatetime==null && other.getContentReceiveDatetime()==null) || 
             (this.contentReceiveDatetime!=null &&
              this.contentReceiveDatetime.equals(other.getContentReceiveDatetime()))) &&
            ((this.contentShortDescription==null && other.getContentShortDescription()==null) || 
             (this.contentShortDescription!=null &&
              this.contentShortDescription.equals(other.getContentShortDescription()))) &&
            ((this.contentSource==null && other.getContentSource()==null) || 
             (this.contentSource!=null &&
              this.contentSource.equals(other.getContentSource()))) &&
            this.contentSourceId == other.getContentSourceId() &&
            ((this.contentSourceKey==null && other.getContentSourceKey()==null) || 
             (this.contentSourceKey!=null &&
              this.contentSourceKey.equals(other.getContentSourceKey()))) &&
            ((this.contentTitle==null && other.getContentTitle()==null) || 
             (this.contentTitle!=null &&
              this.contentTitle.equals(other.getContentTitle()))) &&
            this.contentTypeId == other.getContentTypeId() &&
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
        if (getClientContentLnks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientContentLnks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientContentLnks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContentAuthor() != null) {
            _hashCode += getContentAuthor().hashCode();
        }
        if (getContentContent() != null) {
            _hashCode += getContentContent().hashCode();
        }
        if (getContentDateOfCreation() != null) {
            _hashCode += getContentDateOfCreation().hashCode();
        }
        if (getContentDateOfLastModification() != null) {
            _hashCode += getContentDateOfLastModification().hashCode();
        }
        _hashCode += new Long(getContentId()).hashCode();
        if (getContentInfoUrl() != null) {
            _hashCode += getContentInfoUrl().hashCode();
        }
        if (getContentLocale() != null) {
            _hashCode += getContentLocale().hashCode();
        }
        if (getContentName() != null) {
            _hashCode += getContentName().hashCode();
        }
        if (getContentReceiveDatetime() != null) {
            _hashCode += getContentReceiveDatetime().hashCode();
        }
        if (getContentShortDescription() != null) {
            _hashCode += getContentShortDescription().hashCode();
        }
        if (getContentSource() != null) {
            _hashCode += getContentSource().hashCode();
        }
        _hashCode += new Long(getContentSourceId()).hashCode();
        if (getContentSourceKey() != null) {
            _hashCode += getContentSourceKey().hashCode();
        }
        if (getContentTitle() != null) {
            _hashCode += getContentTitle().hashCode();
        }
        _hashCode += getContentTypeId();
        if (getPeer() != null) {
            _hashCode += getPeer().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseContent.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "BaseContent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientContentLnks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientContentLnks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentAuthor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentAuthor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentDateOfCreation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentDateOfCreation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentDateOfLastModification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentDateOfLastModification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentInfoUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentInfoUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentLocale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentLocale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentReceiveDatetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentReceiveDatetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentShortDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentShortDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("contentTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentTypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "peer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://iquiver.om", "ContentPeer"));
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
