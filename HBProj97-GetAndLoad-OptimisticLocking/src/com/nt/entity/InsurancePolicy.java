package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name="INSURANCEPOLICY")
public final class InsurancePolicy implements Serializable {
	@Id
	private int policyId;
	private String policyName;
	private  String policyHolderName;
	private  int tenure;
	
	@Version
	@Column(name="updateCount",length=5)
	@Type(type="int")
	private int version;
	
	public InsurancePolicy() {
		System.out.println("InsurancePolicy:0-param constructor");
	}
	
	public int getPolicyId() {
	
		return policyId;
	}
	public void setPolicyId(int policyId) {
	
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
	
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyHolderName="
				+ policyHolderName + ", tenure=" + tenure + "]";
	}
	
	

}
