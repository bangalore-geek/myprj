package com.defysope.dao;

import java.util.List;

import com.defysope.model.ProductMaster;
import com.defysope.model.StudentDetails;
import com.defysope.model.University;
import com.defysope.model.User;
import com.defysope.model.UserReferences;
import com.defysope.model.skillset.AddressDetails;
import com.defysope.model.skillset.Education;
import com.defysope.model.skillset.WorkHistory;

public interface UserDAO {

	public User getUser(String login);

	public StudentDetails getStudentDetails(int userId);
	
	public List<Education> getEducationDetails(int userId);
	
	public List<AddressDetails> getAddressDetails(int userId);
	
	public List<WorkHistory> getWorkHistoryDetails(int userId);

	public List<UserReferences> getReferencesDetails(int userId);

	public List<University> getUniversity();
	
	public User saveUserInfo(User user, String role);

	public boolean hasAccessRight(int id, String code);

	public List<ProductMaster> getProductList(int userId);
}
