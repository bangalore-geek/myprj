package com.defysope.model.kv;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cy_ts_company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cy_ts_company_compid_gen")
	@SequenceGenerator(name = "cy_ts_company_compid_gen", sequenceName = "cy_ts_company_compid_seq")
	private int compId;
	private String companyName;
	private String contactName;
	private String contactEmailId;
	private String contactMobileNum;
	private String licenceType;
	private int licenceId;
	private int createdUser;
	private Date lastUpdatedDate;
	private int lastUpdatedUser;
	private Date createdDate;
	private int lastUpdatedLogin;
	
	public int getCompId() {
		return compId;
	}
	
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactEmailId() {
		return contactEmailId;
	}
	
	public void setContactEmailId(String contactEmailId) {
		this.contactEmailId = contactEmailId;
	}
	
	public String getContactMobileNum() {
		return contactMobileNum;
	}
	
	public void setContactMobileNum(String contactMobileNum) {
		this.contactMobileNum = contactMobileNum;
	}
	
	public String getLicenceType() {
		return licenceType;
	}
	
	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}
	
	public int getLicenceId() {
		return licenceId;
	}
	
	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}
	
	public int getCreatedUser() {
		return createdUser;
	}
	
	public void setCreatedUser(int createdUser) {
		this.createdUser = createdUser;
	}
	
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	public int getLastUpdatedUser() {
		return lastUpdatedUser;
	}
	
	public void setLastUpdatedUser(int lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getLastUpdatedLogin() {
		return lastUpdatedLogin;
	}
	
	public void setLastUpdatedLogin(int lastUpdatedLogin) {
		this.lastUpdatedLogin = lastUpdatedLogin;
	}
}
