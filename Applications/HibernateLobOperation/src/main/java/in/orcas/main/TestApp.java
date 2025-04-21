package in.orcas.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.orcas.model.JobSeeker;

public class TestApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		Transaction transaction = null;
		byte[] imageContent = null;
		char[] resumeContent = null;
		JobSeeker seeker = new JobSeeker();
		try(FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\Ben 10 _Alien X  _Wallpaper.jpg")){
			imageContent = new byte[(int) fis.available()];
			fis.read(imageContent);
			File f = new File("C:\\Users\\Administrator\\Downloads\\errors.txt");
			try(FileReader fr = new FileReader(f)){
				resumeContent = new char[(int) f.length()];
				fr.read(resumeContent);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		seeker.setActive(true);
		seeker.setJsName("pavan");
		seeker.setPhoto(imageContent);
		seeker.setResume(resumeContent);
		session.persist(seeker);
		if(session!=null) {
			transaction = session.beginTransaction();
		}
		if(transaction!=null) {
			transaction.commit();
			System.out.println("record saved successfully");
		}
		else {
			transaction.rollback();
			System.out.println("record insertion failed");
		}
		session.close();
		
 	}

}
