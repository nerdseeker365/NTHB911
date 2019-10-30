package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@Data
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
public class Event implements Serializable {
	private int id;
	private String name;
	private Date doe;
	private int pax;
	private String location;

}


/*SQL> create table Event(id number(5) primary key,name varchar2(20),doe date,pax number(7),location varchar2(15));*/