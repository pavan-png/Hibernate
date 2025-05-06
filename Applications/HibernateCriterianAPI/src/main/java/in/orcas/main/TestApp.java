package in.orcas.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.orcas.model.Project;


public class TestApp {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure();

	        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
	             Session session = sessionFactory.openSession()) {

	           Criteria criteria = session.createCriteria(Project.class);
	           List<Project> list = criteria.list();
	           list.forEach(System.out::println);
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}

