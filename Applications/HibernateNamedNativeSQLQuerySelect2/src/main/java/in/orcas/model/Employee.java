package in.orcas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;




@Entity
@Table(name = "emp_new")
@NamedNativeQuery(name = "GET_ALL_EMP_DETAILS" , query = "SELECT * FROM emp_new",resultClass = Employee.class)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eno")
	private Integer eNo;
	
	@Column(name = "eaddr", length = 20)
	private String eAddr;

	@Column(name = "ename", length = 20)
	private String eName;

	
	@Column(name = "esal")
	private Integer eSalary;
	
	static {
		System.out.println(".class file is loaded");
	}
	
	public Employee() {
		System.out.println("employee object is instantiated");
	}
	
	public Integer geteNo() {
		System.out.println("geteNo getter called");
		return eNo;
	}
	public void seteNo(Integer eNo) {
		System.out.println("seteNo setter called");
		this.eNo = eNo;
	}
	public String geteName() {
		System.out.println("geteName getter called");
		return eName;
	}
	public void seteName(String eName) {
		System.out.println("seteName setter called");
		this.eName = eName;
	}
	public String geteAddr() {
		System.out.println("geteAddr getter called");
		return eAddr;
	}
	public void seteAddr(String eAddr) {
		System.out.println("seAddr setter called");
		this.eAddr = eAddr;
	}
	public Integer geteSalary() {
		System.out.println("geteSalary getter called");
		return eSalary;
	}
	public void seteSalary(Integer eSalary) {
		System.out.println("seteSalary setter called");
		this.eSalary = eSalary;
	}
	@Override
	public String toString() {
		return "Employee [eNo=" + eNo + ", eName=" + eName + ", eAddr=" + eAddr + ", eSalary=" + eSalary + "]";
	}
	
	

	
}
