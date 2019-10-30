package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  int policyId;
	private  String policyName;
	private  String policyHolderName;
	private  int tenure;
	
	
}
