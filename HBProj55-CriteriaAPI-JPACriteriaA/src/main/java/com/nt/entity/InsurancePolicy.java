package com.nt.entity;

import lombok.Data;

@Data
public class InsurancePolicy {
	private  int policyId;
	private  String policyName;
	private  String policyHolderName;
	private  int tenure;
	
	public InsurancePolicy(int policyId,String policyName) {
		this.policyId=policyId;
		this.policyName=policyName;
	}
	
	public InsurancePolicy() {
	
	}
	
	public InsurancePolicy(int policyId)	{
		this.policyId=policyId;
		
	}

}
