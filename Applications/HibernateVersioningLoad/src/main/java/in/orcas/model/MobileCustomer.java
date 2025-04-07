package in.orcas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "mobilecustomer")
public class MobileCustomer {
	
	private static final long serialVersionUID = 1;
	
	@Id
	@Column(name = "ownerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ownerId;
	
	@Column(name = "ownername",length = 20)
	private String ownerName;
	
	@Column(name = "mobilenumber")
	private Long mobileNumber;
	
	@Version
	@Column(name = "versioncount")
	private Integer versionCount;

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "MobileCustomer [ownerId=" + ownerId + ", ownerName=" + ownerName + ", mobileNumber=" + mobileNumber
				+ ", versionCount=" + versionCount + "]";
	}
	
	
	
	
}
