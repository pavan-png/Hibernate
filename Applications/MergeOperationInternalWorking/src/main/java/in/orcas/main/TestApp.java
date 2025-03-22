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
		
		Employee emp1 = null;
		Employee emp2 = null;
		Employee emp3 = null;
		Boolean flag = null;
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			int id =7;
			
			emp1 = session.get(Employee.class, id);
			
			emp2 = new Employee();
			emp2.setEmpId(7);
			emp2.setEmpName("Devadatta");
			emp2.setEmpSal(1000000.00);
			
			emp3 = session.merge(emp2);
			flag = true;
			
			System.out.println(emp1);
			System.out.println(emp2);
			System.out.println(emp3);
			System.out.println(emp1.hashCode()+" : "+emp2.hashCode()+" : " +emp3.hashCode());
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		if(flag ==true) {
			transaction.commit();
			System.out.println("object updated");
		}
		
		else {
			transaction.rollback();
			System.out.println("object updation failed");
		}
		
		
		
	}

}
