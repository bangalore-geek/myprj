package com.defysope.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tblAssesmentCourse")
public class AssesmentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblAssesmentCourse_cid_gen")
	@SequenceGenerator(name = "tblAssesmentCourse_cid_gen", sequenceName = "tblAssesmentCourse_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	private String courseNumber;
	private String courseDescription;
	private int assesmentMasterId;
	private Date startdate;
	private Date enddate;
	private Date assesmentDate;
	private String coustomer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getAssesmentMasterId() {
		return assesmentMasterId;
	}
	public void setAssesmentMasterId(int assesmentMasterId) {
		this.assesmentMasterId = assesmentMasterId;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Date getAssesmentDate() {
		return assesmentDate;
	}
	public void setAssesmentDate(Date assesmentDate) {
		this.assesmentDate = assesmentDate;
	}
	public String getCoustomer() {
		return coustomer;
	}
	public void setCoustomer(String coustomer) {
		this.coustomer = coustomer;
	}
}
