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
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		boolean flag  = false;
		Employee employee = null;
		if(transaction!=null) {
			employee = new Employee();
			employee.setEmpName("pavan");
			employee.setEmpSal(200000.00);
			flag = true;
		}
		if(flag ==true) {
			 
			session.save(employee);
			transaction.commit();
		}
		else {
			transaction.rollback();
		}
	}

}
