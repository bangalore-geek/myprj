package com.defysope.model.kv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cy_kv_company_licence_Details")
public class CompanyLicenceDetails {
	
	public static final String STATUS_ACTIVE = "active";
	public static final String STATUS_INACTIVE = "inactive";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cy_kv_company_licence_details_cid_gen")
	@SequenceGenerator(name = "cy_kv_company_licence_details_cid_gen", sequenceName = "cy_kv_company_licence_details_cid_seq")
	@Column(name = "cid")
	private int id;
	private int cmpId;
	private int productId;
	private Date startDate;
	private Date endDate;
	private int  monthDuration;
	private String status = this.STATUS_INACTIVE;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCmpId() {
		return cmpId;
	}
	public void setCmpId(int cmpId) {
		this.cmpId = cmpId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMonthDuration() {
		return monthDuration;
	}
	public void setMonthDuration(int monthDuration) {
		this.monthDuration = monthDuration;
	}
}
