package in.orcas.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_tab")
public class Employee{

	@Id
	@Column(name = "empid")
	private Integer empId;
	
	@Column(name = "empname")
	private String empName;

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
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}
	
}

