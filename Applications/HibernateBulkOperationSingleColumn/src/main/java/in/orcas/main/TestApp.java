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
		Query<String> query = session.createQuery(" SELECT eName FROM in.orcas.model.Employee WHERE eNo >=: id",String.class);
		Integer id = 102;
		query.setParameter("id", id);
		List<String> list = query.getResultList();
		list.forEach(System.out::println);
		
		session.close();
		buildSessionFactory.close();

	}

}
