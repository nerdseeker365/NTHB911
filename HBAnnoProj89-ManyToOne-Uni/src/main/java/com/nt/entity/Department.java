package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="DEPARTMENT_MTO")
public class Department implements Serializable {
	@Id
	@GenericGenerator(strategy="increment",name="gen1")
	@GeneratedValue(generator="gen1")
	@Column(length=10)
	@Type(type="int")
	private int deptNo;
	@Column(length=15)
	@Type(type="string")
	private String deptName;
	@Column(length=15)
	@Type(type="string")
	private  String deptLoc;
	
	public Department(){
		System.out.println("Department::0-param constructor");
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}

}
