package com.defysope.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defysope.dao.UserDAO;
import com.defysope.model.ProductMaster;
import com.defysope.model.StudentDetails;
import com.defysope.model.University;
import com.defysope.model.User;
import com.defysope.model.UserReferences;
import com.defysope.model.skillset.AddressDetails;
import com.defysope.model.skillset.Education;
import com.defysope.model.skillset.WorkHistory;
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
	public List<Education> getEducationDetails(int userId) {
		return userDAO.getEducationDetails(userId);
	}

	@Override
	public List<AddressDetails> getAddressDetails(int userId) {
		return userDAO.getAddressDetails(userId);
	}

	@Override
	public List<WorkHistory> getWorkHistoryDetails(int userId) {
		return userDAO.getWorkHistoryDetails(userId);
	}

	@Override
	public List<UserReferences> getReferencesDetails(int userId) {
		return userDAO.getReferencesDetails(userId);
	}

	@Override
	public List<University> getUniversity() {
		return userDAO.getUniversity(); 
	}
	
	@Override
    public User saveUserInfo(User user, String role) {
        return userDAO.saveUserInfo(user, role);
    }

	@Override
	public boolean hasAccessRight(User user, String code) {
		 return userDAO.hasAccessRight(user.getId(), code);
	}

	@Override
	public List<ProductMaster> getProductList(int cmpId) {
		return userDAO.getProductList(cmpId);
	}
}
