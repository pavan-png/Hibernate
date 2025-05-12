package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.InsurancePolicy;

public class TestApp2 {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		InsurancePolicy policy = session.get(InsurancePolicy.class, 1L);
		System.out.println(policy);
		flag = true;
		policy.setTenure(18);
		if(flag==true) {
			session.save(policy);
			System.out.println("record updated successfully");
			transaction.commit();
		}
		else {
			System.out.println("record updation failed");
			transaction.rollback();
		}

	}

}
