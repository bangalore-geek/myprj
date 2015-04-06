package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblcountry")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblcountry_cid_gen")
	@SequenceGenerator(name = "tblcountry_cid_gen", sequenceName = "tblcountry_cid_seq")
	@Column(name = "cid")
	private int id;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
