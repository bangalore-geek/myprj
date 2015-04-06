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
@Table(name = "tbluserdetails")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbluserdetails_cid_gen")
	@SequenceGenerator(name = "tbluserdetails_cid_gen", sequenceName = "tbluserdetails_cid_seq")
	@Column(name = "cid")
	private int id;
	private int userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private Date createdDate;
	private Date modifiedDate;
	private Date lastLoginDate;
	private Integer country;

	@ManyToOne(targetEntity = States.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "state", nullable = true)
	private States state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

}
