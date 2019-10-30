package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable{
	private int pid;
	private String pname;
	private JobDetails details;

}
