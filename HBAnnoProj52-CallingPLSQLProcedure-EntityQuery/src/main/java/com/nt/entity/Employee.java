//Employee.java(Entity class/Persistence class/Model class/BO class/HLO class/Domain class/POJO class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries(@NamedNativeQuery(name="CALL_PRO",
                                                                                         query="{ call p_getEmployees_By_EId_Range(?,:min,:max)}",
                                                                                         resultClass=Employee.class,
                                                                                         callable=true)
                                            )
public class Employee implements Serializable {
	//Entity properties
	@Id
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
