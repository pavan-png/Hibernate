package in.orcas.model;

public class ProjectInfo {
	private Integer pid;
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
