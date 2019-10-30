package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public final class InsurancePolicy implements Serializable {
	private int policyId;
	private String policyName;
	private  String policyHolderName;
	private  int tenure;
	private  String provider; 
	
	

}
