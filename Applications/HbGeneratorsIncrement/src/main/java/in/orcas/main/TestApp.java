package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg =  new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		Boolean flag = false;
		if(transaction!=null) {
			employee.setEmpName("devadatta");
			employee.setEmpSal(1500000.00);
			flag = true;
		}
		if(flag == true) {
			session.save(employee);
			transaction.commit();
		}
		else {
			transaction.rollback();
		}
	}

}
