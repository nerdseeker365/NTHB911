package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BrandFactory implements Serializable {
  private long custMobileNo;
  private  String custName;
  private  String custAddrs; 
  private  int rewardPoints;
  
  public  BrandFactory() {
	  System.out.println("BrandFactory:0-param constructor");
  }
  
}


/*SQL> create table BrandFactory(custMobileNo number(11),custName varchar2(20),custAddrs varchar2(20),rewardPoints number(5));

Table created.

SQL> alter table BrandFactory add primary key(custMobileNo);

Table altered.*/