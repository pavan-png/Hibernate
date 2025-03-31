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
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = null;
		boolean flag = false;
		
		if(transaction!=null) {
			employee = new Employee();
			employee.setEmpName("pavan");
			employee.setEmpSal(2000000.00);
			flag = true;
		}
		
		if(flag == true ) {
			System.out.println("record inserted successfully ");
			session.save(employee);
			transaction.commit();
		}
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
		}

	}

}
