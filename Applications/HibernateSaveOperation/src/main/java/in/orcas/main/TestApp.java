package in.orcas.main;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		
		// step-1 create the configuration object 
		Configuration cfg  = new Configuration();
		
		// step-2 configure hibernate.cfg.xml file to configuration object 
		cfg.configure();
		
		//step -3 Create the session factory object
		SessionFactory buildSessionFactory = 	cfg.buildSessionFactory();
	
		//step - 4 get the session object from the SessionFactory
		Session session = buildSessionFactory.openSession();
		
		// step-5 begin the transaction with the session
		Transaction transaction = session.beginTransaction();
		// internally connection.setAutoCommit(false)
		
		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("pavankumar");
		employee.setEmpSal(100000.00);
		
		// step-6 perform the operations
		 Integer id = (Integer) session.save(employee);
		
		
		//step-7 performing transaction operations 
		transaction.commit();
		
		//step-8 close the session
		session.close();
		

	}

}
