package com.defysope.dao;

import java.util.List;
import java.util.Map;

import com.defysope.model.kv.AssesmentType;
import com.defysope.model.kv.Course;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Training;

public interface AssesmentDAO {

	public List<Course> getCoursesForCompany(int cmpId);

	public List<AssesmentType> getAssesmentType();

	public List<Training> getTrainings(int cmpId, int courseId);

	public List<Trainee> getTraineeList(int trainingId);
	
	public List<Map<String, Object>> getQuestion();

	public Trainee getTraineeByUserId(int userId);

	public Trainee getTraineeByEmail(String email);
}
