package in.orcas.main;

import org.hibernate.HibernateException;
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
		
		Transaction transaction = session.beginTransaction();
		Employee employee = null;
		
		try {
			employee = session.get(Employee.class,1);
			employee.setEmpId(1);
			
			if(employee != null) {
				session.delete(employee);
				System.out.println("object deleted succesfully");
				transaction.commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("object deletion failed");
			transaction.rollback();
		}

		session.close();
	
		
	}

}
