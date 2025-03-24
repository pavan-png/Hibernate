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
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session  = sessionFactory.openSession();
		
		Boolean falg = false;
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		employee.setEmpId(1); 
		session.delete(employee);
		falg = true;
		
		if(falg == true) {
			System.out.println("object deleted succesfully");
			transaction.commit();
		}else {
			System.out.println("object deletion failed");
			transaction.rollback();
		}
		session.close();
	
		
		
	}

}
