package com.nt.entity;

public interface IPolicy {
	public int getPolicyId();
	public void setPolicyId(int policyId) ;
	public String getPolicyName();
	public void setPolicyName(String policyName);
	public String getPolicyHolderName();
	public void setPolicyHolderName(String policyHolderName);
	public int getTenure();
	public void setTenure(int tenure);
}
