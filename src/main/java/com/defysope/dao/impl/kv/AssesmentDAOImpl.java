package com.defysope.dao.impl.kv;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.defysope.dao.kv.AssesmentDAO;
import com.defysope.model.kv.AssesmentType;
import com.defysope.model.kv.Candidate;
import com.defysope.model.kv.Course;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Training;

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
	public List<Course> getCoursesForCompany(int cmpId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("cmpId", cmpId));
		return (List<Course>) criteria.list();
	}

	@Override
	public List<AssesmentType> getAssesmentType() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AssesmentType.class);
		return (List<AssesmentType>) criteria.list();
	}

	@Override
	public List<Training> getTrainings(int cmpId, int courseId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Training.class);
		if (cmpId > 0) {
			criteria.add(Restrictions.eq("cmpId", cmpId));
		}
		if (courseId > 0) {
			criteria.add(Restrictions.eq("assesmentMasterId", courseId));	
		}
		return (List<Training>) criteria.list();
	}

	@Override
	public List<Trainee> getTraineeList(int trainingId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trainee.class);
		if (trainingId > 0 ) {			  
			criteria.add(Restrictions.eq("trainingId", trainingId));
		} 
		return (List<Trainee>) criteria.list();
	}
	
	public List<Map<String, Object>> getQuestion() {
        sessionFactory.getCurrentSession().flush();
        return  jdbcTemplate.queryForList("select question as que,opt1 as op1,opt2 as op2,opt3 as op3,opt4 as op4, correctanswer as ans from tblquestion order by random() limit 5");
    }

	@Override
	public Trainee getTraineeByUserId(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trainee.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (Trainee) criteria.uniqueResult();
	}

	@Override
	public Trainee getTraineeByEmail(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trainee.class);
		criteria.add(Restrictions.eq("email", email));
		return (Trainee) criteria.uniqueResult();
	}

	@Override
	public Course getCourse(int cmpId, int courseId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("cmpId", cmpId));
		criteria.add(Restrictions.eq("id", courseId));
		return (Course) criteria.uniqueResult();
	}

	@Override
	public Training getTraining(int cmpId, int courseId, int trainingId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Training.class);
		criteria.add(Restrictions.eq("cmpId", cmpId));
		criteria.add(Restrictions.eq("id", courseId));
		criteria.add(Restrictions.eq("id", trainingId));
		return (Training) criteria.uniqueResult();
	}

	@Override
	public List<Candidate> getCandidateList(int compId, int requirementId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Candidate.class);
		criteria.add(Restrictions.eq("cmpId", compId));
		criteria.add(Restrictions.eq("requirementId", requirementId));
		return (List<Candidate>) criteria.list();
	}
}
