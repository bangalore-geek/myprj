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
@Table(name = "tblbookmark")
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblbookmark_cid_gen")
	@SequenceGenerator(name = "tblbookmark_cid_gen", sequenceName = "tblbookmark_cid_seq")
	@Column(name = "cid")
	private int id;
	private String title;
	private String description;
	private String url;
	private String faviconUrl;
	private Date postedDate;
	private Date modifiedDate;
	private Integer userId;
	private Boolean softDeleted = false;
	private Boolean allowPublic = false;
	private Boolean confidential = false;
	private Integer parentId;
	private byte[] image;
	private String fileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFaviconUrl() {
		return faviconUrl;
	}

	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getSoftDeleted() {
		return softDeleted;
	}

	public void setSoftDeleted(Boolean softDeleted) {
		this.softDeleted = softDeleted;
	}

	public Boolean getAllowPublic() {
		return allowPublic;
	}

	public void setAllowPublic(Boolean allowPublic) {
		this.allowPublic = allowPublic;
	}

	public Boolean getConfidential() {
		return confidential;
	}

	public void setConfidential(Boolean confidential) {
		this.confidential = confidential;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
