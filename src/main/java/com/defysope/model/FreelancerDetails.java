package com.defysope.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblfreelancerdetails")
public class FreelancerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblfreelancerdetails_cid_gen")
	@SequenceGenerator(name = "tblfreelancerdetails_cid_gen", sequenceName = "tblfreelancerdetails_cid_seq")
	private Integer id;

	private String gender;

	private String prefferedLocation;

	private boolean disability;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrefferedLocation() {
		return prefferedLocation;
	}

	public void setPrefferedLocation(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}

	public boolean isDisability() {
		return disability;
	}

	public void setDisability(boolean disability) {
		this.disability = disability;
	}
}