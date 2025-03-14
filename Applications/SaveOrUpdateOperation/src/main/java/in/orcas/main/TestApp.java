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
		
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(2);
		employee.setEmpName("pavan");
		employee.setEmpSal(300000.00);
		
		session.saveOrUpdate(employee);
		
		transaction.commit();
		
		session.close();
	
		
		
		

	}

}
