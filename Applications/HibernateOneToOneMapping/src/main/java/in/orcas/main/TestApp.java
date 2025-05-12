package in.orcas.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Account;
import in.orcas.model.Employee;


public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
	
		Account account = new Account();
		account.setAccNo("K123");
		account.setAccName("pavan");
		account.setAccType("savings");
		
		Employee emp = new Employee();
		emp.setEname("pavan");
		emp.setEaddress("vijayawada");
		emp.setEsal(300000.30f);
		emp.setAccount(account);
		flag = true;
		
		
	
		if(flag==true) {
			System.out.println("record saved successfully");
			session.save(emp);
			transaction.commit();
		}
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
		}

	}

}
