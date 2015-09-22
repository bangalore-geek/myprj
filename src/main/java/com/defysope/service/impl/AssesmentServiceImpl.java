package com.defysope.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defysope.dao.AssesmentDAO;
import com.defysope.model.kv.AssesmentType;
import com.defysope.model.kv.Course;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Training;
import com.defysope.service.AssesmentService;

@Service
@Transactional
public class AssesmentServiceImpl implements AssesmentService {

	@Autowired
	private AssesmentDAO assesmentDAO;

	@Override
	public List<Course> getCoursesForCompany(int cmpId) {
		return assesmentDAO.getCoursesForCompany(cmpId);
	}

	@Override
	public List<AssesmentType> getAssesmentType() {
		return assesmentDAO.getAssesmentType();
	}

	@Override
	public List<Training> getTrainings(int cmpId, int courseId) {
		return assesmentDAO.getTrainings(cmpId, courseId);
	}

	@Override
	public List<Trainee> getTraineeList(int trainingId) {
		return assesmentDAO.getTraineeList(trainingId);
	}

	@Override
	public List<Map<String, Object>> getQuestion() {
		return assesmentDAO.getQuestion();
	}

	@Override
	public Trainee getTraineeByUserId(int userId) {
		return assesmentDAO.getTraineeByUserId(userId);
	}

	@Override
	public Trainee getTraineeByEmail(String email) {
		return assesmentDAO.getTraineeByEmail(email);
	}
}