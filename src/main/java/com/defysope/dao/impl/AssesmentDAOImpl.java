package com.defysope.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.defysope.dao.AssesmentDAO;
import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.AssesmentType;
import com.defysope.model.Trainee;
import com.defysope.model.University;

@Repository
public class AssesmentDAOImpl implements AssesmentDAO { 

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	public List<AssesmentCourse> getAssesmentCourses(int courseId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AssesmentCourse.class);
		if (courseId > 0 ) {
			criteria.add(Restrictions.eq("assesmentMasterId", courseId));
		}
		return (List<AssesmentCourse>) criteria.list();
	}

	@Override
	public List<Trainee> getTraineeList(int trainingId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trainee.class);
		if (trainingId > 0 ) {
			criteria.add(Restrictions.eq("assesmentMasterTrainingId", trainingId));
		} 
		return (List<Trainee>) criteria.list();
	}
	
	public List<Map<String, Object>> getQuestion() {
        sessionFactory.getCurrentSession().flush();
        return  jdbcTemplate.queryForList("select question as que,opt1 as op1,opt2 as op2,opt3 as op3,opt4 as op4, correctanswer as ans from tblquestion order by random() limit 5");
    }

	@Override
	public List<AssesmentCourse> getAssesmentForOrganization(int orgId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AssesmentCourse.class);
		return (List<AssesmentCourse>) criteria.list();
	}

	@Override
	public Trainee getTraineeByUserId(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trainee.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (Trainee) criteria.uniqueResult();
	}
}
