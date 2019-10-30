package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class NGOMember implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int mid;
	private String name;
	private float salary;

}
