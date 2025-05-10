package in.orcas.main;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	        	// Step 1: Get the CriteriaBuilder from the Hibernate Session.
	        	// This is the starting point for building a criteria query using JPA Criteria API.
	        	CriteriaBuilder builder = session.getCriteriaBuilder();

	        	// Step 2: Create a CriteriaQuery object for the Project entity.
	        	// This means the query will return Project instances.
	        	CriteriaQuery<Project> cquery = builder.createQuery(Project.class);

	        	// Step 3: Define the FROM clause of the query using the Project entity.
	        	// The Root object represents the "root" entity/table in the query.
	        	Root<Project> root = cquery.from(Project.class);

	        	// (Optional but best practice) Set the SELECT clause to fetch the root entity (i.e., SELECT * FROM Project).
	        	cquery.select(root);

	        	// Step 4: Create a TypedQuery from the CriteriaQuery.
	        	// TypedQuery is the JPA-standard interface used for type-safe query execution.
	        	TypedQuery<Project> query = session.createQuery(cquery);

	        	// Step 5: Execute the query and get the list of Project objects from the database.
	        	List<Project> list = query.getResultList();

	        	// Step 6: Iterate through the result list and print each Project object to the console.
	        	list.forEach(System.out::println);
 
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}

