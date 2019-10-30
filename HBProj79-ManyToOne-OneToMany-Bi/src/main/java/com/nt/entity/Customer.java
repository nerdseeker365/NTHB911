package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

//@Data
public class Customer implements Serializable {
	private long aadharNo;
	private String  name;
	private String addrs;
	private Set<BankAccount> accounts;
	
	public Customer() {
		System.out.println("Customer:0-param constructor");
	}
	
	
	public long getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddrs() {
		return addrs;
	}


	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}


	public Set<BankAccount> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<BankAccount> accounts) {
		this.accounts = accounts;
	}


	@Override
	public String toString() {
		return "Customer [aadhrNo=" + aadharNo + ", name=" + name + ", addrs=" + addrs +"]";
	}
}
