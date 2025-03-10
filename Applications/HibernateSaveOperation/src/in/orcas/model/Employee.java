package in.orcas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_tab")
public class Employee {

	@Id
	@Column(name = "empid")
	private Integer empId;
	
	@Column(name = "empname")
	private String empName;
	
	@Column(name = "empsal")
	private Double empSal;
	
	static {
		System.out.println("Employee.class is loading");
	}
	
	public Employee() {
		System.out.println("zero parameter constructor is used by the constructor");
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	
	

}
