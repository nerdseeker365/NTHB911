package com.nt.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ANNO_LICENSE_OTO_FK")
public class License {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="LID_SEQ",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Column(length=10)
	@Type(type="int")
	private int lid;
	@Column(length=10)
	@Type(type="string")
	private String type;
	@Column(length=15)
	@Type(type="date")
	private Date validFrom;
	@Column(length=15)
	@Type(type="date")
	private Date validTo;
	
	@OneToOne(targetEntity=Person.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="license_holder",referencedColumnName="pid")
	@LazyToOne(value=LazyToOneOption.PROXY)
	@Fetch(FetchMode.JOIN)
	private Person licenseHolder;
	
	@Override
	public String toString() {
		return "License [lid=" + lid + ", type=" + type + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}
	
	
	

}
