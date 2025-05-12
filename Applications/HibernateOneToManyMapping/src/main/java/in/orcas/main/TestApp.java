package in.orcas.main;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Department;
import in.orcas.model.Employee;




public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
	
		Employee emp = new Employee("pavan",300000.00f,"vijayawada");
		Employee emp1 = new Employee("datta",300000.00f,"vijayawada");
		Employee emp2 = new Employee("srinivas",300000.00f,"vijayawada");
		
		Set<Employee> set = new HashSet<Employee>();
		set.add(emp);
		set.add(emp1);
		set.add(emp2);
		Department dept = new Department(1,"AI",set);
			session.save(dept);
			flag = true;
		if(flag == true) {
			transaction.commit();
			System.out.println("record saved successfully");
		}
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
		}

	}

}
