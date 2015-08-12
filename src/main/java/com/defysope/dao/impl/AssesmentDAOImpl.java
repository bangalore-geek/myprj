package com.defysope.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.defysope.dao.AssesmentDAO;
import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.AssesmentType;

@Repository
public class AssesmentDAOImpl implements AssesmentDAO { 

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<AssesmentMaster> getAssesmentMaster() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AssesmentMaster.class);
		return (List<AssesmentMaster>) criteria.list();
	}

	@Override
	public List<AssesmentType> getAssesmentType() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AssesmentType.class);
		return (List<AssesmentType>) criteria.list();
	}

	@Override
	public List<AssesmentCourse> getAssesmentCourses() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AssesmentCourse.class);
		return (List<AssesmentCourse>) criteria.list();
	}
}
