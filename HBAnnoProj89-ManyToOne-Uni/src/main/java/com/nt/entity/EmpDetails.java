package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="EMPDETAILS_MTO")
public class EmpDetails {
	@Id
	@Column(length=10)
	@Type(type="int")
	@GenericGenerator(name="gen1",strategy="sequence",
	                                        parameters=@Parameter(name="sequence_name",value="eno_seq"))
    @GeneratedValue(generator="gen1")	
	private int empNo;
	@Column(length=10)
	@Type(type="string")
	private String empName;
	
	@Column(precision=2,scale=8)
	@Type(type="float")
	private float salary;
	@ManyToOne(targetEntity=Department.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="deptId",referencedColumnName="deptNo")
	@LazyToOne(LazyToOneOption.FALSE)
	private Department dept;  //for  ManyToOne Association
	
	public  EmpDetails() {
		System.out.println("EmpDetails::0-param constructor");
	}

	@Override
	public String toString() {
		return "EmpDetails [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + "]";
	}
  
}

/*SQL> create sequence eno_seq start with 1000  increment by 1;*/
