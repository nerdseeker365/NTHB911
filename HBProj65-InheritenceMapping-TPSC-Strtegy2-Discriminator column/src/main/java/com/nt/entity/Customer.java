package com.nt.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	private String addrs;
	private  float billAmt;
	
	@Override
	public String toString() {
		return "Customer [addrs=" + addrs + ", billAmt=" + billAmt + ", toString()=" + super.toString() + "]";
	}

}
