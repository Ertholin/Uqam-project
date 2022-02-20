
-- SEVISPAMDB
-- INSERT ALL ROLES AND PRIVILEGES TO GRANT ACCESS
-- LIST OF CREATE PRIVILEGES
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('CREATE: Owner Account', 'Able to create an owner account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('CREATE: Professional Account', 'Able to create a professional account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('CREATE: Agent marketing Account', 'Able to create an agent marketing account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('CREATE: Admin Account', 'Able to create a admin account');

-- LIST OF ADD PRIVILEGES
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('ADD: Property', 'Able to add a property');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('ADD: Owner', 'Able to add an owner');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('ADD: Professional', 'Able to add a professional');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('ADD: Profession', 'Able to add a profession');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('ADD: Agent Marketing', 'Able to add an agent marketing');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('ADD: Article', 'Able to add an article');

-- LIST OF UPDATE PRIVILEGES
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('UPDATE: Property', 'Able to update a property');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('UPDATE: Owner Account', 'Able to update an owner account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('UPDATE: Professional account', 'Able to update a professional account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('UPDATE: Profession', 'Able to update a profession');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('UPDATE: Article', 'Able to update an article');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('UPDATE: Agent Marketing Account', 'Able to update a agent marketing account');

-- LIST OF DELETE PRIVILEGES
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('DELETE: Property', 'Able to delete a property');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('DELETE: Owner Account', 'Able to delete an owner account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('DELETE: Professional', 'Able to delete a professional account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('DELETE: Agent Marketing', 'Able to delete an agent marketing account');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('DELETE: Article', 'Able to delete an Article');

-- LIST OF VIEW PRIVILEGES
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: Property', 'Able to view a property');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: Owner', 'Able to view an owner');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: Professional', 'Able to view a professional');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: Profession', 'Able to view a profession');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: Agent Marketing', 'Able to view an agent marketing');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: Article', 'Able to view an article');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: All Properties', 'Able to view all properties');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: All Owners', 'Able to view all owners');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: All Professionals', 'Able to view all professionals');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: All Professions', 'Able to view all professions');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: All Agent Marketings', 'Able to view all agent marketings');
INSERT INTO PRIVILEGE ('name', 'description') VALUES ('VIEW: All Articles', 'Able to view all articles');

-- LIST OF ROLES
INSERT INTO ROLE ('name', 'description') VALUES ('Anonymous', 'Privilege for non-authenticated users');
INSERT INTO ROLE ('name', 'description') VALUES ('System: configure Form', 'Manages form an attaches then to the UI');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Configure Metadata', 'Access to configure metadata app');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Manage Payment', 'Give access to pay however the users want');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Show account', 'Show all the account in the system');
INSERT INTO ROLE ('name', 'description') VALUES ('System: send Sotification', 'Informs users in case of new news');
INSERT INTO ROLE ('name', 'description') VALUES ('System: show positioning', 'With the API Google maps the system will be able to display the positions of the houses');
INSERT INTO ROLE ('name', 'description') VALUES ('System: manage account', 'The system manages the account with a very reliable level of security');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Gives star to the Best Professional', 'The system for awarding stars to the most requested professional');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Admin', 'System administrators');
INSERT INTO ROLE ('name', 'description') VALUES ('System: users', 'Users of the system');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Professional', 'System professionals');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Agent Marketing', 'The system''s marketing agents');
INSERT INTO ROLE ('name', 'description') VALUES ('System: Owner', 'Homeowners');
