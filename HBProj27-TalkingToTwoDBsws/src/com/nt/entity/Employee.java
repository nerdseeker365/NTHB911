package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable {
	private int eid;
	private String ename;
	private String email;
	private int salary;

}
