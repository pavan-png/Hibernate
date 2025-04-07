package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.MobileCustomer;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MobileCustomer info = null;
		boolean flag = false;
		
		if(transaction!=null) {
			info = session.get(MobileCustomer.class, 2);
			info.setMobileNumber(9642141964L);
			info.setOwnerName("pavan kalyan");
			flag = true;
		}
		else {
			System.out.println("record not available");
			flag = false;
		}
		
		if(flag ==true) {
			System.out.println("record updated successfully");
			transaction.commit();
		}
		else {
			System.out.println("record updation failed");
			transaction.rollback();
			session.clear();
		}

	}

}
