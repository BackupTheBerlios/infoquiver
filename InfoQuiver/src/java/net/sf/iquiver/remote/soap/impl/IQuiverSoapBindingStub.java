/**
 * IQuiverSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package net.sf.iquiver.remote.soap.impl;

public class IQuiverSoapBindingStub extends org.apache.axis.client.Stub implements net.sf.iquiver.remote.soap.impl.IQuiver {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[141];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doLogin");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doLoginReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"), java.lang.Object.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "User"), net.sf.iquiver.remote.soap.impl.om.User.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "User"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.User.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"), java.lang.Object.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "User"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.User.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "User"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.User.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "User"), net.sf.iquiver.remote.soap.impl.om.User.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "User"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.User.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertUserReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "User"), net.sf.iquiver.remote.soap.impl.om.User.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClient");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Client"), net.sf.iquiver.remote.soap.impl.om.Client.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Client"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Client.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClient");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[9] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Client"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Client.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Client"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Client.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertClient");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Client"), net.sf.iquiver.remote.soap.impl.om.Client.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Client"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Client.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertClientReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClient");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClient");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Client"), net.sf.iquiver.remote.soap.impl.om.Client.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectAddress");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectAddressReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectAddress");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Address"), net.sf.iquiver.remote.soap.impl.om.Address.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Address"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Address.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectAddressReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveAddressByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Address"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Address.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveAddressByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveAddressByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Address"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Address.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveAddressByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertAddress");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Address"), net.sf.iquiver.remote.soap.impl.om.Address.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Address"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Address.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertAddressReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[19] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteAddress");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteAddress");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Address"), net.sf.iquiver.remote.soap.impl.om.Address.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"), net.sf.iquiver.remote.soap.impl.om.UserGroup.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertUserGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"), net.sf.iquiver.remote.soap.impl.om.UserGroup.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertUserGroupReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroup"), net.sf.iquiver.remote.soap.impl.om.UserGroup.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroupLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[29] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroupLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertUserGroupLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertUserGroupLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroupLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroupLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroupClientLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupClientLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroupClientLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupClientLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupClientLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupClientLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupClientLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupClientLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[39] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertUserGroupClientLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertUserGroupClientLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroupClientLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroupClientLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectTransport");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectTransportReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectTransport");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Transport"), net.sf.iquiver.remote.soap.impl.om.Transport.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Transport"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Transport.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectTransportReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveTransportByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Transport"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Transport.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveTransportByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveTransportByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Transport"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Transport.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveTransportByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertTransport");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Transport"), net.sf.iquiver.remote.soap.impl.om.Transport.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Transport"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Transport.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertTransportReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteTransport");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteTransport");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Transport"), net.sf.iquiver.remote.soap.impl.om.Transport.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[49] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectTransportAttribute");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectTransportAttributeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectTransportAttribute");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"), net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectTransportAttributeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveTransportAttributeByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveTransportAttributeByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveTransportAttributeByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveTransportAttributeByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertTransportAttribute");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"), net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertTransportAttributeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteTransportAttribute");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteTransportAttribute");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute"), net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClientTransportLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientTransportLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClientTransportLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"), net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientTransportLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientTransportLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientTransportLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[59] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientTransportLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientTransportLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertClientTransportLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"), net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertClientTransportLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClientTransportLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk"), net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClientTransportLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectPermission");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectPermissionReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectPermission");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Permission"), net.sf.iquiver.remote.soap.impl.om.Permission.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Permission"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Permission.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectPermissionReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrievePermissionByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Permission"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Permission.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrievePermissionByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrievePermissionByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Permission"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Permission.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrievePermissionByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[67] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertPermission");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Permission"), net.sf.iquiver.remote.soap.impl.om.Permission.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Permission"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Permission.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertPermissionReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[68] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeletePermission");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[69] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeletePermission");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Permission"), net.sf.iquiver.remote.soap.impl.om.Permission.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[70] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClientPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"), net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientPermissionLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[71] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClientPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientPermissionLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[72] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientPermissionLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientPermissionLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[73] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientPermissionLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientPermissionLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[74] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertClientPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"), net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertClientPermissionLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[75] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClientPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[76] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClientPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk"), net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[77] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroupPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupPermissionLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[78] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectUserGroupPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectUserGroupPermissionLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[79] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupPermissionLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupPermissionLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[80] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveUserGroupPermissionLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveUserGroupPermissionLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[81] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertUserGroupPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertUserGroupPermissionLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[82] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroupPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[83] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteUserGroupPermissionLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk"), net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[84] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentSourceType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentSourceTypeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[85] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentSourceType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"), net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentSourceTypeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[86] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentSourceTypeByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentSourceTypeByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[87] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentSourceTypeByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentSourceTypeByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[88] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertContentSourceType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"), net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertContentSourceTypeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[89] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentSourceType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType"), net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[90] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentSourceType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[91] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectPublisher");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectPublisherReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[92] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectPublisher");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Publisher"), net.sf.iquiver.remote.soap.impl.om.Publisher.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Publisher"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Publisher.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectPublisherReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[93] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrievePublisherByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Publisher"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Publisher.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrievePublisherByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[94] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrievePublisherByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Publisher"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Publisher.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrievePublisherByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[95] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertPublisher");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Publisher"), net.sf.iquiver.remote.soap.impl.om.Publisher.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Publisher"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Publisher.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertPublisherReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[96] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeletePublisher");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[97] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeletePublisher");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Publisher"), net.sf.iquiver.remote.soap.impl.om.Publisher.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[98] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentSource");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"), net.sf.iquiver.remote.soap.impl.om.ContentSource.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentSourceReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[99] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentSource");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentSourceReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[100] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentSourceByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentSourceByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[101] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentSourceByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentSourceByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[102] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertContentSource");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"), net.sf.iquiver.remote.soap.impl.om.ContentSource.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertContentSourceReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[103] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentSource");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[104] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentSource");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSource"), net.sf.iquiver.remote.soap.impl.om.ContentSource.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[105] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentSourceTransportConfig");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"), net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentSourceTransportConfigReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[106] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentSourceTransportConfig");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentSourceTransportConfigReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[107] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentSourceTransportConfigByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentSourceTransportConfigByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[108] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentSourceTransportConfigByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentSourceTransportConfigByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[109] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertContentSourceTransportConfig");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"), net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertContentSourceTransportConfigReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[110] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentSourceTransportConfig");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[111] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentSourceTransportConfig");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig"), net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[112] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentParser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentParserReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[113] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentParser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"), net.sf.iquiver.remote.soap.impl.om.ContentParser.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentParserReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[114] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentParserByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentParserByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[115] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentParserByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentParserByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[116] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertContentParser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"), net.sf.iquiver.remote.soap.impl.om.ContentParser.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertContentParserReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[117] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentParser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[118] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentParser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentParser"), net.sf.iquiver.remote.soap.impl.om.ContentParser.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[119] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentTypeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[120] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContentType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentType"), net.sf.iquiver.remote.soap.impl.om.ContentType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentTypeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[121] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentTypeByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentTypeByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[122] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentTypeByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentTypeByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[123] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertContentType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentType"), net.sf.iquiver.remote.soap.impl.om.ContentType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ContentType"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ContentType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertContentTypeReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[124] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[125] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContentType");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ContentType"), net.sf.iquiver.remote.soap.impl.om.ContentType.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[126] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContent");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[127] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectContent");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Content"), net.sf.iquiver.remote.soap.impl.om.Content.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Content"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Content.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectContentReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[128] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Content"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Content.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[129] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveContentByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Content"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Content.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveContentByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[130] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertContent");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Content"), net.sf.iquiver.remote.soap.impl.om.Content.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "Content"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.Content.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertContentReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[131] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContent");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "Content"), net.sf.iquiver.remote.soap.impl.om.Content.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[132] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteContent");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[133] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClientContentLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
        oper.setReturnClass(java.lang.Object[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientContentLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[134] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doSelectClientContentLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"), net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doSelectClientContentLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[135] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientContentLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey"), net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientContentLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[136] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveClientContentLnkByPk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey"), net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveClientContentLnkByPkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[137] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doInsertClientContentLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"), net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"));
        oper.setReturnClass(net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "doInsertClientContentLnkReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[138] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClientContentLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria"), net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[139] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("doDeleteClientContentLnk");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk"), net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[140] = oper;

    }

    public IQuiverSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public IQuiverSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public IQuiverSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseTransportPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseTransportPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver", "ArrayOf_tns4_SimpleKey");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentParser");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentParser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientPermissionLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientPermissionLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroup");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentSourcePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentSourcePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourceType");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentSourceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedPublisherPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedPublisherPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContent");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseAddress");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseAddress.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedUserGroupLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedUserGroupLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTypePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentSourceTypePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupClientLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupClientLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "User");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.User.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "Transport");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.Transport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedContentSourcePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedContentSourcePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "Publisher");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.Publisher.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.util.om", "SimpleCriteria");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupPermissionLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupPermissionLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientPermissionLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientPermissionLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedPermissionPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedPermissionPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedContentPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedContentPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedContentSourceTransportConfigPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedContentSourceTransportConfigPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "TransportAttributePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.TransportAttributePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "Content");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.Content.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentType");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupPermissionLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupPermissionLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClient");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClient.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSource");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentSource.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientContentLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentParserPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentParserPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedUserGroupPermissionLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedUserGroupPermissionLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentSource");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentSource.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseTransportAttribute");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseTransportAttribute.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.torque.om", "ComboKey");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.torque.om.ComboKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroupClientLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroupClientLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedClientPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedClientPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentParser");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentParser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "Permission");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.Permission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedUserGroupPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedUserGroupPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "TransportAttribute");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedTransportPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedTransportPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.torque.om", "SimpleKey");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedContentTypePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedContentTypePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentTypePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentTypePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientTransportLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientTransportLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedClientContentLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedClientContentLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientContentLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientContentLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "TransportPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.TransportPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientPermissionLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "PublisherPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.PublisherPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "Client");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.Client.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BasePermissionPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BasePermissionPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourceTransportConfig");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentSourceTransportConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedClientTransportLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedClientTransportLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientContentLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentParserPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentParserPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BasePublisher");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BasePublisher.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedClientPermissionLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedClientPermissionLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedUserGroupClientLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedUserGroupClientLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedUserPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedUserPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BasePublisherPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BasePublisherPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedContentSourceTypePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedContentSourceTypePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedTransportAttributePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedTransportAttributePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseAddressPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseAddressPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourcePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentSourcePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ClientTransportLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ClientTransportLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupClientLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfig");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUserGroup");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUserGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "mapItem");
            cachedSerQNames.add(qName);
            cls = org.apache.xml.xml_soap.MapItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceType");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.torque.util", "BasePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.torque.util.BasePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "Address");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.Address.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentTypePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentTypePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentType");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "PermissionPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.PermissionPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseTransport");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseTransport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedContentParserPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedContentParserPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "AddressPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.AddressPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BasePermission");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BasePermission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourceTypePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentSourceTypePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.util.om", "CacheBackedPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.util.om.CacheBackedPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.torque.om", "ObjectKey");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.torque.om.ObjectKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.torque.om", "BaseObject");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.torque.om.BaseObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientTransportLnk");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientTransportLnk.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseClientContentLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseClientContentLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "UserGroupPermissionLnkPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnkPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om.cache", "CacheBackedAddressPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.cache.CacheBackedAddressPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseTransportAttributePeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseTransportAttributePeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseUser");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "BaseContentSourceTransportConfigPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.BaseContentSourceTransportConfigPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://iquiver.om", "ContentSourceTransportConfigPeer");
            cachedSerQNames.add(qName);
            cls = net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfigPeer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public java.lang.String doLogin(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doLogin"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
    }

    public java.lang.Object[] doSelectUser(java.lang.String in0, java.lang.Object in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.User doSelectUser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.User in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.User) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.User) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.User.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.User retrieveUserByPk(java.lang.String in0, java.lang.Object in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.User) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.User) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.User.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.User retrieveUserByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.User) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.User) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.User.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.User doInsertUser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.User in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.User) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.User) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.User.class);
            }
        }
    }

    public void doDeleteUser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteUser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.User in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public net.sf.iquiver.remote.soap.impl.om.Client doSelectClient(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Client in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClient"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Client) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Client) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Client.class);
            }
        }
    }

    public java.lang.Object[] doSelectClient(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClient"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Client retrieveClientByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Client) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Client) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Client.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Client retrieveClientByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Client) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Client) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Client.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Client doInsertClient(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Client in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertClient"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Client) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Client) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Client.class);
            }
        }
    }

    public void doDeleteClient(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClient"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteClient(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Client in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClient"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectAddress(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Address doSelectAddress(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Address in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Address) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Address) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Address.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Address retrieveAddressByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveAddressByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Address) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Address) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Address.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Address retrieveAddressByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveAddressByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Address) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Address) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Address.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Address doInsertAddress(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Address in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Address) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Address) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Address.class);
            }
        }
    }

    public void doDeleteAddress(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteAddress(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Address in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectUserGroup(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroup doSelectUserGroup(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroup in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroup retrieveUserGroupByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroup retrieveUserGroupByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroup doInsertUserGroup(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroup in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroup) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroup.class);
            }
        }
    }

    public void doDeleteUserGroup(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroup in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteUserGroup(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectUserGroupLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroupLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupLnk doSelectUserGroupLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroupLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupLnk retrieveUserGroupLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupLnk retrieveUserGroupLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupLnk doInsertUserGroupLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertUserGroupLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk.class);
            }
        }
    }

    public void doDeleteUserGroupLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroupLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteUserGroupLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroupLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk doSelectUserGroupClientLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroupClientLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
            }
        }
    }

    public java.lang.Object[] doSelectUserGroupClientLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroupClientLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk retrieveUserGroupClientLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupClientLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk retrieveUserGroupClientLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupClientLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk doInsertUserGroupClientLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertUserGroupClientLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk.class);
            }
        }
    }

    public void doDeleteUserGroupClientLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroupClientLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteUserGroupClientLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupClientLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroupClientLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectTransport(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectTransport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Transport doSelectTransport(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Transport in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectTransport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Transport.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Transport retrieveTransportByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveTransportByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Transport.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Transport retrieveTransportByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveTransportByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Transport.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Transport doInsertTransport(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Transport in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertTransport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Transport) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Transport.class);
            }
        }
    }

    public void doDeleteTransport(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteTransport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteTransport(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Transport in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteTransport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectTransportAttribute(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectTransportAttribute"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportAttribute doSelectTransportAttribute(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.TransportAttribute in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectTransportAttribute"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportAttribute retrieveTransportAttributeByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveTransportAttributeByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportAttribute retrieveTransportAttributeByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveTransportAttributeByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.TransportAttribute doInsertTransportAttribute(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.TransportAttribute in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertTransportAttribute"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.TransportAttribute) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.TransportAttribute.class);
            }
        }
    }

    public void doDeleteTransportAttribute(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteTransportAttribute"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteTransportAttribute(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.TransportAttribute in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteTransportAttribute"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectClientTransportLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClientTransportLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk doSelectClientTransportLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClientTransportLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk retrieveClientTransportLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientTransportLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk retrieveClientTransportLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientTransportLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk doInsertClientTransportLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertClientTransportLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk.class);
            }
        }
    }

    public void doDeleteClientTransportLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientTransportLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClientTransportLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteClientTransportLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClientTransportLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectPermission(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectPermission"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Permission doSelectPermission(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Permission in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectPermission"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Permission.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Permission retrievePermissionByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrievePermissionByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Permission.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Permission retrievePermissionByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrievePermissionByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Permission.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Permission doInsertPermission(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Permission in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[68]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertPermission"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Permission) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Permission.class);
            }
        }
    }

    public void doDeletePermission(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[69]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeletePermission"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeletePermission(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Permission in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[70]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeletePermission"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk doSelectClientPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[71]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClientPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
            }
        }
    }

    public java.lang.Object[] doSelectClientPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[72]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClientPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk retrieveClientPermissionLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[73]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientPermissionLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk retrieveClientPermissionLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[74]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientPermissionLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk doInsertClientPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[75]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertClientPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk.class);
            }
        }
    }

    public void doDeleteClientPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[76]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClientPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteClientPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientPermissionLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[77]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClientPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectUserGroupPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[78]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroupPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk doSelectUserGroupPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[79]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectUserGroupPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk retrieveUserGroupPermissionLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[80]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupPermissionLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk retrieveUserGroupPermissionLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[81]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveUserGroupPermissionLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk doInsertUserGroupPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[82]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertUserGroupPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk.class);
            }
        }
    }

    public void doDeleteUserGroupPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[83]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroupPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteUserGroupPermissionLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.UserGroupPermissionLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[84]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteUserGroupPermissionLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectContentSourceType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[85]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentSourceType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceType doSelectContentSourceType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSourceType in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[86]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentSourceType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceType retrieveContentSourceTypeByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[87]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentSourceTypeByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceType retrieveContentSourceTypeByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[88]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentSourceTypeByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceType doInsertContentSourceType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSourceType in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[89]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertContentSourceType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceType.class);
            }
        }
    }

    public void doDeleteContentSourceType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSourceType in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[90]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentSourceType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteContentSourceType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[91]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentSourceType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectPublisher(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[92]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectPublisher"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Publisher doSelectPublisher(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Publisher in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[93]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectPublisher"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Publisher.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Publisher retrievePublisherByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[94]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrievePublisherByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Publisher.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Publisher retrievePublisherByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[95]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrievePublisherByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Publisher.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Publisher doInsertPublisher(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Publisher in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[96]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertPublisher"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Publisher) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Publisher.class);
            }
        }
    }

    public void doDeletePublisher(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[97]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeletePublisher"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeletePublisher(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Publisher in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[98]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeletePublisher"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSource doSelectContentSource(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSource in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[99]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentSource"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
            }
        }
    }

    public java.lang.Object[] doSelectContentSource(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[100]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentSource"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSource retrieveContentSourceByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[101]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentSourceByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSource retrieveContentSourceByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[102]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentSourceByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSource doInsertContentSource(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSource in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[103]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertContentSource"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSource) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSource.class);
            }
        }
    }

    public void doDeleteContentSource(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[104]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentSource"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteContentSource(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSource in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[105]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentSource"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig doSelectContentSourceTransportConfig(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[106]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentSourceTransportConfig"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
            }
        }
    }

    public java.lang.Object[] doSelectContentSourceTransportConfig(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[107]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentSourceTransportConfig"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig retrieveContentSourceTransportConfigByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[108]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentSourceTransportConfigByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig retrieveContentSourceTransportConfigByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[109]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentSourceTransportConfigByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig doInsertContentSourceTransportConfig(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[110]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertContentSourceTransportConfig"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig.class);
            }
        }
    }

    public void doDeleteContentSourceTransportConfig(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[111]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentSourceTransportConfig"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteContentSourceTransportConfig(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentSourceTransportConfig in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[112]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentSourceTransportConfig"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectContentParser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[113]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentParser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentParser doSelectContentParser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentParser in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[114]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentParser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentParser retrieveContentParserByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[115]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentParserByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentParser retrieveContentParserByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[116]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentParserByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentParser doInsertContentParser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentParser in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[117]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertContentParser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentParser) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentParser.class);
            }
        }
    }

    public void doDeleteContentParser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[118]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentParser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteContentParser(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentParser in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[119]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentParser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectContentType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[120]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentType doSelectContentType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentType in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[121]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContentType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentType.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentType retrieveContentTypeByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[122]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentTypeByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentType.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentType retrieveContentTypeByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[123]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentTypeByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentType.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ContentType doInsertContentType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentType in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[124]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertContentType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ContentType) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ContentType.class);
            }
        }
    }

    public void doDeleteContentType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[125]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteContentType(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ContentType in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[126]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContentType"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectContent(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[127]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContent"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Content doSelectContent(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Content in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[128]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectContent"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Content) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Content) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Content.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Content retrieveContentByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[129]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Content) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Content) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Content.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Content retrieveContentByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[130]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveContentByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Content) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Content) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Content.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.Content doInsertContent(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Content in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[131]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertContent"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.Content) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.Content) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.Content.class);
            }
        }
    }

    public void doDeleteContent(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.Content in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[132]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContent"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteContent(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[133]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteContent"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public java.lang.Object[] doSelectClientContentLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[134]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClientContentLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Object[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Object[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object[].class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientContentLnk doSelectClientContentLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[135]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doSelectClientContentLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientContentLnk retrieveClientContentLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.ComboKey in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[136]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientContentLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientContentLnk retrieveClientContentLnkByPk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.torque.om.SimpleKey[] in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[137]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "retrieveClientContentLnkByPk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
            }
        }
    }

    public net.sf.iquiver.remote.soap.impl.om.ClientContentLnk doInsertClientContentLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[138]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doInsertClientContentLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.sf.iquiver.remote.soap.impl.om.ClientContentLnk) org.apache.axis.utils.JavaUtils.convert(_resp, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk.class);
            }
        }
    }

    public void doDeleteClientContentLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.util.om.SimpleCriteria in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[139]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClientContentLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void doDeleteClientContentLnk(java.lang.String in0, net.sf.iquiver.remote.soap.impl.om.ClientContentLnk in1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[140]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://iquiver", "doDeleteClientContentLnk"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

}
