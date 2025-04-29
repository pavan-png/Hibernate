package in.orcas.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_new")
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
	
	public Integer geteNo() {
		return eNo;
	}
	public void seteNo(Integer eNo) {
		this.eNo = eNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAddr() {
		return eAddr;
	}
	public void seteAddr(String eAddr) {
		this.eAddr = eAddr;
	}
	public Integer geteSalary() {
		return eSalary;
	}
	public void seteSalary(Integer eSalary) {
		this.eSalary = eSalary;
	}
	@Override
	public String toString() {
		return "Employee [eNo=" + eNo + ", eName=" + eName + ", eAddr=" + eAddr + ", eSalary=" + eSalary + "]";
	}
	
	

	
}
