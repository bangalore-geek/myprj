package com.defysope.service;

import java.util.List;

import com.defysope.model.kv.Candidate;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Requirement;

public interface RequirementService {
	public List<Requirement> getRequirementForCompany(int companyId);
	public List<Trainee> getCandidateForRequirement(int requirementId);
	public Candidate getCandidateByUserId(int userId);
}
