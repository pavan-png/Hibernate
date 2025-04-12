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
		
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("1:: "+policy);
		
		policy = session.get(InsurancePolicy.class,1);
		System.out.println("2:: "+policy);
		
		session.evict(policy);

		policy = session.get(InsurancePolicy.class,1);
		System.out.println("2:: "+policy);
	}

}
