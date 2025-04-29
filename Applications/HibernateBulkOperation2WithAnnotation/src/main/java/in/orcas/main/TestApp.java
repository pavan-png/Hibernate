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
		Query<Employee> query=  session.createQuery("From Employee WHERE eNo>=:id1 AND eNo<=:id2", in.orcas.model.Employee.class);
		query.setParameter("id1",101);
		query.setParameter("id2", 105);
		List<Employee> list = query.getResultList();
		list.forEach(System.out::println);
		session.close();
		buildSessionFactory.close();

	}

}
