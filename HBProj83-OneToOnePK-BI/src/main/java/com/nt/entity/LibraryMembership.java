package com.nt.entity;

import java.util.Date;

import lombok.Data;

@Data
public class LibraryMembership {
	private int lid;
	private  String type;
	private Date doj;
	private Student studentDetails;
	
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
		if (studentDetails == null) {
			if (other.studentDetails != null)
				return false;
		} else if (!studentDetails.equals(other.studentDetails))
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
		result = prime * result + ((studentDetails == null) ? 0 : studentDetails.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}
	
	
	
	

}
