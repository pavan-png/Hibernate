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
		
		Boolean flag = false;
		if(transaction!=null) {
			Employee employee = new Employee();
			employee.setEmpId(1);
			employee.setEmpName("pavan");
			employee.setEmpSal(1500000.00);
			
			Integer id = (Integer)session.save(employee);
			System.out.println("the id of the student is "+id);
			flag = true;
		}
		
		if(flag == true) {
			transaction.commit();
		}
		else {
			transaction.rollback();
		}
	}
}
