package in.orcas.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class BankAccount {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accno")
	private Long accNo;
	
	@Column(name = "accholdername" , length = 20)
	private String accHolderName;
	
	@Column(name = "balance")
	private Double balance;
	
	@CreationTimestamp
	@Column(name = "openingdate")
	private LocalDateTime openingDate;
	
	@UpdateTimestamp
	@Column(name = "lastupdated")
	private LocalDateTime lastUpdated;
	
	@Version
	@Column(name = "version")
	private Integer version;

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accHolderName=" + accHolderName + ", balance=" + balance
				+ ", openingDate=" + openingDate + ", lastUpdated=" + lastUpdated + ", version=" + version + "]";
	}
	
	
}
