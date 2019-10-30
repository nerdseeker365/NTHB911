package com.nt.entity;

import java.io.Serializable;

public final class InsurancePolicy implements Serializable,IPolicy {
	private int policyId;
	private String policyName;
	private  String policyHolderName;
	private  int tenure;
	
	public InsurancePolicy() {
		System.out.println("InsurancePolicy:0-param constructor");
	}
	
	public int getPolicyId() {
		System.out.println("InsurancePolicy.getPolicyId()");
		return policyId;
	}
	public void setPolicyId(int policyId) {
		System.out.println("InsurancePolicy.setPolicyId()");
		this.policyId = policyId;
	}
	public String getPolicyName() {
		System.out.println("InsurancePolicy.getPolicyName()");
		return policyName;
	}
	public void setPolicyName(String policyName) {
		System.out.println("InsurancePolicy.setPolicyName()");
		this.policyName = policyName;
	}
	public String getPolicyHolderName() {
		System.out.println("InsurancePolicy.getPolicyHolderName()");
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		System.out.println("InsurancePolicy.setPolicyHolderName()");
		this.policyHolderName = policyHolderName;
	}
	public int getTenure() {
		System.out.println("InsurancePolicy.getTenure()");
		return tenure;
	}
	public void setTenure(int tenure) {
		System.out.println("InsurancePolicy.setTenure()");
		this.tenure = tenure;
	}

}
