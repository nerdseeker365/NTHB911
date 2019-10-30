//Employee.java(Entity class/Persistence class/Model class/BO class/HLO class/Domain class/POJO class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity
/*@FilterDefs(value= {@FilterDef(name="UNOFFICIAL_EMPS",
                                                              parameters= {@ParamDef(type="int",name="min"),
                                                            		                    @ParamDef(type="int",name="max")
                                                            		                   }
                                                           )
                                       }
                       )


@Filters(value= {@Filter(name="UNOFFICIAL_EMPS",condition="eid>=:min and eid<=:max")}) */

@FilterDefs(@FilterDef(name="UNOFFICIAL_EMPS",
                                               parameters= {@ParamDef(type="int",name="min"),
		                                                                 @ParamDef(type="int",name="max")
		                                                                 }
                                               )
                                    
                      )


@Filters(@Filter(name="UNOFFICIAL_EMPS",condition="eid>=:min and eid<=:max")) 


public class Employee implements Serializable {
	//Entity properties
	@Id
	private int eid;
	private String ename;
	private String email;
	private Integer salary;
	
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

	public Integer getSalary() {
		System.out.println("Employee.getSalary()");
		return salary;
	}

	public void setSalary(Integer salary) {
		System.out.println("Employee.setSalary()");
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", salary=" + salary + "]";
	}
	
	
   
   
}
