package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import in.orcas.model.Employee;

public class TestApp {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            
            Transaction transaction = session.beginTransaction();
            boolean flag = false;

            // New way to get named mutation query in Hibernate 6+
            MutationQuery query = session.createNamedMutationQuery("Named_HQL_Query");
            query.setParameter("sal", 40000);
            int count = query.executeUpdate();
            flag = true;

            if (flag) {
                System.out.println(count + " records updated successfully");
                transaction.commit();
            } else {
                System.out.println("Operation failed");
                transaction.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}