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
		Query<Object[]> query = session.createQuery("SELECT eName , eSalary FROM in.orcas.model.Employee WHERE eNo >=: id",Object[].class);
		Integer id = 102;
		query.setParameter("id", id);
		List<Object[]> list = query.getResultList();
		for(Object[] row : list) {
			System.out.println(row[0]);
			System.out.println(row[1]);
		}
		
		session.close();
		buildSessionFactory.close();

	}

}
