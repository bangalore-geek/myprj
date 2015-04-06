package com.defysope.service;

import com.defysope.model.Role;

public interface RoleService {
	
	public Role getRole(int id);
	
	public Role getRole(String rolename);

}
