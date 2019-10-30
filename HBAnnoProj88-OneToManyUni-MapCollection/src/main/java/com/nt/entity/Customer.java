package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="CUSTOMER_OTM_MAP")
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
	
	public Customer() {
		System.out.println("Customer:0-param constuctor");
	}

}
