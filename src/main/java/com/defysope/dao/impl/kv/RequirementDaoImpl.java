package com.defysope.dao.impl.kv;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.defysope.dao.kv.RequirementDao;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Requirement;

@Repository
public class RequirementDaoImpl implements RequirementDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Requirement> getRequirementForCompany(int companyId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Requirement.class);
		if (companyId > 0) {
			criteria.add(Restrictions.eq("compId", companyId));
		}
		return (List<Requirement>)criteria.list();
	}
	
	public List<Trainee> getCandidateForRequirement(int requirementId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Trainee.class);
		if (requirementId > 0) {
			criteria.add(Restrictions.eq("reqirementId",requirementId));
		}
		return (List<Trainee>)criteria.list();
	}

}
