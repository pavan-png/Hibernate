package in.orcas.main;

import java.util.HashSet;



import java.util.Set;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Branch;
import in.orcas.model.Student;


public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Student student = session.get(Student.class, 1);
		
		if(student!=null) {
			System.out.println("record found");
			System.out.println(student);
		}
		else {
			System.out.println("record not found");
			
		}

		session.close();
	}

}
