package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory =cfg.buildSessionFactory();
		
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		int id = 10;
		Employee employee = session.load(Employee.class,  id);
		
		System.out.println(employee);
		Boolean flag = null; 
		if(employee!=null) {
		session.delete(employee);
		
		 flag = true; 
		}
		
		if (flag == true) {
			System.out.println("sucessfully deleted the record");
		}
		else {
			System.out.println("record not found");
		}
		
		transaction.commit();
		
		session.close();

	}

}
