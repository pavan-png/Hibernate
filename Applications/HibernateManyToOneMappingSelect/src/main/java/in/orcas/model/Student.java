package in.orcas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_new1")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Branch branch;
	
	public Student(String sname, String address, Branch branch) {
		super();
		this.sname = sname;
		this.address = address;
		this.branch = branch;
	}

	
	 public Student() {
		System.out.println("used by hibernate during deserialization ");
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

	public Branch getBranch() {
		return branch;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + ", branch=" + branch + "]";
	}
	
	

}
