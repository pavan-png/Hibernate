package in.orcas.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import in.orcas.model.Project;


public class TestApp {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure();

	        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
	             Session session = sessionFactory.openSession()) {

	           Criteria criteria = session.createCriteria(Project.class);
	           criteria.setFirstResult(1);
	           criteria.setMaxResults(3);
	           List<Project> list = criteria.list();
	           list.forEach(System.out::println);
	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}

