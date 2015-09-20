package com.defysope.model.skillset;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tbleducation")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbleducation_cid_gen")
	@SequenceGenerator(name = "tbleducation_cid_gen", sequenceName = "tbleducation_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	private int userId;
	private String institutions;
	private String university;
	private Date startdate;
	private Date enddate;
	private String certification;
	private String majorIn;
	private Integer grade;
	private Integer percentage;
	private String description;
		
	public String getInstitutions() {
		return institutions;
	}
	public void setInstitutions(String institutions) {
		this.institutions = institutions;
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
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getMajorIn() {
		return majorIn;
	}
	public void setMajorIn(String majorIn) {
		this.majorIn = majorIn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String course;

	private Integer yearOfPassing;
	private String courseType;

	private Date modifiedDate;
	
	// getter and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Integer getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(Integer yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}