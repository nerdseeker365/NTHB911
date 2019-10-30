package com.nt.entity;

import lombok.Data;

@Data
public class EmpDetails {
	private int empNo;
	private String empName;
	private float salary;
	private Department dept;  //for  ManyToOne Association
	
	public  EmpDetails() {
		System.out.println("EmpDetails::0-param constructor");
	}

	@Override
	public String toString() {
		return "EmpDetails [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + "]";
	}
  
}
