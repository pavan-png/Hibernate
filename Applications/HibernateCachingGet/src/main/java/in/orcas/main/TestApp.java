package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.InsurancePolicy;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		InsurancePolicy policy = null;
		Boolean flag = false;
		policy = session.get(InsurancePolicy.class, 1);
		if( policy != null) {
			System.out.println(policy);
			policy.setTenure(2);
			policy.setTenure(3);
			flag = true;
		}
		else {
			System.out.println("record not found");
		}
		if(flag == true) {
			transaction.commit();
		}
		else {
			transaction.rollback();
			session.close();
		}
			

	}

}
