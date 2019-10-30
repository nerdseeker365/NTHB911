package com.nt.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="ANNO_LIBRARY_OTO_PK")
public class LibraryMembership {
	@Id
	@GenericGenerator(name="gen1",strategy="foreign",
	                                           parameters=@Parameter(name="property",
	                                                                                          value="studDetails")) 
	@GeneratedValue(generator="gen1")
	@Column(length=10)
	@Type(type="int")
	private int lid;
	@Column(length=10)
	@Type(type="string")
	private  String type;
	@Column(length=10)
	@Type(type="date")
	private Date doj;
	
	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="lid",referencedColumnName="sno")
	private Student studDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembeship:0-param constructor");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryMembership other = (LibraryMembership) obj;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
		if (lid != other.lid)
			return false;
		if (studDetails == null) {
			if (other.studDetails != null)
				return false;
		} else if (!studDetails.equals(other.studDetails))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + lid;
		result = prime * result + ((studDetails == null) ? 0 : studDetails.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}
	
	
	
	

}
