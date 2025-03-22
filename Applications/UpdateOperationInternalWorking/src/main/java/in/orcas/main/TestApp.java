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
		int id = 1;
		Employee employee = null;
		employee = session.get(Employee.class, id);
		Boolean flag = null;
		
		if(employee != null) {
			employee.setEmpName("pavan");
			employee.setEmpSal(500000.00);
			session.update(employee);
			flag = true;
		}
		if(flag==true) {
			transaction.commit();
			System.out.println("object updated");
		}
		else {
			transaction.rollback();
			System.out.println("object updation failed ");
		}

	}

}
