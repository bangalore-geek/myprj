package com.defysope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defysope.dao.AssesmentDAO;
import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.AssesmentType;
import com.defysope.service.AssesmentService;

@Service
@Transactional
public class AssesmentServiceImpl implements AssesmentService {

	@Autowired
	private AssesmentDAO assesmentDAO;

	@Override
	public List<AssesmentMaster> getAssesmentMaster() {
		return assesmentDAO.getAssesmentMaster();
	}

	@Override
	public List<AssesmentType> getAssesmentType() {
		return assesmentDAO.getAssesmentType();
	}

	@Override
	public List<AssesmentCourse> getAssesmentCourses() {
		return assesmentDAO.getAssesmentCourses();
	}

}
