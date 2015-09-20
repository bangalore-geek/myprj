package com.defysope.model.skillset;

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

import com.defysope.model.User;

@Entity
@Table(name = "tbladdress")
public class Address {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "tbladdress_cid_gen")
	@SequenceGenerator (name = "tbladdress_cid_gen", sequenceName = "tbladdress_cid_gen")
	@Column (name = "cid")
	private Integer id;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = true)
	private User userId;

	private Integer corporateId;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
	private Integer pin;
	private Integer phone1;
	private Integer phone2;
	private Integer mobile1;
	private Integer mobile2;
	private Date modifiedDate;
	private String location;
	private String description;

	// getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Integer getCorporateId() {
		return corporateId;
	}
	public void setCorporateId(Integer corporateId) {
		this.corporateId = corporateId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Integer getPhone1() {
		return phone1;
	}
	public void setPhone1(Integer phone1) {
		this.phone1 = phone1;
	}
	public Integer getPhone2() {
		return phone2;
	}
	public void setPhone2(Integer phone2) {
		this.phone2 = phone2;
	}
	public Integer getMobile1() {
		return mobile1;
	}
	public void setMobile1(Integer mobile1) {
		this.mobile1 = mobile1;
	}
	public Integer getMobile2() {
		return mobile2;
	}
	public void setMobile2(Integer mobile2) {
		this.mobile2 = mobile2;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}