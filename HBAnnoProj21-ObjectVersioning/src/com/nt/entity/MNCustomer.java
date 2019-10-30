package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
public class MNCustomer implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int custId;
	private String custName;
	private long mobileNo;
	private String callerTune;
	@Version
	private  int  tuneChangeCount;

}
