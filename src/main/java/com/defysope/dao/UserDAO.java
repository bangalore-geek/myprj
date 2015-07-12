package com.defysope.dao;

import com.defysope.model.AddressDetails;
import com.defysope.model.OtherEducation;
import com.defysope.model.StudentDetails;
import com.defysope.model.User;
import com.defysope.model.WorkHistory;

public interface UserDAO {

	public User getUser(String login);

	public StudentDetails getStudentDetails(int userId);
	
	public OtherEducation getEducationDetails(int userId);
	
	public AddressDetails getAddressDetails(int userId);
	
	public WorkHistory getWorkHistoryDetails(int userId);
	

}
