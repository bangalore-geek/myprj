-- assessment

create table tblAssesmentType(
  cid serial primary key,
  description varchar(200),
  code varchar(5)
)

create table tblAssesmentMaster(
 cid serial primary key,
 trainingNo varchar(100) unique,
 description varchar(5000),
 version varchar(50),
 active boolean default true,
 assesmentType varchar(100),
 createdDate timestamp without time zone,
 modifiedDate timestamp without time zone,
 orgId integer,
 createdBy integer
)

create table tblAssesmentCourse(
   cid serial primary key,
   courseNumber varchar(10) unique,
   courseDescription varchar(500),
   assesmentMasterId integer,
   startDate timestamp without time zone,
   endDate timestamp without time zone,
   assesmentDate timestamp without time zone,
   coustomer varchar(500)
)

-- profile page 
ALTER TABLE tblstudentdetails add firstname character varying(200);
ALTER TABLE tblstudentdetails add middlename character varying(200);
ALTER TABLE tblstudentdetails add lastname character varying(200);
ALTER TABLE tblstudentdetails add maritalStatus character varying(200);
ALTER TABLE tblstudentdetails add passport character varying(200);
ALTER TABLE tblstudentdetails add pancard character varying(200);
ALTER TABLE tblstudentdetails add aadharcard character varying(200);
ALTER TABLE tblstudentdetails add extraCurricularActivities character varying(1000);

-- mapping table for email and contact
ALTER TABLE tbleducation add institutions character varying(200);
ALTER TABLE tbleducation add startdate timestamp without time zone;
ALTER TABLE tbleducation add enddate timestamp without time zone;
ALTER TABLE tbleducation add certification character varying(200);
ALTER TABLE tbleducation add majorin character varying(1000);
ALTER TABLE tbleducation add description character varying(1000);

ALTER TABLE tblworkhistory add location character varying(200);
ALTER TABLE tblworkhistory add title character varying(200);
ALTER TABLE tblworkhistory add description character varying(1000);

create table tblusrereferences(
	cid serial PRIMARY KEY NOT NULL,
	userid integer REFERENCES tbluser (cid),
	name character varying(200),
	relationship character varying(200),
	email character varying(100),
	phone integer
);

CREATE TABLE tbluniversity
(
  cid serial NOT NULL,
  description character varying(200),
  code character varying(200),
  CONSTRAINT tbluniversity_pkey PRIMARY KEY (cid)
);

-- 31 aut-2015
ALTER TABLE tbluser add firstName character varying(200);
ALTER TABLE tbluser add middelName character varying(200);
ALTER TABLE tbluser add lastName character varying(200);

ALTER TABLE tbluserdetails add maritalStatus boolean DEFAULT false;
ALTER TABLE tbluserdetails add passport character varying(50),
ALTER TABLE tbluserdetails add pancard character varying(50),

ALTER TABLE tbluserdetails add maritalStatus boolean DEFAULT false;
ALTER TABLE tbluserdetails add passport character varying(50),
ALTER TABLE tbluserdetails add pancard character varying(50),

ALTER TABLE tbladdress add address3 character varying(200);
ALTER TABLE tbladdress add location character varying(200);
ALTER TABLE tbladdress add description character varying(200);

ALTER TABLE tbleducation add description character varying(200);

ALTER TABLE tbluser add column modifieddate timestamp without time zone ;