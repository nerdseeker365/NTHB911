//Employee.java(Entity class/Persistence class/Model class/BO class/HLO class/Domain class/POJO class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQueries(value= {@NamedQuery(name="GET_EMPDETAILS",query="select eid,ename from Employee where salary>=:start and salary<=:end"),
		                                         @NamedQuery(name="UPDATE_EMAIL",query="update Employee set email=:newEmail where eid=:no")
                                              }
                                )

public class Employee implements Serializable {
	//Entity properties
	@Id
	private int eid;
	private String ename;
	private String email;
	private float salary;
	
	
   
}
