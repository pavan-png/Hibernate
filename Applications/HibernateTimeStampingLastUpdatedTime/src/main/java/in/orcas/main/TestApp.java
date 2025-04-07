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
		BankAccount info = null;
		Boolean flag = false;
		
		info = session.get(BankAccount.class, 1);
		if(info != null) {
			System.out.println("record available is "+info);
			info.setBalance(info.getBalance()+1000000.00);
			flag = true;
		}
		else {
			System.out.println("record not available");
		}
		
		if(flag == true) {
			transaction.commit();
			System.out.println("record updated successfully"+info);
		}
		else {
			System.out.println("record updation failed");
		}
		
		

	}

}
