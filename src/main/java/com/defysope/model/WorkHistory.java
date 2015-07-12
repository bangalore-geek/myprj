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
@Table (name = "tblworkhistory")
public class WorkHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "workhistory_cid_gen")
	@SequenceGenerator(name = "workhistory_cid_gen", sequenceName = "workhistory_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
/*	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbluser", joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "cid")})*/
	
	@Column(name = "userid")
	private int userId;
	
	private String companyName;
	private String designation;
	private Date startdate;
	private Date enddate;
	private String jobType;
	
	// generate getter and setter
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
}
