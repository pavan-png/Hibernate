package in.orcas.main;

import java.util.HashSet;




import java.util.Set;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Course;
import in.orcas.model.Student;



public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
	
		Student student1 = session.get(Student.class, 1);
		Student student2 = session.get(Student.class, 2);
		Student student3 = session.get(Student.class, 3);
		
		if((student1 != null)&& (student2 != null)&&(student3 != null) ) {
			
			System.out.println("records are found");
			System.out.println(student1);
			System.out.println(student2);
			System.out.println(student3);
		}
	
		
		else {
			System.out.println("records not found");
			
		}

		session.close();
	}

}
