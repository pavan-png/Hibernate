package in.orcas.main;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Account;
import in.orcas.model.Employee;


public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Employee emp = session.get(Employee.class, 1);
	
		if(emp!=null) {
			System.out.println("record is found");
			System.out.println(emp);
			
		}
		else {
			System.out.println("record not found");
			
		}

	}

}
