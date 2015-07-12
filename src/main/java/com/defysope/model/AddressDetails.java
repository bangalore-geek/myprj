package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tbladdressdetails")
public class AddressDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbladdressdetails_cid_gen")
	@SequenceGenerator(name = "tbladdressdetails_cid_gen", sequenceName = "tbladdressdetails_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
/*	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbluser", joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "cid")})*/
	private int userId;
	
	private String presentAddress;
	private String permanentAddress;
	private String contactaddress;
	
	// getter and setter
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
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
}