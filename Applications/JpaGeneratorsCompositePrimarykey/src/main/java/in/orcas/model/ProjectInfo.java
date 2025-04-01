package in.orcas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectInfo {
	
	@Column(name = "pid")
	private Integer pid;
	
	@Column(name = "pgmid")
	private Integer pgmId;
	public ProjectInfo(Integer pid, Integer pgmId) {
		super();
		this.pid = pid;
		this.pgmId = pgmId;
	}
	public Integer getPid() {
		return pid;
	}
	
	public Integer getPgmId() {
		return pgmId;
	}
	
	@Override
	public String toString() {
		return "ProjectInfo [pid=" + pid + ", pgmId=" + pgmId + "]";
	}
	
	
	
}
