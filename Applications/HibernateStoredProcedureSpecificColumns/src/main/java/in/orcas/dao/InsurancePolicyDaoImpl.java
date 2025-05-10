package in.orcas.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

import in.orcas.model.InsurancePolicy;


public class InsurancePolicyDaoImpl implements InsurancePolicyDao{
	
	
	
	
	@Override
	public String[] getPoliciesById(int id) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		ProcedureCall procedureCall = session.createStoredProcedureCall("GET_POLICy_BY_ID",InsurancePolicy.class);
		/*
		 * CREATE OR REPLACE PROCEDURE GET_POLICY_BY_ID (
			    id     IN  NUMBER,
			    pName  OUT VARCHAR2,
			    cname  OUT VARCHAR2,
			    ptype  OUT VARCHAR2
			)
			AS
			BEGIN
			    SELECT policyname, companytype, policytype
			    INTO   pName, cname, ptype
			    FROM   insurancepolicy
			    WHERE  policyid = id;
			END;
			/

		 */
		
		
		
		procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id);
		procedureCall.registerParameter(2,String.class, ParameterMode.OUT);
		procedureCall.registerParameter(3, String.class, ParameterMode.OUT);
		procedureCall.registerParameter(4, String.class, ParameterMode.OUT);
	
		
		String policyName = (String) procedureCall.getOutputParameterValue(2);
		String companyName = (String) procedureCall.getOutputParameterValue(3);
		String policyType = (String) procedureCall.getOutputParameterValue(4);
	
	

	String[] result = {policyName,companyName,policyType};

	return result;
	}
}
