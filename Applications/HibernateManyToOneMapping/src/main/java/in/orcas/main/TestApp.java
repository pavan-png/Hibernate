package in.orcas.main;

import java.util.HashSet;


import java.util.Set;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Branch;
import in.orcas.model.Student;


public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Branch branch = new Branch();
		branch.setBname("cs");
		branch.setBid("B01");
		branch.setBlocation("vijayawada");
		
		Student student = new Student("pavan","Vijayawada",branch);
		System.out.println(student);
		
		Student student1 = new Student("pavan","Vijayawada",branch);
		System.out.println(student1);
		
		Student student2 = new Student("pavan","Vijayawada",branch);
		System.out.println(student2);
			
		
		if((student!= null)&& (student1!= null) && (student2!= null)) {	
			session.save(student);
			System.out.println(student);
			System.out.println();
			
			session.save(student1);
			System.out.println(student1);
			System.out.println();

			session.save(student2);
			System.out.println(student2);
			System.out.println();

			
			System.out.println("record inserted sucess");
		
		}
		else {
			System.out.println("record insertion failed");
			
		}

		session.close();
	}

}
