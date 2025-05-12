package in.orcas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_new")
public class Course {
	
	@Id
	private String cid;
	private String cname;
	private Integer cost;
	
	public Course(String cid, String cname, Integer cost) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cost = cost;
	}
	
	public Course() {
		System.out.println("hibernate use this constructor");
	}
	
	public String getCid() {
		return cid;
	}
	public String getCname() {
		return cname;
	}
	public Integer getCost() {
		return cost;
	}
	
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cost=" + cost + "]";
	}
	
	
}
