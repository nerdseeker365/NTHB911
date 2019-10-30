package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="CUSTOMER_OTM_BI")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(length=15)
	@Type(type="long")
	private long acno;
	
	@Column(length=10)
	@Type(type="string")
	private  String name;
	
	@Column(precision=2,scale=8)
	@Type(type="float")
	private float balance;
	
	@ManyToOne(targetEntity=Bank.class,
			                      cascade=CascadeType.ALL,
			                        fetch=FetchType.EAGER)
	@JoinColumn(name="bankId",referencedColumnName="ifscCode")
	private  Bank bank;
	
	public Customer() {
		System.out.println("Customer:0-param constuctor");
	}

	@Override
	public String toString() {
		return "Customer [acno=" + acno + ", name=" + name + ", balance=" + balance + "]";
	}
	
	

}
