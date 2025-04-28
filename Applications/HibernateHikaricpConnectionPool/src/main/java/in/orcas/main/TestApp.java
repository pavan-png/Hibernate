package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.orcas.model.InsurancePolicy;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		InsurancePolicy policy = null;
		if(session!=null) {
			policy  = session.get(InsurancePolicy.class, 1L);
			if(policy!=null) {
				
				System.out.println(policy);
			}
			else {
				System.out.println("record not available");
			}
			
		}
		
		

	}

}
