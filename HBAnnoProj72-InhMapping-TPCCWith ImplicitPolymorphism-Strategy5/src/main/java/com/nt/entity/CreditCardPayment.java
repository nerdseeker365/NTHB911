package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
@Table(name="TPCC_CREDITCARD_IMP")
public class CreditCardPayment extends Payment {
	@Column(length=20)
	@Type(type="long")
	private long cardNumber;
	@Column(length=15)
	@Type(type="string")
	private  String holderName;
	@Column(length=10)
	@Type(type="string")
	private String gateway;
	@Override
	public String toString() {
		return "CreditCardPayment [cardNumber=" + cardNumber + ", holderName=" + holderName + ", gateway=" + gateway
				+ ", getPayId()=" + getPayId() + ", getAmount()=" + getAmount() + ", getRemarks()=" + getRemarks()
				+ "]";
	}
	
	

}
