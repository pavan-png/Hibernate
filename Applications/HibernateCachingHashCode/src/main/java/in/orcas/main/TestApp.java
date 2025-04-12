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
		InsurancePolicy policy1 = null;
		InsurancePolicy policy2 = null;
		Boolean flag = false;
		policy1 = session.get(InsurancePolicy.class, 1);
		policy2 = session.get(InsurancePolicy.class, 1);
		System.out.println("policy1 hashcode" +policy1.hashCode());
		System.out.println("policy1 hashcode" +policy1.hashCode());
		
		
	}

}
