package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="PROGRAMMERS_MTM_ID")
public class Programmer implements Serializable {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(length=5)
	@Type(type="int")
	private int pid;
	@Column(length=15)
	@Type(type="string")
	private String pname;
	@Column(scale=10,precision=2)
	@Type(type="float")
	private float salary;
	
	@ManyToMany(targetEntity=Project.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="PROGRAMMERS_PROJECTS_MTM_ID",
	                      joinColumns=@JoinColumn(name="programmer_id",referencedColumnName="pid"),
	                      inverseJoinColumns=@JoinColumn(name="project_id",referencedColumnName="projId")
	                    )
	@GenericGenerator(name="gen2",strategy="increment")
	@CollectionId(columns=@Column(name="pgmr_proj_indx"),
	                            type=@Type(type="int"),
	                            generator="gen2"
	                          )
	private List<Project> projects=new ArrayList();
	
	
	
	@Override
	public String toString() {
		return "Programmer [pid=" + pid + ", pname=" + pname + ", salary=" + salary + "]";
	}



	

}
