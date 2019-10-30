//Employee.java(Entity class/Persistence class/Model class/BO class/HLO class/Domain class/POJO class)
package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee implements Serializable {
	//Entity properties
	@Id
	private int eid;
	private String ename;
	private String email;
	private float salary;
	
	
   
}
