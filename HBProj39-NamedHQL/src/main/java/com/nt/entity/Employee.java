//Employee.java(Entity class/Persistence class/Model class/BO class/HLO class/Domain class/POJO class)
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Employee implements Serializable {
	//Entity properties
	private int eid;
	private String ename;
	private String email;
	private float salary;
	
	
   
}
