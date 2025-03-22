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
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = null;
		
		Employee employee = new Employee();
		employee.setEmpId(5);
		employee.setEmpName("pavan");
		employee.setEmpSal(1000000.00);
		Boolean flag = false;
		
		
		
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(employee);
			flag = true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("sarigga chusi chey bey anni butuley rasav");
			
		}
		if(flag ==true) {
			transaction.commit();
			System.out.println("object saved successfully");
		}
		else {
			transaction.rollback();
			System.out.println("object failed to updated");
		}
		
	}

}
