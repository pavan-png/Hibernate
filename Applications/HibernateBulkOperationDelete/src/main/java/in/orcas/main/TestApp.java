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
		MutationQuery query =  session.createMutationQuery(
			    "UPDATE in.orcas.model.Employee  SET eSalary = eSalary+ :increment WHERE eNo > 102"
			);
		query.setParameter("increment", 10);
		int count = query.executeUpdate();
		flag = true;
		if(flag == true) {
			System.out.println(" no. of rows updated "+count);
			transaction.commit();
		}
		else {
			System.out.println("update operation failed");
			transaction.rollback();
		}
		session.close();
		buildSessionFactory.close();

	}

}
