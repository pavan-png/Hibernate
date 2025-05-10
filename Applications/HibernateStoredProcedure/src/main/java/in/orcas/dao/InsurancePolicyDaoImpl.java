package in.orcas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

import in.orcas.model.InsurancePolicy;
import jakarta.persistence.ParameterMode;

public class InsurancePolicyDaoImpl {
	public List<InsurancePolicy> getPoliciesByTenture(int start, int end){
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session  = buildSessionFactory.openSession();
		
		ProcedureCall procedurecall = session.createStoredProcedureCall("GET_POLICIES_BY_TENURE",InsurancePolicy.class);
		procedurecall.registerParameter(1, Integer.class, ParameterMode.IN).
	}
}
