package com.defysope.dao.kv;

import java.util.List;

import com.defysope.model.kv.Requirement;
import com.defysope.model.kv.Trainee;

public interface RequirementDao {

	public List<Requirement> getRequirementForCompany(int companyId);
	public List<Trainee> getCandidateForRequirement(int requirementId);

}
