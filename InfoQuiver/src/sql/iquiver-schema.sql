
# -----------------------------------------------------------------------
# iq_user
# -----------------------------------------------------------------------
drop table if exists iq_user;

CREATE TABLE iq_user
(
		            USER_ID BIGINT NOT NULL,
		            USER_PASSWORD VARCHAR (32),
		            USER_LOGIN VARCHAR (32) NOT NULL,
		            USER_FIRST_NAME VARCHAR (32),
		            USER_MID_NAME VARCHAR (32),
		            USER_LAST_NAME VARCHAR (32),
		            USER_GENDER VARCHAR (1),
		            USER_DATE_OF_BIRTH TIMESTAMP,
		            USER_PICTURE LONGBLOB,
		            USER_LAST_LOGIN BIGINT,
		            ADDRESS_ID BIGINT NOT NULL,
		            CLIENT_ID INTEGER NOT NULL,
    PRIMARY KEY(USER_ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES iq_client (CLIENT_ID)
    ,
    FOREIGN KEY (ADDRESS_ID) REFERENCES iq_address (ADDRESS_ID)
    ,
    INDEX IQ_USER_CKI (USER_LOGIN, USER_PASSWORD)
);

# -----------------------------------------------------------------------
# iq_user_content_source_lnk
# -----------------------------------------------------------------------
drop table if exists iq_user_content_source_lnk;

CREATE TABLE iq_user_content_source_lnk
(
		            USER_ID BIGINT NOT NULL,
		            CONTENT_SOURCE_ID BIGINT NOT NULL,
    PRIMARY KEY(USER_ID,CONTENT_SOURCE_ID),
    FOREIGN KEY (CONTENT_SOURCE_ID) REFERENCES iq_content_source (CONTENT_SOURCE_ID)
    ,
    FOREIGN KEY (USER_ID) REFERENCES iq_user (USER_ID)
    ,
    UNIQUE (USER_ID, CONTENT_SOURCE_ID)
);

# -----------------------------------------------------------------------
# iq_client
# -----------------------------------------------------------------------
drop table if exists iq_client;

CREATE TABLE iq_client
(
		            CLIENT_ID INTEGER NOT NULL,
		            CLIENT_NAME VARCHAR (32),
		            ADDRESS_ID BIGINT NOT NULL,
    PRIMARY KEY(CLIENT_ID),
    FOREIGN KEY (ADDRESS_ID) REFERENCES iq_address (ADDRESS_ID)
    
);

# -----------------------------------------------------------------------
# iq_client_content_source_lnk
# -----------------------------------------------------------------------
drop table if exists iq_client_content_source_lnk;

CREATE TABLE iq_client_content_source_lnk
(
		            CLIENT_ID INTEGER NOT NULL,
		            CONTENT_SOURCE_ID BIGINT NOT NULL,
    PRIMARY KEY(CLIENT_ID,CONTENT_SOURCE_ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES iq_client (CLIENT_ID)
    ,
    FOREIGN KEY (CONTENT_SOURCE_ID) REFERENCES iq_content_source (CONTENT_SOURCE_ID)
    ,
    UNIQUE (CLIENT_ID, CONTENT_SOURCE_ID)
);

# -----------------------------------------------------------------------
# iq_address
# -----------------------------------------------------------------------
drop table if exists iq_address;

CREATE TABLE iq_address
(
		            ADDRESS_ID BIGINT NOT NULL,
		            ADDRESS_NAME VARCHAR (64),
		            ADDRESS_STREET VARCHAR (32),
		            ADDRESS_ZIP VARCHAR (10),
		            ADDRESS_PO_BOX VARCHAR (32),
		            ADDRESS_PO_BOX_ZIP VARCHAR (10),
		            ADDRESS_PHONE VARCHAR (16),
		            ADDRESS_MOBILE VARCHAR (16),
		            ADDRESS_EMAIL VARCHAR (32),
		            ADDRESS_URL VARCHAR (64),
		            ADDRESS_NUMBER VARCHAR (10),
		            ADDRESS_COUNTRY VARCHAR (255),
    PRIMARY KEY(ADDRESS_ID)
);

# -----------------------------------------------------------------------
# iq_user_group
# -----------------------------------------------------------------------
drop table if exists iq_user_group;

CREATE TABLE iq_user_group
(
		            USER_GROUP_ID BIGINT NOT NULL,
		            USER_GROUP_NAME VARCHAR (32),
		            USER_GROUP_DESC VARCHAR (255),
		            CLIENT_ID INTEGER NOT NULL,
    PRIMARY KEY(USER_GROUP_ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES iq_client (CLIENT_ID)
    
);

# -----------------------------------------------------------------------
# iq_user_group_lnk
# -----------------------------------------------------------------------
drop table if exists iq_user_group_lnk;

CREATE TABLE iq_user_group_lnk
(
		            USER_GROUP_ID BIGINT NOT NULL,
		            USER_ID BIGINT NOT NULL,
    PRIMARY KEY(USER_GROUP_ID,USER_ID),
    FOREIGN KEY (USER_GROUP_ID) REFERENCES iq_user_group (USER_GROUP_ID)
    ,
    FOREIGN KEY (USER_ID) REFERENCES iq_user (USER_ID)
    ,
    UNIQUE (USER_GROUP_ID, USER_ID)
);

# -----------------------------------------------------------------------
# iq_user_group_client_lnk
# -----------------------------------------------------------------------
drop table if exists iq_user_group_client_lnk;

CREATE TABLE iq_user_group_client_lnk
(
		            CLIENT_ID INTEGER NOT NULL,
		            USER_GROUP_ID BIGINT NOT NULL,
    PRIMARY KEY(CLIENT_ID,USER_GROUP_ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES iq_client (CLIENT_ID)
    ,
    FOREIGN KEY (USER_GROUP_ID) REFERENCES iq_user_group (USER_GROUP_ID)
    ,
    UNIQUE (CLIENT_ID, USER_GROUP_ID)
);

# -----------------------------------------------------------------------
# iq_transport
# -----------------------------------------------------------------------
drop table if exists iq_transport;

CREATE TABLE iq_transport
(
		            TRANSPORT_ID INTEGER NOT NULL,
		            TRANSPORT_NAME VARCHAR (32) NOT NULL,
		            TRANSPORT_TYPE TINYINT NOT NULL,
		            TRANSPORT_DESC VARCHAR (255),
		            TRANSPORT_START_TIMEOUT TIMESTAMP,
		            TRANSPORT_IMPLEMENTATION VARCHAR (255) NOT NULL,
		            IS_AUTHENTIFICATION_REQUIRED INTEGER,
    PRIMARY KEY(TRANSPORT_ID)
);

# -----------------------------------------------------------------------
# iq_transport_attribute
# -----------------------------------------------------------------------
drop table if exists iq_transport_attribute;

CREATE TABLE iq_transport_attribute
(
		            TRANSPORT_ATTRIBUTE_ID INTEGER NOT NULL,
		            TRANSPORT_ID INTEGER NOT NULL,
		            TRANSPORT_ATTRIBUTE_NAME VARCHAR (16) NOT NULL,
		            TRANSPORT_ATTRIBUTE_TYPE VARCHAR (32) NOT NULL,
		            IS_PART_OF_AUTHENTIFICATION INTEGER,
		            IS_MANDATORY INTEGER,
    PRIMARY KEY(TRANSPORT_ATTRIBUTE_ID),
    FOREIGN KEY (TRANSPORT_ID) REFERENCES iq_transport (TRANSPORT_ID)
    ,
    UNIQUE (TRANSPORT_ID, TRANSPORT_ATTRIBUTE_NAME)
);

# -----------------------------------------------------------------------
# iq_client_transport_lnk
# -----------------------------------------------------------------------
drop table if exists iq_client_transport_lnk;

CREATE TABLE iq_client_transport_lnk
(
		            CLIENT_ID INTEGER NOT NULL,
		            TRANSPORT_ID INTEGER NOT NULL,
    PRIMARY KEY(CLIENT_ID,TRANSPORT_ID),
    FOREIGN KEY (CLIENT_ID) REFERENCES iq_client (CLIENT_ID)
    ,
    FOREIGN KEY (TRANSPORT_ID) REFERENCES iq_transport (TRANSPORT_ID)
    
);

# -----------------------------------------------------------------------
# iq_permission
# -----------------------------------------------------------------------
drop table if exists iq_permission;

CREATE TABLE iq_permission
(
		            PERMISSION_ID INTEGER NOT NULL,
		            PERMISSION_NAME VARCHAR (32),
		            PERMISSION_DESC VARCHAR (255),
    PRIMARY KEY(PERMISSION_ID)
);

# -----------------------------------------------------------------------
# iq_client_permission_lnk
# -----------------------------------------------------------------------
drop table if exists iq_client_permission_lnk;

CREATE TABLE iq_client_permission_lnk
(
		            CLIENT_ID INTEGER NOT NULL,
		            PERMISSION_ID INTEGER NOT NULL,
    PRIMARY KEY(CLIENT_ID,PERMISSION_ID)
);

# -----------------------------------------------------------------------
# iq_user_group_permission_lnk
# -----------------------------------------------------------------------
drop table if exists iq_user_group_permission_lnk;

CREATE TABLE iq_user_group_permission_lnk
(
		            USER_GROUP_ID BIGINT NOT NULL,
		            PERMISSION_ID INTEGER NOT NULL,
		            IS_NEGATION INTEGER,
    PRIMARY KEY(USER_GROUP_ID,PERMISSION_ID),
    UNIQUE (USER_GROUP_ID, PERMISSION_ID)
);

# -----------------------------------------------------------------------
# iq_content_source_type
# -----------------------------------------------------------------------
drop table if exists iq_content_source_type;

CREATE TABLE iq_content_source_type
(
		            CONTENT_SOURCE_TYPE_ID INTEGER NOT NULL,
		            CONTENT_SOURCE_TYPE_NAME VARCHAR (32),
		            CONTENT_SOURCE_TYPE_DESC VARCHAR (255),
    PRIMARY KEY(CONTENT_SOURCE_TYPE_ID)
);

# -----------------------------------------------------------------------
# iq_content_source_type_transport_lnk
# -----------------------------------------------------------------------
drop table if exists iq_content_source_type_transport_lnk;

CREATE TABLE iq_content_source_type_transport_lnk
(
		            CONTENT_SOURCE_TYPE_ID INTEGER NOT NULL,
		            TRANSPORT_ID INTEGER NOT NULL,
    PRIMARY KEY(CONTENT_SOURCE_TYPE_ID,TRANSPORT_ID),
    UNIQUE (CONTENT_SOURCE_TYPE_ID, TRANSPORT_ID)
);

# -----------------------------------------------------------------------
# iq_publisher
# -----------------------------------------------------------------------
drop table if exists iq_publisher;

CREATE TABLE iq_publisher
(
		            PUBLISHER_ID INTEGER NOT NULL,
		            ADDRESS_ID BIGINT NOT NULL,
		            PUBLISHER_NAME VARCHAR (32),
		            PUBLISHER_LOGO LONGBLOB,
    PRIMARY KEY(PUBLISHER_ID),
    FOREIGN KEY (ADDRESS_ID) REFERENCES iq_address (ADDRESS_ID)
    
);

# -----------------------------------------------------------------------
# iq_content_source
# -----------------------------------------------------------------------
drop table if exists iq_content_source;

CREATE TABLE iq_content_source
(
		            CONTENT_SOURCE_ID BIGINT NOT NULL,
		            CONTENT_SOURCE_TYPE_ID INTEGER NOT NULL,
		            TRANSPORT_ID INTEGER NOT NULL,
		            PUBLISHER_ID INTEGER,
		            CONTENT_SOURCE_NAME VARCHAR (32),
		            CONTENT_SOURCE_DESC VARCHAR (255),
		            CONTENT_SOURCE_UPDATE_TIMESPAN BIGINT default 1800000,
		            IS_AUTHENTIFICATION_REQUIRED INTEGER,
    PRIMARY KEY(CONTENT_SOURCE_ID),
    FOREIGN KEY (CONTENT_SOURCE_TYPE_ID) REFERENCES iq_content_source_type (CONTENT_SOURCE_TYPE_ID)
    ,
    FOREIGN KEY (TRANSPORT_ID) REFERENCES iq_transport (TRANSPORT_ID)
    ,
    FOREIGN KEY (PUBLISHER_ID) REFERENCES iq_publisher (PUBLISHER_ID)
    ,
    INDEX IQ_CONTENTSOURCE_TYPE_FKI (CONTENT_SOURCE_TYPE_ID),
    INDEX IQ_CONTENTSOURCE_TRANSPORT_FKI (TRANSPORT_ID),
    INDEX IQ_CONTENTSOURCE_PUBLISHER_FKI (PUBLISHER_ID)
);

# -----------------------------------------------------------------------
# iq_content_source_transport_config
# -----------------------------------------------------------------------
drop table if exists iq_content_source_transport_config;

CREATE TABLE iq_content_source_transport_config
(
		            CONTENT_SOURCE_ID BIGINT NOT NULL,
		            TRANSPORT_ATTRIBUTE_ID INTEGER NOT NULL,
		            TRANSPORT_ATTRIBUTE_VALUE VARCHAR (255),
    PRIMARY KEY(CONTENT_SOURCE_ID,TRANSPORT_ATTRIBUTE_ID),
    FOREIGN KEY (CONTENT_SOURCE_ID) REFERENCES iq_content_source (CONTENT_SOURCE_ID)
    ,
    FOREIGN KEY (TRANSPORT_ATTRIBUTE_ID) REFERENCES iq_transport_attribute (TRANSPORT_ATTRIBUTE_ID)
    ,
    UNIQUE (CONTENT_SOURCE_ID, TRANSPORT_ATTRIBUTE_ID)
);

# -----------------------------------------------------------------------
# iq_content_parser
# -----------------------------------------------------------------------
drop table if exists iq_content_parser;

CREATE TABLE iq_content_parser
(
		            CONTENT_PARSER_ID INTEGER NOT NULL,
		            CONTENT_PARSER_IMPLEMENTATION VARCHAR (255) NOT NULL,
		            CONTENT_PARSER_NAME VARCHAR (32),
    PRIMARY KEY(CONTENT_PARSER_ID)
);

# -----------------------------------------------------------------------
# iq_content_type
# -----------------------------------------------------------------------
drop table if exists iq_content_type;

CREATE TABLE iq_content_type
(
		            CONTENT_TYPE_ID INTEGER NOT NULL,
		            CONTENT_TYPE_NAME VARCHAR (32) NOT NULL,
		            CONTENT_TYPE_DESC VARCHAR (255),
		            CONTENT_PARSER_ID INTEGER NOT NULL,
    PRIMARY KEY(CONTENT_TYPE_ID),
    FOREIGN KEY (CONTENT_PARSER_ID) REFERENCES iq_content_parser (CONTENT_PARSER_ID)
    
);

# -----------------------------------------------------------------------
# iq_content
# -----------------------------------------------------------------------
drop table if exists iq_content;

CREATE TABLE iq_content
(
		            CONTENT_ID BIGINT NOT NULL,
		            CONTENT_TYPE_ID INTEGER NOT NULL,
		            CONTENT_SOURCE_ID BIGINT NOT NULL,
		            CONTENT_RECEIVE_DATETIME TIMESTAMP,
		            CONTENT_LOCALE VARCHAR (5),
		            CONTENT_DATE_OF_CREATION TIMESTAMP,
		            CONTENT_DATE_OF_LAST_MODIFICATION TIMESTAMP,
		            CONTENT_INFO_URL VARCHAR (32),
		            CONTENT_AUTHOR VARCHAR (32),
		            CONTENT_NAME VARCHAR (32),
		            CONTENT_TITLE VARCHAR (32),
		            CONTENT_SHORT_DESCRIPTION VARCHAR (200),
		            CONTENT_KEYWORDS MEDIUMTEXT,
		            CONTENT_CONTENT MEDIUMTEXT,
		            CONTENT_TO_DELETE INTEGER,
    PRIMARY KEY(CONTENT_ID),
    FOREIGN KEY (CONTENT_SOURCE_ID) REFERENCES iq_content_source (CONTENT_SOURCE_ID)
    ,
    FOREIGN KEY (CONTENT_TYPE_ID) REFERENCES iq_content_type (CONTENT_TYPE_ID)
    ,
    INDEX IQ_CONTENT_TYPE_FKI (CONTENT_TYPE_ID),
    INDEX IQ_CONTENT_CONTENTSOURCE_FKI (CONTENT_SOURCE_ID),
    INDEX IQ_CONTENT_LOCALE_CKI (CONTENT_LOCALE),
    INDEX IQ_CONTENT_RECEIVE_DATETIME_CKI (CONTENT_RECEIVE_DATETIME),
    INDEX IQ_CONTENT_AUTHOR_CKI (CONTENT_AUTHOR)
);
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
