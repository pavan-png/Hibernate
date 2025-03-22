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
		int id = 5;
		Employee employee = null;
		employee = session.get(Employee.class, id);
		/*
		 * if we are fetching the record from db with get() then no need to create object for Employee class ( record type class )
		 * internally get() method creates the object and sets the data to the private variables using setter methods based on
		 * if the record is available with that primary key. 
		 */
		Boolean flag = null;
		
		if(employee != null) {
			/*
			 * later we are updating the data using that employee object created by get() method.
			 */
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
