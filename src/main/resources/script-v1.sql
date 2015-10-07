CREATE TABLE cy_ts_product_master (
  product_id serial NOT NULL,
  description character varying(2000),
  name character varying(2000),
  CONSTRAINT cy_ts_product_master_pkey PRIMARY KEY (product_id)
);

CREATE TABLE cy_kv_company_licence_Details (
  cid serial PRIMARY KEY NOT NULL,
  cmpid INTEGER,
  productid INTEGER,
  monthDuration INTEGER,
  startdate timestamp without time zone,
  enddate timestamp without time zone,  
  status character varying(2000)
);

CREATE TABLE tblcountry (
	cid serial not null,
	description character varying(1000),
	CONSTRAINT tblcountry_pkey PRIMARY KEY (cid )
);

CREATE TABLE tblstate (
	cid serial not null,
	description character varying(1000),
	country integer references tblcountry(cid),
	CONSTRAINT tblstate_pkey PRIMARY KEY (cid )
);

CREATE TABLE tbluniversity (
  cid serial NOT NULL,
  description character varying(200),
  code character varying(200),
  CONSTRAINT tbluniversity_pkey PRIMARY KEY (cid)
);

CREATE TABLE tblrole(
  cid serial NOT NULL,
  name character varying(1000),
  lastupdatedon timestamp without time zone,
  isprivate boolean DEFAULT false,
  system boolean DEFAULT false,
  description character varying,
  CONSTRAINT tblrole_pkey PRIMARY KEY (cid ),
  CONSTRAINT tblrole_name_key UNIQUE (name )
);

CREATE TABLE tblaccessrights (
  cid serial NOT NULL,
  parentid integer references tblaccessrights(cid),
  description character varying(1000),
  code character varying(1000),
  enabled boolean NOT NULL DEFAULT true,
  itemorder character varying(250),
  servicecode character varying(1000),
  isold boolean DEFAULT false,
  isprivate boolean DEFAULT false,
  isadmin boolean DEFAULT false,
  isemployee boolean DEFAULT false,
  ismanager boolean DEFAULT false,
  CONSTRAINT fk_tblfeatures_pkey PRIMARY KEY (cid ),
  CONSTRAINT tblaccessrights_code_key UNIQUE (code )
);

CREATE TABLE cy_ts_company (
  cmpid serial NOT NULL,
  companyname character varying(1000) NOT NULL,
  contactname character varying(1000) NOT NULL,
  contactemailid character varying(1000) NOT NULL,
  contactmobilenum character varying(1000) NOT NULL,
  licencetype character varying(1000),
  licenceid integer,
  createduser integer,
  lastupdateddate timestamp without time zone,
  lastupdateduser integer,
  createddate timestamp without time zone,
  lastupdatedlogin integer,
  companymobilenum character varying(1000),
  tinnumber character varying(1000),
  approvedon timestamp without time zone,
  approvedby integer,
  isapproved boolean DEFAULT false,
  CONSTRAINT cy_ts_company_pkey PRIMARY KEY (compid)
);

CREATE TABLE tbluser (
  cid serial NOT NULL,
  name character varying(1000),
  userName character varying(1000),
  password character varying(1000),
  briefcasePassword character varying(1000),
  issystemdisabled boolean DEFAULT false,
  usertype integer,
  modifieddate timestamp without time zone,
  email character varying(1000),
  cmpid integer references cy_ts_company (cmpid),
  CONSTRAINT tbluser_pkey PRIMARY KEY (cid ),
  CONSTRAINT tbluser_userName_key UNIQUE (userName )
);

CREATE TABLE tblauditcategory (
  cid serial NOT NULL,
  code character varying(100),
  description character varying(500),
  CONSTRAINT tblauditcategory_pkey PRIMARY KEY (cid)
);

CREATE TABLE tblauditlog (
  cid serial NOT NULL,
  auditdate timestamp without time zone,
  auditcategory integer REFERENCES tblauditcategory (cid),
  userid integer REFERENCES tbluser (cid),
  additionalinfo character varying(5000),
  remoteaddress character varying(100),
  affecteduserid integer,
  ismailed boolean DEFAULT false,
  CONSTRAINT tblauditlog_pkey PRIMARY KEY (cid)
);

CREATE TABLE tbluserdetails (
 cid serial not null,
 userId integer references tbluser(cid),
 firstName character varying(1000),
 lastName character varying(1000),
 dob timestamp without time zone,
 country  integer references tblcountry(cid),
 state  integer references tblstate(cid),
 createdDate  timestamp without time zone,
 modifiedDate  timestamp without time zone,
 lastLoginDate  timestamp without time zone,
 CONSTRAINT tbluserdetails_pkey PRIMARY KEY (cid )
);

CREATE TABLE tbl_user_roles (
  cid serial NOT NULL,
  userid integer REFERENCES tbluser (cid) NOT NULL,
  roleid integer  REFERENCES tblrole (cid) NOT NULL,
  CONSTRAINT tbl_user_roles_pkey PRIMARY KEY (cid)
);

CREATE TABLE tbl_role_accessrights (
  cid serial NOT NULL,
  roleid integer REFERENCES tblrole (cid) NOT NULL,
  featureid integer REFERENCES tblaccessrights (cid) NOT NULL,
  read_write_access boolean DEFAULT false,
  CONSTRAINT tbl_role_accessrights_pkey PRIMARY KEY (cid ),      
  CONSTRAINT uq_tbl_role_accessrights_role_feature UNIQUE (roleid , featureid )
);

CREATE TABLE tblstudentdetails (
  cid serial NOT NULL,
  studentid integer REFERENCES tbluser (cid),
  gender character varying(50),
  firstName varchar(500),
  lastName varchar(500),
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
  CONSTRAINT tblstudentdetails_pkey PRIMARY KEY (cid)
);

-- kv related tables 

create table tblAssesmentType(
  cid serial primary key,
  description varchar(200),
  code varchar(5)
);

CREATE TABLE tblcourse (
  cid serial NOT NULL,
  createdby integer references tbluser(cid),
  name character varying(1000),
  trainingno character varying(1000),
  description character varying(5000),
  version character varying(1000),
  active boolean DEFAULT true,
  assesmenttype character varying(1000),
  createddate timestamp without time zone,
  modifieddate timestamp without time zone,
  status character varying(1000),
  cmpid integer references cy_ts_company (cmpid) ,
  CONSTRAINT tblcourse_pkey PRIMARY KEY (cid),
  CONSTRAINT tblcourse_trainingno_key UNIQUE (trainingno)
);

CREATE TABLE tbltraining (
  cid serial NOT NULL,
  coursenumber character varying(1000),
  coursedescription character varying(5000),
  assesmentmasterid integer references tblcourse (cid),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  assesmentdate timestamp without time zone,
  coustomer character varying(500),
  name character varying(1000),
  trainingname character varying(1000),
  traininername character varying(1000),
  cmpid integer references cy_ts_company (cmpid),
  CONSTRAINT tbltraining_pkey PRIMARY KEY (cid),
  CONSTRAINT tbltraining_coursenumber_key UNIQUE (coursenumber)
);

CREATE TABLE tbltrainee (
  cid serial NOT NULL,
  name character varying(1000),
  email character varying(1000),
  phone character varying(1000),
  password character varying(1000),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  isexpired boolean DEFAULT false,
  userid integer REFERENCES tbluser (cid),
  courseid integer REFERENCES tblcourse (cid) ,
  trainingid integer REFERENCES tbltraining (cid),
  cmpid integer REFERENCES cy_ts_company (cmpid),
  CONSTRAINT tbltrainee_pkey PRIMARY KEY (cid)
);

CREATE TABLE cy_kv_requirement (
  requirementid serial NOT NULL,
  compid integer REFERENCES cy_ts_company (cmpid),
  companyjobcode character varying(1000),
  jobdesignation character varying(1000),
  minexperience character varying(1000),
  maxexperience character varying(1000),
  status character varying(1000),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  noticeperiod character varying(1000),
  currentctc integer,
  employmenttype character varying(1000),
  creationdate timestamp without time zone,
  createdby character varying(1000),
  updateddate timestamp without time zone,
  updatedby character varying(1000),
  jobdescription character varying(1000),
  CONSTRAINT cy_kv_requirement_pkey PRIMARY KEY (requirementid)
);

CREATE TABLE tblcandidate (
  cid serial NOT NULL,
  name character varying(1000),
  email character varying(1000),
  phone character varying(1000),
  password character varying(1000),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  isexpired boolean DEFAULT false,
  userid integer REFERENCES tbluser (cid),
  requirementid integer REFERENCES cy_kv_requirement (requirementid),
  cmpid integer REFERENCES cy_ts_company (cmpid),
  CONSTRAINT tblcandidate_pkey PRIMARY KEY (cid)
);

-- ===========================================
CREATE TABLE tbladdress (
  cid serial NOT NULL,
  corporateid integer,
  address1 character varying(200),
  address2 character varying(200),
  city character varying(200),
  state character varying(200),
  country character varying(200),
  pin integer,
  phone1 integer,
  phone2 integer,
  mobile1 integer,
  mobile2 integer,
  userid integer REFERENCES tbluser (cid),
  CONSTRAINT tbladdress_pkey PRIMARY KEY (cid)
);

CREATE TABLE tbleducation (
  cid serial NOT NULL,
  course character varying(200),
  university character varying(200),
  yearofpassing integer,
  coursetype character varying(200),
  grade integer,
  percentage integer,
  userid integer REFERENCES tbluser (cid),
  CONSTRAINT tbleducation_pkey PRIMARY KEY (cid)
);

CREATE TABLE tblskillset (
  cid serial NOT NULL,
  description character varying(200),
  code character varying(200),
  CONSTRAINT tblskillset_pkey PRIMARY KEY (cid)
);

CREATE TABLE tblskilldetails (
  cid serial NOT NULL,
  skillid integer REFERENCES tblskillset (cid),
  userid integer REFERENCES tbluser (cid),
  CONSTRAINT tblskilldetails_pkey PRIMARY KEY (cid)
);

CREATE TABLE tblworkhistory (
  cid serial NOT NULL,
  userid integer REFERENCES tbluser (cid),
  companyname character varying(1000),
  designation character varying(1000),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  jobtype character varying(1000),
  CONSTRAINT workhistory_pkey PRIMARY KEY (cid)
);

CREATE TABLE tbladdressdetails (
  cid serial NOT NULL,
  userid integer REFERENCES tbluser (cid),
  presentaddress character varying(250),
  permanentaddress character varying(250),
  contactaddress character varying(250),
  CONSTRAINT tbladdressdetails_pkey PRIMARY KEY (cid)
);

CREATE TABLE tblothereducation (
  cid serial NOT NULL,
  userid integer REFERENCES tbluser (cid),
  course character varying(1000),
  yearcompleted timestamp without time zone,
  grade integer,
  percentage integer,
  CONSTRAINT tblothereducation_pkey PRIMARY KEY (cid)
);

-- insert query for tblaccessright
insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Create New User', 'df_create_user', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Create New Role', 'df_create_role', true, false, false, true, false, false);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Administration', 'df_adminstration', true, false, false, true, false, false);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Manage User', 'df_manage_user', true, false, false, true, false, false);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Student Profile', 'df_student_profile', true, false, false, true, true,false);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Home Page', 'df_home_page', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Search Job', 'df_search_job', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Search Training', 'df_search_training', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Freelancer Profile', 'df_freelancer_profile', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Become Trainer', 'df_become_trainer', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Post a Job', 'df_post_job', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Search Candidate', 'df_search_candidate', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Company Profile', 'df_company_profile', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Configure Assessment', 'df_configure_assessment', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Configure Course', 'df_configure_assessment_course', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Configure Training', 'df_configure_assessment_training', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Configure Trainee', 'df_configure_assessment_trainee', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Manage Assessment', 'df_manage_assessment', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Impoter', 'df_impoter', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Training Attendance', 'df_training_attendance', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Create company user', 'df_create_company_user', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Configure interview', 'df_configure_interview', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Attend Test', 'df_attend_test', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Attend Interview', 'df_attend_interview', true, false, false, true, true, true);

insert into tblaccessrights(description, code, enabled, isold, isprivate, isadmin, isemployee, ismanager) values ('Approve company', 'df_approve_company', true, false, false, true, true, true);


-- inserting into company table

insert into cy_ts_company (companyname, tinnumber, contactmobilenum, contactname, contactemailid) values ('corpyogi', 'HKAH6786', '9035585040', 'sanjay', 'sanjay@rasls.com');

-- inserting into user table
insert into tbluser(name, username, password, briefcasepassword, usertype, email,cmpid ) values ('yogesh rathore ', 'yogesh', '$2a$10$78sNXmOHnlcxEmke4idBJe2O9EuLJIkQCwomPefJnosrNyxVcv1Pi', '$2a$10$78sNXmOHnlcxEmke4idBJe2O9EuLJIkQCwomPefJnosrNyxVcv1Pi', 1, 'yogesh.rathore@rasls.com', 1);

-- inserting into assessment type table
insert into tblassesmenttype(description, code) values('Live', '01');
insert into tblassesmenttype(description, code) values('Class room', '02');
