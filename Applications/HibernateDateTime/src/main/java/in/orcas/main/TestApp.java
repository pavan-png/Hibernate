package in.orcas.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.PersonalInfo;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		PersonalInfo pInfo = new PersonalInfo();
		pInfo.setName("pavan");
		pInfo.setAddress("vijayawada");
		pInfo.setDob(LocalDate.of(1999,06, 20));
		pInfo.setDoj(LocalTime.of(10, 30));
		pInfo.setDom(LocalDateTime.of(2027, 01, 01, 10, 30));
		
		if(transaction!= null) {
			Integer id = (Integer) session.save(pInfo);
			transaction.commit();
			System.out.println("record saved successfully "+id);
		}
		else {
			transaction.rollback();
			System.out.println("record insertion failed");
		}
		
		

	}
}
