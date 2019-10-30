//Employee.java(Entity class/Persistence class/Model class/BO class/HLO class/Domain class/POJO class)
package com.nt.entity;

import java.io.Serializable;

public class Employee implements Serializable {
	//Entity properties
	private int eid;
	private String ename;
	private String email;
	private float salary;
	
	public Employee() {
		System.out.println("Employee:0-param constructor");
	}

	public int getEid() {
		System.out.println("Employee.getEid()");
		return eid;
	}

	public void setEid(int eid) {
		System.out.println("Employee.setEid()");
		this.eid = eid;
	}

	public String getEname() {
		System.out.println("Employee.getEname()");
		return ename;
	}

	public void setEname(String ename) {
		System.out.println("Employee.setEname()");
		this.ename = ename;
	}

	public String getEmail() {
		System.out.println("Employee.getEmail()");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Employee.setEmail()");
		
		this.email = email;
	}

	public float getSalary() {
		System.out.println("Employee.getSalary()");
		return salary;
	}

	public void setSalary(float salary) {
		System.out.println("Employee.setSalary()");
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", salary=" + salary + "]";
	}
	
	
   
   
}
