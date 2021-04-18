-- Users
INSERT INTO T_USER (USR_FIRST_NAME, USR_LAST_NAME, USR_IS_ACTIVE, USR_EMAIL, USR_PASS_HASH, USR_DEPT, CREATED_BY, VERSION)
	VALUES ('John', 'Doe', 1, 'john.doe@bycn.com', 'azeaze-azeaze-azeaze-azeaz', 'STRUCTIS', 'J.DOE', 0);
	
INSERT INTO T_USER (USR_FIRST_NAME, USR_LAST_NAME, USR_IS_ACTIVE, USR_EMAIL, USR_PASS_HASH, USR_DEPT, CREATED_BY, VERSION)
	VALUES ('Jane', 'Doe', 1, 'jane.doe@bycn.com', 'azeaze-azeaze-azeaze-azeaz', 'STRUCTIS', 'J.DOE', 0);

	INSERT INTO T_USER (USR_FIRST_NAME, USR_LAST_NAME, USR_IS_ACTIVE, USR_EMAIL, USR_PASS_HASH, USR_DEPT, CREATED_BY, VERSION)
	VALUES ('Baby John', 'Doe', 1, 'baby.john.doe@bycn.com', 'azeaze-azeaze-azeaze-azeaz', 'STRUCTIS', 'J.DOE', 0);
	
-- Applications
INSERT INTO T_APPLICATION(APP_NAME, APP_DESCRIPTION, APP_HASH_ID, CREATED_BY, VERSION)
	VALUES('MobOps', 'Lorem ipsum bla bla', 'erer-erer-ere', 'J.DOE', 0);
	
INSERT INTO T_APPLICATION(APP_NAME, APP_DESCRIPTION, APP_HASH_ID, CREATED_BY, VERSION)
	VALUES('EDoc Mobile', 'Lorem ipsum bla bla', 'erer-erer-ere', 'J.DOE', 0);
	
INSERT INTO T_APPLICATION(APP_NAME, APP_DESCRIPTION, APP_HASH_ID, CREATED_BY, VERSION)
	VALUES('Watt Mobile', 'Lorem ipsum bla bla', 'erer-erer-ere', 'J.DOE', 0);
	
INSERT INTO T_APPLICATION(APP_NAME, APP_DESCRIPTION, APP_HASH_ID, CREATED_BY, VERSION)
	VALUES('Nomadis', 'Lorem ipsum bla bla', 'erer-erer-ere', 'J.DOE', 0);

-- User's apps
INSERT INTO T_USER_APPS(USR_ID, APP_ID)
	VALUES(1, 1);
	
-- Verification tokens
INSERT INTO T_VERIFICATION_TOKEN(TKN_VALUE, TKN_EXPIRY_DATE, USR_ID)
	VALUES('c0c949a9-ceff-4e42-b80f-2479d911657f-127736', '2090-01-01', 1);
	
INSERT INTO T_VERIFICATION_TOKEN(TKN_VALUE, TKN_EXPIRY_DATE, USR_ID)
	VALUES('c0c949a9-ceff-4e42-b80f-2479d911657f-127789', '2010-01-01', 2);