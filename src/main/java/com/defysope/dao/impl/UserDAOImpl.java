package com.defysope.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.defysope.dao.UserDAO;
import com.defysope.model.AddressDetails;
import com.defysope.model.OtherEducation;
import com.defysope.model.StudentDetails;
import com.defysope.model.User;
import com.defysope.model.WorkHistory;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from com.defysope.model.User u where u.userName = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}

	@Override
	public StudentDetails getStudentDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentDetails.class);
		criteria.add(Restrictions.eq("studentId", userId));
		return (StudentDetails) criteria.uniqueResult();
	}

	@Override
	public OtherEducation getEducationDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OtherEducation.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (OtherEducation) criteria.uniqueResult();
	}

	@Override
	public AddressDetails getAddressDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AddressDetails.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (AddressDetails) criteria.uniqueResult();
	}

	@Override
	public WorkHistory getWorkHistoryDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WorkHistory.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (WorkHistory) criteria.uniqueResult();
	}

}
