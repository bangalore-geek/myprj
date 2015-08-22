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
@Table(name = "tblAssesmentMaster")
public class AssesmentMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblAssesmentMaster_cid_gen")
	@SequenceGenerator(name = "tblAssesmentMaster_cid_gen", sequenceName = "tblAssesmentMaster_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	@Column(name = "createdBy")
	private int createdBy;

	private String name;
	private String trainingNo;
	private String description;
	private String version;
	private boolean active = true;
	private String assesmentType;
	private Date createdDate;
	private Date modifiedDate;
	private int orgId;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getTrainingNo() {
		return trainingNo;
	}
	public void setTrainingNo(String trainingNo) {
		this.trainingNo = trainingNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAssesmentType() {
		return assesmentType;
	}
	public void setAssesmentType(String assesmentType) {
		this.assesmentType = assesmentType;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}