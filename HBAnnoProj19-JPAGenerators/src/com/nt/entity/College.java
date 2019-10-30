package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
public class College implements Serializable {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)*/
	
	/*@Id
	@SequenceGenerator(name="gen1",sequenceName="MyClg_seq",initialValue=10,allocationSize=5)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)*/
	
	/*@Id
	@TableGenerator(name="gen1",pkColumnName="ID_GEN",pkColumnValue="ID",
	                                  table="ID_TAB",valueColumnName="ID_VAL",initialValue=100,allocationSize=5)
	@GeneratedValue(generator="gen1",strategy=GenerationType.TABLE)*/
	
/*	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id;
	private  String name;
	private String  location;
	private int strength;
	private String grade;
	
		

}
