package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Department implements Serializable {
	private int deptNo;
	private String deptName;
	private  String deptLoc;
	
	public Department(){
		System.out.println("Department::0-param constructor");
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}

}
