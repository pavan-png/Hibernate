package in.orcas.model;

import java.io.Serializable;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobseeker")
public class JobSeeker implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "jsname")
	private String jsName;
	
	@Lob
	@Column(name = "photo")
	private byte [] photo;
	
	@Lob
	@Column(name = "resume")
	private char[] resume;
	
	@Column(name = "active")
	private boolean active;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", jsName=" + jsName + ", photo=" + Arrays.toString(photo) + ", resume="
				+ Arrays.toString(resume) + ", active=" + active + "]";
	}
	
	
}
