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
		InsurancePolicy policy = new InsurancePolicy();
		Boolean flag = false;
		
		if(transaction != null) {
			policy.setCompany("sbi");
			policy.setPolicyName("kalala sonthaillu");
			policy.setPolicyType("quarter");
			policy.setTenure(1);
			flag = true;
		}
		
		if(flag == true) {
			session.persist(policy);
			transaction.commit();
			System.out.println("record saved successfully");
		}
		else {
			transaction.rollback();
			System.out.println("record insertion failed");
			session.close();
		}
		
		

	}

}
