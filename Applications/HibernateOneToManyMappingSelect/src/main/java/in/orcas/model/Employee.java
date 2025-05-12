package in.orcas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_dev")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private float salary;
	private String eaddress;

	
	public Employee( String ename, float salary, String eaddress) {
		this.ename = ename;
		this.salary = salary;
		this.eaddress = eaddress;
	}

	public Employee( ) {
		System.out.println("internally used for object creation");
	}
	public Integer getEid() {
		return eid;
	}
	
	public String getEname() {
		return ename;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public String getEaddress() {
		return eaddress;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", eaddress=" + eaddress + "]";
	}
	
	
}
