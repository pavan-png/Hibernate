package in.orcas.main;

import java.util.HashSet;



import java.util.Set;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Course;
import in.orcas.model.Student;



public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Course c1 = new Course("J01","javafullstack",20000);
		Course c2 = new Course("P02","DataScience",20000);
		Course c3 = new Course("A03","Ai",20000);
		
		Set<Course> course = new HashSet<Course>();
		course.add(c1);
		course.add(c2);
		course.add(c3);
		
		Set<Course> course1 = new HashSet<Course>();
		course1.add(c2);
		course1.add(c3);
		
		Set<Course> course2 = new HashSet<Course>();
		course2.add(c3);
		
		Student std = new Student("pavan","vijayawada",course);
		Student std1 = new Student("Devadatta","vijayawada",course1);
		Student std2 = new Student("Anand","vijayawada",course2);
		
		
		if((std!=null)&&(std1!=null)&&(std2!=null)) {	
			session.save(std);
			System.out.println(std);
			System.out.println();
			session.save(std1);
			System.out.println(std1);
			System.out.println();
			
			
			session.save(std2);
			System.out.println(std2);
			System.out.println();
			transaction.commit();
			
			System.out.println("records saved successfully");
		}
		
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
		}

		session.close();
	}

}
