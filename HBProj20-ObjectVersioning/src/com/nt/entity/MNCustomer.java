package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MNCustomer implements Serializable {
	private int custId;
	private String custName;
	private long mobileNo;
	private String callerTune;
	private  int  tuneChangeCount;

}
