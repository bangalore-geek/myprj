package com.defysope.model.skillset;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "tblothereducation")
public class OtherEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbleducation_cid_gen")
	@SequenceGenerator(name = "tbleducation_cid_gen", sequenceName = "tbleducation_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbluser", joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "cid")})*/
	private int userId;
	
	private String course;
	private Date yearCompleted;
	private Integer grade;
	private Integer percentage;
	
	// getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Date getYearCompleted() {
		return yearCompleted;
	}
	public void setYearCompleted(Date yearCompleted) {
		this.yearCompleted = yearCompleted;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
}
