package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblbookmarkcategory")
public class BookmarkCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblbookmarkcategory_cid_gen")
	@SequenceGenerator(name = "tblbookmarkcategory_cid_gen", sequenceName = "tblbookmarkcategory_cid_seq")
	@Column(name = "cid")
	private int id;
	private String description;
	private Integer userId;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
