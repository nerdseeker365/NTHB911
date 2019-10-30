package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobDetails implements Serializable {
	private String desg;
	private String company;
	private  double salary;
	

}
