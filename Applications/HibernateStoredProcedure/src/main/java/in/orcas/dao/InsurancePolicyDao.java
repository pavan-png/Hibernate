package in.orcas.dao;

import java.util.List;

import in.orcas.model.InsurancePolicy;

public interface InsurancePolicyDao {

	public List<InsurancePolicy> getPoliciesByTenure(int start, int end);

}

