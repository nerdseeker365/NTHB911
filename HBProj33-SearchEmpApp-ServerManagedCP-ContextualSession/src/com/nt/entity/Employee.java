package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee implements Serializable {
	@Id
	private int eid;
	private String ename;
	private String email;
	private int salary;

}
