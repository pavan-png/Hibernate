package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.BankAccount;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		BankAccount accountInfo = new  BankAccount();
		Boolean flag = false;
		accountInfo.setAccHolderName("pavan");
		accountInfo.setBalance(90000000.00);
		
		session.persist(accountInfo);
	    flag = true;
		
		if(flag == true) {
			transaction.commit();
			System.out.println("record is saved " +accountInfo);
		}
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
		}
	}

}
