package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="ANNO_STUDENT_OTO_PK")
public class Student {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(length=10)
	@Type(type="int")
	private int sno;
	@Column(length=14)
	@Type(type="string")
	private String sname;
	@Column(length=14)
	@Type(type="string")
	private String addrs;
	
	@OneToOne(targetEntity=LibraryMembership.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="studDetails")
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("Student:0-param constructor");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (addrs == null) {
			if (other.addrs != null)
				return false;
		} else if (!addrs.equals(other.addrs))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (sno != other.sno)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrs == null) ? 0 : addrs.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + sno;
		return result;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", addrs=" + addrs + "]";
	}
	
	
	
	

}
