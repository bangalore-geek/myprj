package com.defysope.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defysope.dao.UserDAO;
import com.defysope.model.AddressDetails;
import com.defysope.model.OtherEducation;
import com.defysope.model.StudentDetails;
import com.defysope.model.User;
import com.defysope.model.WorkHistory;
import com.defysope.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User getUser(String login) {
		return userDAO.getUser(login);
	}

	@Override
	public StudentDetails getStudentDetails(int userId) {
		return userDAO.getStudentDetails(userId);
	}

	@Override
	public OtherEducation getEducationDetails(int userId) {
		return userDAO.getEducationDetails(userId);
	}

	@Override
	public AddressDetails getAddressDetails(int userId) {
		return userDAO.getAddressDetails(userId);
	}

	@Override
	public WorkHistory getWorkHistoryDetails(int userId) {
		return userDAO.getWorkHistoryDetails(userId);
	}

}
