package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class InsurancePolicyDTO implements Serializable{
	private  int policyId;
	private  String policyName;
	private  String policyHolderName;
	private  int tenure;
	
	
}
