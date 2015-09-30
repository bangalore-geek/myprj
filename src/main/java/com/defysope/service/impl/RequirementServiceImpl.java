package com.defysope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defysope.dao.kv.RequirementDao;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Requirement;
import com.defysope.service.RequirementService;

@Service
@Transactional
public class RequirementServiceImpl implements RequirementService {

	@Autowired
	RequirementDao requirementDao; 
	
	public List<Requirement> getRequirementForCompany(int companyId) {
		return requirementDao.getRequirementForCompany(companyId);
	}
	
    public List<Trainee> getCandidateForRequirement(int requirementId) {
    	return requirementDao.getCandidateForRequirement(requirementId);
    }
}
