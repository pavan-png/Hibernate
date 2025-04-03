package in.orcas.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.ProgrammerProjectInfo;
import in.orcas.model.ProjectInfo;

public class TestApp {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		ProjectInfo info = new ProjectInfo(1,101);
		
		ProgrammerProjectInfo pgmInfo = new ProgrammerProjectInfo("pavan",01,"java",info);
		Boolean flag = false;
		
		ProjectInfo id = null;
		if(transaction!=null) {
			id = (ProjectInfo)session.save(pgmInfo);
			flag = true;
		}
		
		if(flag == true) {
			transaction.commit();
			System.out.println("record inserted successfully"+id);
		}
		else {
			System.out.println("record insertion failed");
			transaction.rollback();
			
		}
	}

}
