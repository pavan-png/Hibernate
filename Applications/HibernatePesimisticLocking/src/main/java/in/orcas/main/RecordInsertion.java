package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.InsurancePolicy;

public class RecordInsertion {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		
		InsurancePolicy policy = new InsurancePolicy();
		policy.setPolicyName("jeevanAnand");
		policy.setPolicyType("Savings");
		policy.setCompany("LIC");
		policy.setTenure(2);
		
		
		flag = true;
		
		if(flag==true) {
			session.save(policy);
			System.out.println("record inserted succesfully");
			transaction.commit();
		}
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
		}
	}

}
