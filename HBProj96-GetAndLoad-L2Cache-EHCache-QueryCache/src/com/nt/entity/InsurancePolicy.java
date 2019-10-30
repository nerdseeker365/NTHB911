package com.nt.entity;

import java.io.Serializable;

public final class InsurancePolicy implements Serializable {
	private int policyId;
	private String policyName;
	private  String policyHolderName;
	private  int tenure;
	
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
