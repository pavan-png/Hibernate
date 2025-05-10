package in.orcas.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

import in.orcas.model.InsurancePolicy;


public class InsurancePolicyDaoImpl implements InsurancePolicyDao{
	
	/*
	 * CREATE OR REPLACE PROCEDURE GET_POLICIES_BY_TENURE (
tenure1 IN NUMBER,
tenure2 IN NUMBER,
result OUT SYS_REFCURSOR

)
AS
BEGIN
OPEN result FOR
SELECT policyid, companytype, policyname, policytype, tenure
FROM insurancepolicy
WHERE tenure >= tenurel AND tenure <= tenure2;
END;
/
	 */
	
	
	@Override
	public List<InsurancePolicy> getPoliciesByTenure(int start, int end) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();

	ProcedureCall procedureCall = session.createStoredProcedureCall("GET_POLICIES_BY_TENURE",
	InsurancePolicy.class);

	procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(start);
	procedureCall.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(end);
	/*
	 * ❌ Why You Usually Need REF_CURSOR:
	 * Without it, the procedure won’t return data to Java — Oracle procedures can’t return result sets 
       directly unless they use a REF_CURSOR.
	 */
	procedureCall.registerParameter(3, void.class, ParameterMode.REF_CURSOR);  // This was missing

	List<InsurancePolicy> list = procedureCall.getResultList();

	return list;
	}
}
