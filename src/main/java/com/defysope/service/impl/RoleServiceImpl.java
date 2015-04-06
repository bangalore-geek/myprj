package com.defysope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defysope.dao.RoleDAO;
import com.defysope.model.Role;
import com.defysope.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

	@Override
	public Role getRole(String rolename) {
		return roleDAO.getRole(rolename);
	}

}
