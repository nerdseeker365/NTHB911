package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="TPCC_PAYMENT_IMP")
@Data
public abstract class Payment {
	@Id
	@Column(length=5)
	@Type(type="int")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int payId;
	@Column(length=10,precision=2)
	@Type(type="float")
	private float amount;
	@Column(length=15)
	@Type(type="string")
		private String remarks;

}
