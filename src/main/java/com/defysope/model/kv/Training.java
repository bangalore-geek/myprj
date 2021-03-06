package com.defysope.model.kv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "tblTraining")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblTraining_cid_gen")
	@SequenceGenerator(name = "tblTraining_cid_gen", sequenceName = "tblTraining_cid_seq")
	@Column(name = "cid")
	private Integer id;
	
	private String name;
	private String courseNumber;
	private String courseDescription;
	private int assesmentMasterId;
	private Date startdate;
	private Date enddate;
	private Date assesmentDate;
	private String coustomer;
	private String trainingName;
	private String traininerName;

	@Transient
	private  List<Trainee> traineeList = new ArrayList<Trainee>(); 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getAssesmentMasterId() {
		return assesmentMasterId;
	}
	public void setAssesmentMasterId(int assesmentMasterId) {
		this.assesmentMasterId = assesmentMasterId;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Date getAssesmentDate() {
		return assesmentDate;
	}
	public void setAssesmentDate(Date assesmentDate) {
		this.assesmentDate = assesmentDate;
	}
	public String getCoustomer() {
		return coustomer;
	}
	public void setCoustomer(String coustomer) {
		this.coustomer = coustomer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTraininerName() {
		return traininerName;
	}
	public void setTraininerName(String traininerName) {
		this.traininerName = traininerName;
	}
	public List<Trainee> getTraineeList() {
		return traineeList;
	}
	public void setTraineeList(List<Trainee> traineeList) {
		this.traineeList = traineeList;
	}
}