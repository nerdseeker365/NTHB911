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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="PROJECTS_MTM_ID")
public class Project implements Serializable {
	@Id
	@GenericGenerator(name="gen1",strategy="sequence",parameters=@Parameter(name="sequence_name",value="proj_seq1"))
	@GeneratedValue(generator="gen1")
	@Column(length=10)
	@Type(type="int")
	private int projId;
	@Column(length=15)
	@Type(type="string")
	private String projName;
	@Column(length=10)
	@Type(type="string")
	private String clientName;
	
	@ManyToMany(targetEntity=Programmer.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="projects")
	private List<Programmer> programmers=new ArrayList();
	
	
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", clientName=" + clientName + "]";
	}
		

}//class


/*SQL> create sequence proj_seq1 start with 1000 increment by 1;*/
