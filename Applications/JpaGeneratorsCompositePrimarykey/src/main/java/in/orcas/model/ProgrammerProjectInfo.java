package in.orcas.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ProgrammerProjectInfo {
	
	@Column(name = "programmername")
	private String programmerName;
	
	@Column(name = "deptno")
	private Integer deptNo;
	
	@Column(name = "projectname")
	private String projectName;
	
	@EmbeddedId
	private ProjectInfo projectInfo;
	public String getProgrammerName() {
		return programmerName;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	
	public ProgrammerProjectInfo(String programmerName, Integer deptNo, String projectName, ProjectInfo projectInfo) {
		super();
		this.programmerName = programmerName;
		this.deptNo = deptNo;
		this.projectName = projectName;
		this.projectInfo = projectInfo;
	}
	@Override
	public String toString() {
		return "ProgrammerProjectInfo [programmerName=" + programmerName + ", deptNo=" + deptNo + ", projectName="
				+ projectName + ", projectInfo=" + projectInfo + "]";
	}
	
	
	
	
}
