-- Table: maintain the details of the students only.
CREATE TABLE tblstudentdetails
(
  cid serial NOT NULL,
  studentid integer,
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
  CONSTRAINT tblstudentdetails_pkey PRIMARY KEY (cid),
  CONSTRAINT tblstudentdetails_studentid_fkey FOREIGN KEY (studentid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tblstudentdetails
  OWNER TO postgres;
  
-- Table: maintain address of the user 
CREATE TABLE tbladdress
(
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
  userid integer,
  CONSTRAINT tbladdress_pkey PRIMARY KEY (cid),
  CONSTRAINT tbladdress_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbladdress
  OWNER TO postgres;

-- Table: maintain education details of the users	
CREATE TABLE tbleducation
(
  cid serial NOT NULL,
  course character varying(200),
  university character varying(200),
  yearofpassing integer,
  coursetype character varying(200),
  grade integer,
  percentage integer,
  userid integer,
  CONSTRAINT tbleducation_pkey PRIMARY KEY (cid),
  CONSTRAINT tbleducation_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbleducation
  OWNER TO postgres;

-- Table: lookup table for skills
CREATE TABLE tblskillset
(
  cid serial NOT NULL,
  description character varying(200),
  code character varying(200),
  CONSTRAINT tblskillset_pkey PRIMARY KEY (cid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tblskillset
  OWNER TO postgres;
  
-- Table: maintain skills details for the users
CREATE TABLE tblskilldetails
(
  cid serial NOT NULL,
  skillid integer,
  userid integer,
  CONSTRAINT tblskilldetails_pkey PRIMARY KEY (cid),
  CONSTRAINT tblskilldetails_skillid_fkey FOREIGN KEY (skillid)
      REFERENCES tblskillset (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tblskilldetails_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tblskilldetails
  OWNER TO postgres;
  

-- Table: maintains the workhistory for the students 
CREATE TABLE workhistory
(
  cid serial NOT NULL,
  userid integer,
  companyname character varying(250),
  designation character varying(250),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  jobtype character varying(250),
  CONSTRAINT workhistory_pkey PRIMARY KEY (cid),
  CONSTRAINT workhistory_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE workhistory
  OWNER TO postgres;

-- Table: maintains the details address for the users
CREATE TABLE tbladdressdetails
(
  cid serial NOT NULL,
  userid integer,
  presentaddress character varying(250),
  permanentaddress character varying(250),
  contactaddress character varying(250),
  CONSTRAINT tbladdressdetails_pkey PRIMARY KEY (cid),
  CONSTRAINT tbladdressdetails_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbladdressdetails
  OWNER TO postgres;

  
-- Table: maintains the extra qualification for the address e.g oracle certification ..
CREATE TABLE tblothereducation
(
  cid serial NOT NULL,
  userid integer,
  course character varying(250),
  yearcompleted timestamp without time zone,
  grade integer,
  percentage integer,
  CONSTRAINT tblothereducation_pkey PRIMARY KEY (cid),
  CONSTRAINT tblothereducation_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tblothereducation
  OWNER TO postgres;
