package com.nt.entity;

import lombok.Data;

@Data
public class PhoneNumber {
	private long phone;
	private String numberType;
	private String provider;
	private int unid;  //optonal
	
	public   PhoneNumber() {
		System.out.println("PhoneNumber::0-param constructor");
	}

}
