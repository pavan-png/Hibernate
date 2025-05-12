package in.orcas.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "std_new")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Course> courses;

	public Student(String sname, String address, Set<Course> courses) {
		
		this.sname = sname;
		this.address = address;
		this.courses = courses;
	}
	
	public Student() {
		System.out.println("default constructor called");
	}

	public Integer getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getAddress() {
		return address;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + ", courses=" + courses + "]";
	}
	
	
	
}
