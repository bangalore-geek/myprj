package com.defysope.dao;

import java.util.List;

import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.AssesmentType;

public interface AssesmentDAO {

	public List<AssesmentMaster> getAssesmentMaster();

	public List<AssesmentType> getAssesmentType();

	public List<AssesmentCourse> getAssesmentCourses(int courseId);
}
