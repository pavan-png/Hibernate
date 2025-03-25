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
		Employee employee = null;
		Boolean flag = false;
		
		employee = session.get(Employee.class,3);
		if(employee != null) {
			employee.setEmpSal(1500000.00);
			flag = true;
		}
		else {
			System.out.println("record not available ");
		}
		if(flag ==true) {
			transaction.commit();
		}
		else {
			transaction.rollback();
		}
	}

}
