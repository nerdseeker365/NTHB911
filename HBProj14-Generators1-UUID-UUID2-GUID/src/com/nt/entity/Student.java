package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable {
	private String sno;
	private String sname;
	private String sadd;
	
	public  Student() {
		System.out.println("Student:0-param constructor");
	}
	

}
