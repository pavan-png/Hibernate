package in.orcas.main;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.orcas.model.JobSeeker;

public class TestApp {

	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory buildSessionFactory = cfg.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		JobSeeker seeker = null;
		seeker = session.get(JobSeeker.class, 1);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Downloads\\output\\photo.jpg");
		fos.write(seeker.getPhoto());
		FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Downloads\\output\\result.txt");
		fw.write(seeker.getResume());
		System.out.println(seeker);
		fos.flush();
		fw.flush();
		fos.close();
		fw.close();
		session.close();
	}

}
