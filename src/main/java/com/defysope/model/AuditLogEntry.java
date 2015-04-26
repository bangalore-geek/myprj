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
@Table(name = "tblauditlog")
public class AuditLogEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblauditlog_cid_gen")
	@SequenceGenerator(name = "tblauditlog_cid_gen", sequenceName = "tblauditlog_cid_seq")
	@Column(name = "cid")
	private int id;

	private Date auditDate;

	private int auditCategory;

	private Integer userId;

	private String additionalInfo;

	private String remoteAddress;

	private Integer affectedUserId;

	private Boolean ismailed;

	public AuditLogEntry() {
	}

	public AuditLogEntry(User user, String remoteAddr, String description,
			Integer affectedUserId) {
		this.userId = user != null ? user.getId() : null;
		this.remoteAddress = remoteAddr;
		this.additionalInfo = description;
		this.affectedUserId = affectedUserId;
		this.auditDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public int getAuditCategory() {
		return auditCategory;
	}

	public void setAuditCategory(int auditCategory) {
		this.auditCategory = auditCategory;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public Integer getAffectedUserId() {
		return affectedUserId;
	}

	public void setAffectedUserId(Integer affectedUserId) {
		this.affectedUserId = affectedUserId;
	}

	public Boolean getIsmailed() {
		return ismailed;
	}

	public void setIsmailed(Boolean ismailed) {
		this.ismailed = ismailed;
	}

}
