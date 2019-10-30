package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Programmer {
	private int pid;
	private String pname;
	private int salary;
	private Set<Project> projects=new HashSet();
	
	
	
	@Override
	public String toString() {
		return "Programmer [pid=" + pid + ", pname=" + pname + ", salary=" + salary + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmer other = (Programmer) obj;
		if (pid != other.pid)
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pid;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + salary;
		return result;
	}
	
	

}
