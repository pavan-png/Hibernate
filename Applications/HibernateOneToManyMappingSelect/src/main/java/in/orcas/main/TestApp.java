package in.orcas.main;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Department;
import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Department dept = null;
		
		dept = session.get(Department.class, 1);
		
			
		if(dept!=null) {	
			System.out.println("record is found");
			System.out.println(dept);
		}
		else {
			System.out.println("record not found");
			
		}

		session.close();
	}

}
