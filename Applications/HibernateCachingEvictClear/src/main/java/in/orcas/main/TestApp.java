package in.orcas.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.InsurancePolicy;

public class TestApp {

	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		InsurancePolicy policy = null;
		Boolean flag = false;
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("1 : " +policy);
		System.in.read();
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("2 : "+policy);
		System.out.println("==============================================================");
		System.in.read();
		session.evict(policy);
		
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("3 : "+policy);
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("4 : "+policy);
		System.out.println("=============================================================");
		System.in.read();
		session.clear();
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("5 : "+policy);
		policy = session.get(InsurancePolicy.class, 1);
		System.out.println("6 : "+policy);
		
		}

	}


