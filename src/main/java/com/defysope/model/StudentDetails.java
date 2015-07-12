package com.defysope.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblstudentdetails")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblstudentdetails_cid_gen")
	@SequenceGenerator(name = "tblstudentdetails_cid_gen", sequenceName = "tblstudentdetails_cid_seq")
	@Column(name = "cid")
	private Integer id;

	@Column(name = "studentId")
	private int studentId;

	private String gender;
	private Date dob;
	private String disability;
	private String currentLocation;
	private String prefferedLocation;
	private Integer noticePeriod;
	private Integer experience;
	private String industry;
	private Integer currentCtc;
	private Integer expectedCtc;
	private Date modifiedDate;

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getPrefferedLocation() {
		return prefferedLocation;
	}

	public void setPrefferedLocation(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}

	public Integer getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getCurrentCtc() {
		return currentCtc;
	}

	public void setCurrentCtc(Integer currentCtc) {
		this.currentCtc = currentCtc;
	}

	public Integer getExpectedCtc() {
		return expectedCtc;
	}

	public void setExpectedCtc(Integer expectedCtc) {
		this.expectedCtc = expectedCtc;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}