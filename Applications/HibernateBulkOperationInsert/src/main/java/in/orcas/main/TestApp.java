package in.orcas.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import in.orcas.model.Employee;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		// you can use createQuery() for 5.2 - 5.6 but marked for removal
		MutationQuery query = session.createMutationQuery("INSERT INTO in.orcas.model.HighPayEmployee (eNo,eAddr,eName,eSalary) SELECT eNo,eAddr,eName,eSalary FROM in.orcas.model.Employee WHERE eSalary >= : sal");
		query.setParameter("sal",40000);
		int count = query.executeUpdate();
		flag = true;
		
		if(flag == true) {
			System.out.println("operation successful");
			transaction.commit();
		}
		else {
			System.out.println("operation failed");
			transaction.rollback();
		}
		session.close();
		buildSessionFactory.close();

	}

}
