package com.nt.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name="ANNO_PERSON_OTO_FK")
@Entity
public class Person implements Serializable {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(length=10)
	@Type(type="int")
	private int pid;
	@Column(length=15)
	@Type(type="string")
	private String pname;
	@Column(length=10)
	@Type(type="string")
	private String addrs;

}
