package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.InsurancePolicy;

public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		InsurancePolicy policy = null;
		policy = (InsurancePolicy) session.get(InsurancePolicy.class, 1L);
		System.out.println(policy);
		session.evict(policy);
		policy = (InsurancePolicy) session.get(InsurancePolicy.class, 1L);
		System.out.println(policy);
		session.clear();
		Thread.sleep(20000);
		policy = (InsurancePolicy) session.get(InsurancePolicy.class, 1L);
		System.out.println(policy);
		session.close();
		
	}

}
