


package net.sf.iquiver.remote.soap;

import java.util.List;
import net.sf.iquiver.util.om.SimpleCriteria;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.ComboKey;

/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Tue Apr 13 20:47:11 CEST 2004]
 *
 */
public interface IBaseWebService
{
		  				public net.sf.iquiver.om.User doSelectUser(String sessionId, net.sf.iquiver.om.User object);
			public List doSelectUser(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.User retrieveUserByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.User retrieveUserByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.User doInsertUser(String sessionId, net.sf.iquiver.om.User object);
			public void doDeleteUser(String sessionId, net.sf.iquiver.om.User object);
			public void doDeleteUser(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.Client doSelectClient(String sessionId, net.sf.iquiver.om.Client object);
			public List doSelectClient(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.Client retrieveClientByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.Client retrieveClientByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.Client doInsertClient(String sessionId, net.sf.iquiver.om.Client object);
			public void doDeleteClient(String sessionId, net.sf.iquiver.om.Client object);
			public void doDeleteClient(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.Address doSelectAddress(String sessionId, net.sf.iquiver.om.Address object);
			public List doSelectAddress(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.Address retrieveAddressByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.Address retrieveAddressByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.Address doInsertAddress(String sessionId, net.sf.iquiver.om.Address object);
			public void doDeleteAddress(String sessionId, net.sf.iquiver.om.Address object);
			public void doDeleteAddress(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.UserGroup doSelectUserGroup(String sessionId, net.sf.iquiver.om.UserGroup object);
			public List doSelectUserGroup(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.UserGroup retrieveUserGroupByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.UserGroup retrieveUserGroupByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.UserGroup doInsertUserGroup(String sessionId, net.sf.iquiver.om.UserGroup object);
			public void doDeleteUserGroup(String sessionId, net.sf.iquiver.om.UserGroup object);
			public void doDeleteUserGroup(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.UserGroupLnk doSelectUserGroupLnk(String sessionId, net.sf.iquiver.om.UserGroupLnk object);
			public List doSelectUserGroupLnk(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.UserGroupLnk retrieveUserGroupLnkByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.UserGroupLnk retrieveUserGroupLnkByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.UserGroupLnk doInsertUserGroupLnk(String sessionId, net.sf.iquiver.om.UserGroupLnk object);
			public void doDeleteUserGroupLnk(String sessionId, net.sf.iquiver.om.UserGroupLnk object);
			public void doDeleteUserGroupLnk(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.UserGroupClientLnk doSelectUserGroupClientLnk(String sessionId, net.sf.iquiver.om.UserGroupClientLnk object);
			public List doSelectUserGroupClientLnk(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.UserGroupClientLnk retrieveUserGroupClientLnkByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.UserGroupClientLnk retrieveUserGroupClientLnkByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.UserGroupClientLnk doInsertUserGroupClientLnk(String sessionId, net.sf.iquiver.om.UserGroupClientLnk object);
			public void doDeleteUserGroupClientLnk(String sessionId, net.sf.iquiver.om.UserGroupClientLnk object);
			public void doDeleteUserGroupClientLnk(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.Transport doSelectTransport(String sessionId, net.sf.iquiver.om.Transport object);
			public List doSelectTransport(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.Transport retrieveTransportByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.Transport retrieveTransportByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.Transport doInsertTransport(String sessionId, net.sf.iquiver.om.Transport object);
			public void doDeleteTransport(String sessionId, net.sf.iquiver.om.Transport object);
			public void doDeleteTransport(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.TransportAttribute doSelectTransportAttribute(String sessionId, net.sf.iquiver.om.TransportAttribute object);
			public List doSelectTransportAttribute(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.TransportAttribute retrieveTransportAttributeByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.TransportAttribute retrieveTransportAttributeByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.TransportAttribute doInsertTransportAttribute(String sessionId, net.sf.iquiver.om.TransportAttribute object);
			public void doDeleteTransportAttribute(String sessionId, net.sf.iquiver.om.TransportAttribute object);
			public void doDeleteTransportAttribute(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ClientTransportLnk doSelectClientTransportLnk(String sessionId, net.sf.iquiver.om.ClientTransportLnk object);
			public List doSelectClientTransportLnk(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ClientTransportLnk retrieveClientTransportLnkByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ClientTransportLnk retrieveClientTransportLnkByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ClientTransportLnk doInsertClientTransportLnk(String sessionId, net.sf.iquiver.om.ClientTransportLnk object);
			public void doDeleteClientTransportLnk(String sessionId, net.sf.iquiver.om.ClientTransportLnk object);
			public void doDeleteClientTransportLnk(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.Permission doSelectPermission(String sessionId, net.sf.iquiver.om.Permission object);
			public List doSelectPermission(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.Permission retrievePermissionByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.Permission retrievePermissionByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.Permission doInsertPermission(String sessionId, net.sf.iquiver.om.Permission object);
			public void doDeletePermission(String sessionId, net.sf.iquiver.om.Permission object);
			public void doDeletePermission(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ClientPermissionLnk doSelectClientPermissionLnk(String sessionId, net.sf.iquiver.om.ClientPermissionLnk object);
			public List doSelectClientPermissionLnk(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ClientPermissionLnk retrieveClientPermissionLnkByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ClientPermissionLnk retrieveClientPermissionLnkByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ClientPermissionLnk doInsertClientPermissionLnk(String sessionId, net.sf.iquiver.om.ClientPermissionLnk object);
			public void doDeleteClientPermissionLnk(String sessionId, net.sf.iquiver.om.ClientPermissionLnk object);
			public void doDeleteClientPermissionLnk(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.UserGroupPermissionLnk doSelectUserGroupPermissionLnk(String sessionId, net.sf.iquiver.om.UserGroupPermissionLnk object);
			public List doSelectUserGroupPermissionLnk(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.UserGroupPermissionLnk retrieveUserGroupPermissionLnkByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.UserGroupPermissionLnk retrieveUserGroupPermissionLnkByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.UserGroupPermissionLnk doInsertUserGroupPermissionLnk(String sessionId, net.sf.iquiver.om.UserGroupPermissionLnk object);
			public void doDeleteUserGroupPermissionLnk(String sessionId, net.sf.iquiver.om.UserGroupPermissionLnk object);
			public void doDeleteUserGroupPermissionLnk(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ContentSourceType doSelectContentSourceType(String sessionId, net.sf.iquiver.om.ContentSourceType object);
			public List doSelectContentSourceType(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ContentSourceType retrieveContentSourceTypeByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ContentSourceType retrieveContentSourceTypeByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ContentSourceType doInsertContentSourceType(String sessionId, net.sf.iquiver.om.ContentSourceType object);
			public void doDeleteContentSourceType(String sessionId, net.sf.iquiver.om.ContentSourceType object);
			public void doDeleteContentSourceType(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.Publisher doSelectPublisher(String sessionId, net.sf.iquiver.om.Publisher object);
			public List doSelectPublisher(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.Publisher retrievePublisherByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.Publisher retrievePublisherByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.Publisher doInsertPublisher(String sessionId, net.sf.iquiver.om.Publisher object);
			public void doDeletePublisher(String sessionId, net.sf.iquiver.om.Publisher object);
			public void doDeletePublisher(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ContentSource doSelectContentSource(String sessionId, net.sf.iquiver.om.ContentSource object);
			public List doSelectContentSource(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ContentSource retrieveContentSourceByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ContentSource retrieveContentSourceByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ContentSource doInsertContentSource(String sessionId, net.sf.iquiver.om.ContentSource object);
			public void doDeleteContentSource(String sessionId, net.sf.iquiver.om.ContentSource object);
			public void doDeleteContentSource(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ContentSourceTransportConfig doSelectContentSourceTransportConfig(String sessionId, net.sf.iquiver.om.ContentSourceTransportConfig object);
			public List doSelectContentSourceTransportConfig(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ContentSourceTransportConfig retrieveContentSourceTransportConfigByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ContentSourceTransportConfig retrieveContentSourceTransportConfigByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ContentSourceTransportConfig doInsertContentSourceTransportConfig(String sessionId, net.sf.iquiver.om.ContentSourceTransportConfig object);
			public void doDeleteContentSourceTransportConfig(String sessionId, net.sf.iquiver.om.ContentSourceTransportConfig object);
			public void doDeleteContentSourceTransportConfig(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ContentParser doSelectContentParser(String sessionId, net.sf.iquiver.om.ContentParser object);
			public List doSelectContentParser(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ContentParser retrieveContentParserByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ContentParser retrieveContentParserByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ContentParser doInsertContentParser(String sessionId, net.sf.iquiver.om.ContentParser object);
			public void doDeleteContentParser(String sessionId, net.sf.iquiver.om.ContentParser object);
			public void doDeleteContentParser(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ContentType doSelectContentType(String sessionId, net.sf.iquiver.om.ContentType object);
			public List doSelectContentType(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ContentType retrieveContentTypeByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ContentType retrieveContentTypeByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ContentType doInsertContentType(String sessionId, net.sf.iquiver.om.ContentType object);
			public void doDeleteContentType(String sessionId, net.sf.iquiver.om.ContentType object);
			public void doDeleteContentType(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.Content doSelectContent(String sessionId, net.sf.iquiver.om.Content object);
			public List doSelectContent(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.Content retrieveContentByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.Content retrieveContentByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.Content doInsertContent(String sessionId, net.sf.iquiver.om.Content object);
			public void doDeleteContent(String sessionId, net.sf.iquiver.om.Content object);
			public void doDeleteContent(String sessionId, SimpleCriteria criteria);
				  				public net.sf.iquiver.om.ClientContentLnk doSelectClientContentLnk(String sessionId, net.sf.iquiver.om.ClientContentLnk object);
			public List doSelectClientContentLnk(String sessionId, SimpleCriteria criteria);
			public net.sf.iquiver.om.ClientContentLnk retrieveClientContentLnkByPk(String sessionId, SimpleKey[] key);
			public net.sf.iquiver.om.ClientContentLnk retrieveClientContentLnkByPk(String sessionId, ComboKey key);			
			public net.sf.iquiver.om.ClientContentLnk doInsertClientContentLnk(String sessionId, net.sf.iquiver.om.ClientContentLnk object);
			public void doDeleteClientContentLnk(String sessionId, net.sf.iquiver.om.ClientContentLnk object);
			public void doDeleteClientContentLnk(String sessionId, SimpleCriteria criteria);
			}
