package com.nt.entity;

import lombok.Data;

@Data
public class Employee extends Person {
	private String desg;
	private  float salary;
	
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", salary=" + salary + ", toString()=" + super.toString() + "]";
	}

}
