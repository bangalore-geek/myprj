package com.defysope.service;

import java.util.List;

import com.defysope.model.AddressDetails;
import com.defysope.model.Education;
import com.defysope.model.StudentDetails;
import com.defysope.model.University;
import com.defysope.model.User;
import com.defysope.model.UserReferences;
import com.defysope.model.WorkHistory;

public interface UserService {
	
	public User getUser(String login);

	public StudentDetails getStudentDetails(int userId);
	
	public List<Education> getEducationDetails(int userId);
	
	public List<AddressDetails> getAddressDetails(int userId);
	
	public List<WorkHistory> getWorkHistoryDetails(int userId);
	
	public List<UserReferences> getReferencesDetails(int userId);
	
	public List<University> getUniversity();
	
}
