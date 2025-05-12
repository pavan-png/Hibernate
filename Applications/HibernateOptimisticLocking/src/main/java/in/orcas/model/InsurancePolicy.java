package in.orcas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;




@Entity
@Table (name = "ins_policy")
public class InsurancePolicy implements Serializable{
	
	private static final Long serialVersionUID  = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policyid")
	private Long policyId;
	
	@Column(name = "policyname" , length = 20)
	private String policyName;
	
	@Column(name = "policytype" , length = 20)
	private String policyType;
	
	@Column(name = "companytype" , length = 20)
	private String company;
	
	@Column(name = "tenure")
	private Integer tenure;
	
	@Version
	private Integer updateValue;
	
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
		
	}
	
	
	public Integer getUpdateValue() {
		return updateValue;
	}
	public void setUpdateValue(Integer updateValue) {
		this.updateValue = updateValue;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + ", updateValue=" + updateValue + "]";
	}
	
	
	
	
	
}
