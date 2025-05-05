package in.orcas.main;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class TestApp {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // while working with namedquery work only with previous versions
        	// try to avoid the latest versions of orm it is creating a lot of mess
        	NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("Native_SQL_Query");
        	nativeQuery.setParameter("id", 104);
        	List<Object[]> results = nativeQuery.getResultList();

            for (Object[] row : results) {
                System.out.println("ENO: " + row[0] + ", ENAME: " + row[1] + ", EADDR: " + row[2]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}