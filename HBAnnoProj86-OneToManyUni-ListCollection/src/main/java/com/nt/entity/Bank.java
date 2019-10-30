package com.nt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="BANK_OTM_LIST")
public class Bank {
	@Id
	@Column(length=10)
	@Type(type="string")
	private String ifscCode;
	@Column(length=10)
	@Type(type="string")
	private String bankName;
	@Column(length=10)
	@Type(type="string")
	private String location;
	
	public Bank() {
		System.out.println("Bank:0-param constructor");
	}
	
	@OneToMany(targetEntity=Customer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="bankId",referencedColumnName="ifscCode")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	//@IndexColumn(name="lst_indx",base=0)
	@OrderColumn(name="lst_indx")
	@ListIndexBase(value=1)
	private List<Customer> customers;

	@Override
	public String toString() {
		return "Bank [ifscCode=" + ifscCode + ", bankName=" + bankName + ", location=" + location + "]";
	}

	
}
