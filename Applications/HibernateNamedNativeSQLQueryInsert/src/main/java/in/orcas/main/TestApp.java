package in.orcas.main;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.orcas.model.Employee;

import java.util.List;

public class TestApp {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        boolean flag = false;

        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
        	 Transaction transaction = session.beginTransaction();
            // while working with namedquery work only with previous versions
        	// try to avoid the latest versions of orm it is creating a lot of mess
        	NativeQuery<Employee> nativeQuery = session.getNamedNativeQuery("INSERT_NEW_EMP");
        	nativeQuery.setParameter(1, 106);
        	nativeQuery.setParameter(2, "ben");
        	nativeQuery.setParameter(3, "moscow");
        	nativeQuery.setParameter(4,500);
        	int count = nativeQuery.executeUpdate();
        	flag = true;
        	if(flag == true) {
        		System.out.println("record updated successfully");
        		transaction.commit();
        		
        	}
        	else {
        		System.out.println("record updation failed");
        		transaction.rollback();
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}