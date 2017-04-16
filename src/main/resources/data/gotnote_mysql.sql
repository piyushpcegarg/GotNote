drop schema if exists gotnote;
create schema gotnote character set utf8 COLLATE utf8_unicode_ci;
use gotnote;

--------------------------------------------------------
--  DDL for Table USER_MST
--------------------------------------------------------

  CREATE TABLE USER_MST 
   (	
    USER_ID INT(18) NOT NULL AUTO_INCREMENT, 
	EMAIL_ID VARCHAR(30) NOT NULL, 
	PASSWORD VARCHAR(30) NOT NULL, 
	CREATION_TIME TIMESTAMP NOT NULL,
	LAST_UPDATE_TIME TIMESTAMP NULL,
	CONSTRAINT USER_PK PRIMARY KEY (USER_ID)
   ) ;


-------------------------------------------------------
--  Ref Constraints for Table USER_MST
--------------------------------------------------------

  ALTER TABLE USER_MST ADD CONSTRAINT USER_EMAILID_UK UNIQUE (EMAIL_ID);
  
  
-------------------------------------------------------
--  Dummy data for users for Table USER_MST
--------------------------------------------------------
  
  INSERT INTO USER_MST(USER_ID,EMAIL_ID,PASSWORD,CREATION_TIME) VALUES(1,'piyushpcegarg@gmail.com','password',SYSDATE());
  INSERT INTO USER_MST(USER_ID,EMAIL_ID,PASSWORD,CREATION_TIME) VALUES(2,'roopaljindal@gmail.com','password',SYSDATE());
  
  
--------------------------------------------------------
--  DDL for Table NOTE
--------------------------------------------------------

  CREATE TABLE NOTE 
   (	
    NOTE_ID INT(18) NOT NULL AUTO_INCREMENT, 
	USER_ID INT(18) NOT NULL, 
	NOTE_TITLE VARCHAR(50) NOT NULL, 
	NOTE_DESCRIPTION VARCHAR(1000), 
	CREATION_TIME TIMESTAMP NOT NULL,
	LAST_UPDATE_TIME TIMESTAMP NULL,
	CONSTRAINT NOTE_PK PRIMARY KEY (NOTE_ID)
   ) ;


-------------------------------------------------------
--  Ref Constraints for Table NOTE
--------------------------------------------------------

	ALTER TABLE NOTE ADD CONSTRAINT NOTE_USERID_FK FOREIGN KEY (USER_ID)
	  REFERENCES USER_MST (USER_ID) ;
  