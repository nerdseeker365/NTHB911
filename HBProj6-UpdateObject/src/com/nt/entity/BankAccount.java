package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccount implements Serializable {
  private int acno;
  private  String holderName;
  private  float balance;
  private  String type;
}


/*SQL> desc  BankAccount;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
ACNO                                      NOT NULL NUMBER(5)
HOLDERNAME                                         VARCHAR2(20)
BALANCE                                            NUMBER(10,2)
TYPE                                               VARCHAR2(10)*/