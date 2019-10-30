package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class LuckyDrawCupon implements Serializable {
	private  int  cuponNumber;
	private String  custName;
	private long  custMobileNo;
	private String custAddrs;
	
	

}
