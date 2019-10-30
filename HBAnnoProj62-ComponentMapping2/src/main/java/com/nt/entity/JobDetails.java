package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class JobDetails implements Serializable {
	private String desg;
	private String company;
	private  double salary;
	

}
