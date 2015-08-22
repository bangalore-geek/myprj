package com.defysope.service;

import java.util.List;

import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.AssesmentType;

public interface AssesmentService {

	public List<AssesmentMaster> getAssesmentMaster();
	
	public List<AssesmentType> getAssesmentType();
	
	public List<AssesmentCourse> getAssesmentCourses(int courseId);
}
