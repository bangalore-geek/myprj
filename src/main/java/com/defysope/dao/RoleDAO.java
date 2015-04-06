package com.defysope.dao;

import com.defysope.model.Role;

public interface RoleDAO {
	
	public Role getRole(int id);

	public Role getRole(String rolename);

}
