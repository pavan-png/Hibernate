package in.orcas.main;

import java.util.List;
import java.util.Optional;

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
		Query<Employee> query = session.createQuery(" FROM in.orcas.model.Employee WHERE eNo =: id",Employee.class);
		Integer id = 102;
		query.setParameter("id", id);
		Optional<Employee> optional = query.uniqueResultOptional();
		if(optional.isPresent()) {
			System.out.println("record is present ");
			Employee employee = optional.get();
			System.out.println(employee);
		}
		else {
			System.out.println("record not found");
		}
		session.close();
		buildSessionFactory.close();

	}

}
