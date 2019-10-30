package com.nt.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="PROGRAMMERS_MTM")
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
	@JoinTable(name="PROGRAMMERS_PROJECTS_MTM",
	                      joinColumns=@JoinColumn(name="programmer_id",referencedColumnName="pid"),
	                      inverseJoinColumns=@JoinColumn(name="project_id",referencedColumnName="projId")
	                    )
	private Set<Project> projects=new HashSet();
	
	
	
	@Override
	public String toString() {
		return "Programmer [pid=" + pid + ", pname=" + pname + ", salary=" + salary + "]";
	}



	

}
