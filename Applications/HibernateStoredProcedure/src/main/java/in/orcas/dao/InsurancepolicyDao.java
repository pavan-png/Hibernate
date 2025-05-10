package in.orcas.dao;

import java.util.List;

import in.orcas.model.InsurancePolicy;

public interface InsurancepolicyDao {

	public List<InsurancePolicy> getPoliciesByTenture(int start, int end);
}

