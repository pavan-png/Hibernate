package in.orcas.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.dao.InsurancePolicyDao;
import in.orcas.dao.InsurancePolicyDaoImpl;
import in.orcas.model.InsurancePolicy;

public class TestApp {

	public static void main(String[] args) {
		
		InsurancePolicyDao policy = null;
		policy = new InsurancePolicyDaoImpl();
		List<InsurancePolicy>list =  policy.getPoliciesByTenure(1, 5);
		list.forEach(System.out::println);
		
	}

}
