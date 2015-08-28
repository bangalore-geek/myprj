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
@Table (name = "tblTrainee")
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblTrainee_cid_gen")
	@SequenceGenerator(name = "tblTrainee_cid_gen", sequenceName = "tblTrainee_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	private int assesmentMasterId;
	private int assesmentMasterTrainingId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Date startDate ;
	private Date endDate;
	private boolean isExpired;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getAssesmentMasterId() {
		return assesmentMasterId;
	}
	
	public void setAssesmentMasterId(int assesmentMasterId) {
		this.assesmentMasterId = assesmentMasterId;
	}
	
	public int getAssesmentMasterTrainingId() {
		return assesmentMasterTrainingId;
	}
	
	public void setAssesmentMasterTrainingId(int assesmentMasterTrainingId) {
		this.assesmentMasterTrainingId = assesmentMasterTrainingId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
}
