CREATE TABLE tblcountry(
	cid serial not null,
	description character varying(200),
	CONSTRAINT tblcountry_pkey PRIMARY KEY (cid )
)


CREATE TABLE tblstate(
	cid serial not null,
	description character varying(200),
	country integer references tblcountry(cid),
	CONSTRAINT tblstate_pkey PRIMARY KEY (cid )
)

CREATE TABLE tbluser
(
  cid serial NOT NULL,
  userName character varying(200),
  password character varying(100),
  briefcasePassword character varying(100),
  email character varying(100),
  issystemdisabled boolean DEFAULT false,
  CONSTRAINT tbluser_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbluser_userName_key UNIQUE (userName )
)

CREATE TABLE tbluserdetails
(
 cid serial not null,
 userId integer references tbluser(cid),
 firstName character varying(200),
 lastName character varying(200),
 dob timestamp without time zone,
 country  integer references tblcountry(cid),
 state  integer references tblstate(cid),
 createdDate  timestamp without time zone,
 modifiedDate  timestamp without time zone,
 lastLoginDate  timestamp without time zone,
 CONSTRAINT tbluserdetails_pkey PRIMARY KEY (cid )
)

CREATE TABLE tblrole(
  cid serial NOT NULL,
  name character varying(50),
  lastupdatedon timestamp without time zone,
  isprivate boolean DEFAULT false,
  system boolean DEFAULT false,
  description character varying,
  CONSTRAINT tblrole_pkey PRIMARY KEY (cid ),
  CONSTRAINT tblrole_name_key UNIQUE (name )
)

CREATE TABLE tbl_user_roles
(
  cid serial NOT NULL,
  userid integer NOT NULL,
  roleid integer NOT NULL,
  CONSTRAINT tbl_user_roles_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbl_user_roles_fk_1 FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tbl_user_roles_fk_2 FOREIGN KEY (roleid)
      REFERENCES tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE tblaccessrights
(
  cid serial NOT NULL,
  parentid integer,
  description character varying(125),
  code character varying(50),
  enabled boolean NOT NULL DEFAULT true,
  itemorder character varying(250),
  servicecode character varying(500),
  isold boolean DEFAULT false,
  isprivate boolean DEFAULT false,
  isadmin boolean DEFAULT false,
  isemployee boolean DEFAULT false,
  ismanager boolean DEFAULT false,
  CONSTRAINT fk_tblfeatures_pkey PRIMARY KEY (cid ),
  CONSTRAINT fk_role_features_fk_1 FOREIGN KEY (parentid)
      REFERENCES tblaccessrights (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tblaccessrights_code_key UNIQUE (code )
)

CREATE TABLE tbl_role_accessrights
(
  cid serial NOT NULL,
  roleid integer NOT NULL,
  featureid integer NOT NULL,
  read_write_access boolean DEFAULT false,
  CONSTRAINT tbl_role_accessrights_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbl_role_accessrights_fk_1 FOREIGN KEY (featureid)
      REFERENCES tblaccessrights (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tbl_role_accessrights_fk_2 FOREIGN KEY (roleid)
      REFERENCES tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_tbl_role_accessrights_role_feature UNIQUE (roleid , featureid )
)

create table tblbookmark(
 cid serial primary key,
 title varchar(500),
 description varchar(5000),
 url varchar(5000),
 faviconUrl varchar(5000),
 postedDate timestamp without time zone,
 modifiedDate timestamp without time zone,
 userId integer references tbluser(cid),
 softDeleted boolean default false,
 allowPublic boolean default false,
 confidential boolean default false,
 parentId  integer,
 image bytea,
 fileName varchar(500)
)

CREATE TABLE tblauditcategory
(
  cid serial NOT NULL,
  code character varying(100),
  description character varying(500),
  CONSTRAINT tblauditcategory_pkey PRIMARY KEY (cid)
)

CREATE TABLE tblauditlog
(
  cid serial NOT NULL,
  auditdate timestamp without time zone,
  auditcategory integer,
  userid integer,
  additionalinfo character varying(5000),
  remoteaddress character varying(100),
  affecteduserid integer,
  ismailed boolean DEFAULT false,
  CONSTRAINT tblauditlog_pkey PRIMARY KEY (cid),
  CONSTRAINT tblauditlog_auditcategory_fkey FOREIGN KEY (auditcategory)
      REFERENCES tblauditcategory (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tblauditlog_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE tblstudentdetails
(
  cid serial NOT NULL,
  studentid integer,
  gender character varying(50),
  dob timestamp without time zone,
  disability character varying(50),
  currentlocation character varying(50),
  prefferedlocation character varying(50),
  noticeperiod integer,
  experience integer,
  industry character varying(50),
  currentctc integer,
  expectedctc integer,
  modifieddate timestamp without time zone,
  CONSTRAINT tblstudentdetails_pkey PRIMARY KEY (cid),
  CONSTRAINT tblstudentdetails_studentid_fkey FOREIGN KEY (studentid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)


insert into tbluser(username,password,email) values('deepak','sa','rathordeepak1985@yahoo.in')

insert into tbluser(username,password,email) values('arun','sa','rathordeepak1985@yahoo.in')

insert into tbluser(username,password,email) values('akash','sa','rathordeepak1985@yahoo.in')

insert into tblrole(name,description) values('admin','Administrator')

insert into tblrole(name,description) values('Manager','Manager')

insert into tblrole(name,description) values('employee','Employee')

insert into tbl_user_roles(userid,roleid) values(1,1);

insert into tbl_user_roles(userid,roleid) values(2,1);

insert into tbl_user_roles(userid,roleid) values(3,3);

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Home Page','pg_home',true,true,true,true)

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Admin Page','pg_adm_home',true,true,false,false)

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Manager Page','pg_mgr_home',true,true,false,true)

insert into tblaccessrights(description,code,enabled,isadmin,isemployee,ismanager) 
values('Employee Page','pg_emp_home',true,true,true,false)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(1,1,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(1,2,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(1,3,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(2,1,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(2,2,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(3,1,true)

insert into tbl_role_accessrights(roleid,featureid,read_write_access) 
values(3,3,true)
