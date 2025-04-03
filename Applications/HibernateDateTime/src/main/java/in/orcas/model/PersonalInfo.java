package in.orcas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class PersonalInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer pid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "dom")
	private LocalDateTime dom;
	
	@Column(name = "doj")
	private LocalTime Doj;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getDom() {
		return dom;
	}

	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}

	public LocalTime getDoj() {
		return Doj;
	}

	public void setDoj(LocalTime doj) {
		Doj = doj;
	}
	
	
}
