package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		
		Configuration cfg  = new Configuration();
		
		cfg.configure();
		
		SessionFactory buildSessionFactory = 	cfg.buildSessionFactory();
	
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(7);
		employee.setEmpName("datta");
		employee.setEmpSal(100000.00);
		
		session.save(employee);
		
		transaction.commit();
		
		session.close();
		

	}

}
