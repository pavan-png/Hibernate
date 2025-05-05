package in.orcas.main;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.orcas.model.Employee;

import java.util.List;

public class TestApp {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // while working with namedquery work only with previous versions
        	// try to avoid the latest versions of orm it is creating a lot of mess
        	NativeQuery<Employee> nativeQuery = session.getNamedNativeQuery("GET_ALL_EMP_DETAILS");
        	List<Employee> results = nativeQuery.getResultList();
        	results.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}