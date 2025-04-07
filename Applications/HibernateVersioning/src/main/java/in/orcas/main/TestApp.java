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
		MobileCustomer info = new MobileCustomer();
		boolean flag = false;
		Integer id = null;
		if(transaction!=null) {
			
			info.setOwnerName("pavan");
			info.setMobileNumber(9398821180L);
			id  = (Integer) session.save(info);
			flag = true;
		}
		if(flag == true) {
			System.out.println("record inserted successfully " +id);
			transaction.commit();
		}
		else{
			System.out.println("record insertion failed");
			transaction.rollback();
			session.close();
		}
		
		
	}

}
