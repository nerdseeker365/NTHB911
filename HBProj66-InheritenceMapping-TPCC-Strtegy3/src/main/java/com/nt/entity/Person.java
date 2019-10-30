package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public abstract class Person implements Serializable{
	private int pid;
	private String pname;
	private  String company;
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", company=" + company + "]";
	}
	

}
