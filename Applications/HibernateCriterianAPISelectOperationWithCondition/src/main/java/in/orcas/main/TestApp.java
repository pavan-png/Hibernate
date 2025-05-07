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
	           PropertyProjection p1 = Projections.property("teamSize");
	           PropertyProjection p2 = Projections.property("location");
	           PropertyProjection p3 = Projections.property("projName");
	           
	           ProjectionList plist = Projections.projectionList();
	           plist.add(p1);
	           plist.add(p2);
	           plist.add(p3);
	           
	           criteria.setProjection(plist);
	           
	           // Criterion class is not available so used Simple Expression
	           SimpleExpression con1 =  Restrictions.ge("teamSize",10);
	           SimpleExpression con2 = Restrictions.le("teamSize", 20);
	           
	           criteria.add(con1);
	           criteria.add(con2);
	           
	          Order order1 =  Order.asc("location");
	           Order order2 = Order.desc("projName");
	           criteria.addOrder(order1);
	           criteria.addOrder(order2);
	           
	           List<Object[]> list = criteria.list();
	           for(Object[] data : list) {
	        	   Integer teamSize = (Integer) data[0];
	        	   String location = (String) data[1];
	        	    String projName = (String) data[2];

	        	    System.out.println("Team Size: " + teamSize + ", Location: " + location + ", Project Name: " + projName);
	           }
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}

