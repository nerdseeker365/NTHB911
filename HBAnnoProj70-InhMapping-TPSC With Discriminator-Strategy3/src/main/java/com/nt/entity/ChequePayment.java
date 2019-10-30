package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="TPSC_CHEQUE_DISC")
@PrimaryKeyJoinColumn(name="paymentId",referencedColumnName="payId")
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment {
	@Column(length=15)
	@Type(type="long")
	private long chequeNumber;
	@Column(length=10)
	@Type(type="string")
	private String payeeName;
	@Column(length=15)
	@Type(type="string")
	private String  chequeType;
	
	@Override
	public String toString() {
		return "ChequePayment [chequeNumber=" + chequeNumber + ", payeeName=" + payeeName + ", chequeType=" + chequeType
				+ ", getPayId()=" + getPayId() + ", getAmount()=" + getAmount() + ", getRemarks()=" + getRemarks()
				+ "]";
	}
	
	

}
