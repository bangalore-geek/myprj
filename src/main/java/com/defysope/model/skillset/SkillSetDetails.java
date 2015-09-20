package com.defysope.model.skillset;

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
@Table (name = "tblskilldetails")
public class SkillSetDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblskilldetails_cid_gen")
	@SequenceGenerator(name = "tblskilldetails_cid_gen", sequenceName = "tblskilldetails_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = true)
	private User userId;
	
	@ManyToOne(targetEntity = SkillSet.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "skillId", nullable = true)
	private SkillSet skillId;

	// getter and setter
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
	public SkillSet getSkillId() {
		return skillId;
	}
	public void setSkillId(SkillSet skillId) {
		this.skillId = skillId;
	}
}