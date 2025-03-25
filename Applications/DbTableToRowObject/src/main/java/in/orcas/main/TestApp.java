package in.orcas.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Employee employee = null;
		Boolean flag = false;
		
		employee = session.get(Employee.class,2);
		if(employee != null) {
			System.out.println("before modification" +employee);
			System.in.read();
			session.refresh(employee);
			System.out.println("after modification" +employee);
			
		}
		else {
			System.out.println("record not available ");
		}
		
	}

}
