package com.nt.entity;

import lombok.Data;

//@Data
public class BankAccount {
	private long acno;
	private String bankName;
	private String branch;
	private float balance;
	private Customer cust;
	
	public BankAccount() {
		System.out.println("BankAccount::0-param constructor");
	}
	
	public long getAcno() {
		return acno;
	}

	public void setAcno(long acno) {
		this.acno = acno;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", bankName=" + bankName + ", branch=" + branch + ", balance=" + balance
				+ "]";
	}	
	
	

}
