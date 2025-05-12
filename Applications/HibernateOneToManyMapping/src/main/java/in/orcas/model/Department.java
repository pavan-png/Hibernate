package in.orcas.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
	
	@Id
	private int deptId;
	private String deptName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employee> employee;
	

	

	public Department(int deptId, String deptName, Set<Employee> employee) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.employee = employee;
	}
	
	public Department() {
		System.out.println("internally used for object creation");
	}

	public int getDeptId() {
		return deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	

	public Set<Employee> getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employee=" + employee + "]";
	}
	
	
}
