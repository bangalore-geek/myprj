package com.defysope.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.defysope.dao.UserDAO;
import com.defysope.model.AddressDetails;
import com.defysope.model.Education;
import com.defysope.model.StudentDetails;
import com.defysope.model.University;
import com.defysope.model.User;
import com.defysope.model.UserReferences;
import com.defysope.model.WorkHistory;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	public List<Education> getEducationDetails(int userId) {
		System.out.println("Education >>>>>>>>");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Education.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (List<Education>) criteria.list();
	}

	@Override
	public List<AddressDetails> getAddressDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AddressDetails.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (List<AddressDetails>) criteria.list();
	}

	@Override
	public List<WorkHistory> getWorkHistoryDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WorkHistory.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (List<WorkHistory>) criteria.list();
	}

	@Override
	public List<UserReferences> getReferencesDetails(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserReferences.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (List<UserReferences>) criteria.list();
	}

	@Override
	public List<University> getUniversity() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(University.class);
		return (List<University>) criteria.list();
	}
	
	
	public User saveUserInfo(User user) {
        sessionFactory.getCurrentSession().flush();
        jdbcTemplate.execute("insert into tbl_user_roles(userid,roleid) values("+user.getId()+",(select cid from tblrole where name ='student'))");
        return user;
    }
}
