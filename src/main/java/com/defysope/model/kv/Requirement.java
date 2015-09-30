package com.defysope.model.kv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cy_kv_requirement")
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cy_kv_requirement_requirementid_gen")
	@SequenceGenerator(name = "cy_kv_requirement_requirementid_gen", sequenceName = "cy_kv_requirement_requirementid_seq")
	@Column(name = "requirementid")
	private int id;
	private int compId;
	private String companyJobCode;
	private String jobDescription;
	private String jobDesignation;
	private String minExperience;
	private String maxExperience;
	private String status;
	private Date startDate;
	private Date endDate;
	private String noticePeriod;
	private int currentCtc;
	private String employmentType;
	private Date creationDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompId() {
		return compId;
	}
	
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	
	public String getCompanyJobCode() {
		return companyJobCode;
	}
	
	public void setCompanyJobCode(String companyJobCode) {
		this.companyJobCode = companyJobCode;
	}
	
	
	public String getJobDescription() {
		return jobDescription;
	}
	
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
	public String getJobDesignation() {
		return jobDesignation;
	}
	
	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}
	
	
	public String getMinExperience() {
		return minExperience;
	}
	
	public void setMinExperience(String minExperience) {
		this.minExperience = minExperience;
	}
	
	
	public String getMaxExperience() {
		return maxExperience;
	}
	
	public void setMaxExperience(String maxExperience) {
		this.maxExperience = maxExperience;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	public String getNoticePeriod() {
		return noticePeriod;
	}
	
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	
	
	public int getCurrentCtc() {
		return currentCtc;
	}
	
	public void setCurrentCtc(int currentCtc) {
		this.currentCtc = currentCtc;
	}
	
	
	public String getEmploymentType() {
		return employmentType;
	}
	
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
