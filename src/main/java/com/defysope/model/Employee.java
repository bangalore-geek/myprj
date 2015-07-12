package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tblemp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblemp_cid_gen")
	@SequenceGenerator(name = "tblemp_cid_gen", sequenceName = "tblemp_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	private String empName;
	private String empAdress;
	private Integer empPhoneNo;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpAdress() {
		return empAdress;
	}
	
	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}
	
	public Integer getEmpPhoneNo() {
		return empPhoneNo;
	}
	
	public void setEmpPhoneNo(Integer empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}
}
