package in.orcas.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer eNo;
	private String eAddr;
	private String eName;
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
