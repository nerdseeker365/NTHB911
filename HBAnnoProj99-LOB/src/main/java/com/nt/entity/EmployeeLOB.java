package com.nt.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
@Table(name="LOB_EMPLOYEE")
public class EmployeeLOB implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="EID",length=5)
	@Type(type="int")
	private int eid;
	
	@Column(name="ENAME",length=15)
	@Type(type="string")
	private String ename;
	@Column(name="SALARY",precision=2,scale=10)
	@Type(type="float")
	private float salary;
	@Column(name="EPHOTO")
	@Type(type="blob")
	private Blob ephoto;
	
	@Column(name="ERESUME")
	@Type(type="clob")
	private Clob eresume;

}
