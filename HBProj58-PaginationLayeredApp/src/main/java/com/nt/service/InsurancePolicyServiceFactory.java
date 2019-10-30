package com.nt.service;

public class InsurancePolicyServiceFactory {
	public static InsurancePolicyService getInstance() {
		return new InsurancePolicyServiceImpl();
	}

}
