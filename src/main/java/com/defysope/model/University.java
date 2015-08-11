package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbluniversity")
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbluniversity_cid_gen")
	@SequenceGenerator(name = "tbluniversity_cid_gen", sequenceName = "tbluniversity_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	private String code;
	private String description;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
