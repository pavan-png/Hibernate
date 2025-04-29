package in.orcas.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		
		Session session = buildSessionFactory.openSession();
		Query<Employee> query=  session.createQuery("From Employee", in.orcas.model.Employee.class);
		List<Employee> list = query.list();
		list.forEach(System.out::println);
		session.close();
		buildSessionFactory.close();

	}

}
