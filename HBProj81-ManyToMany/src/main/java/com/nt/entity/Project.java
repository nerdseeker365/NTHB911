package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Project {
	private int projId;
	private String projName;
	private String clientName;
	private Set<Programmer> programmers=new HashSet();
	
	
	
	
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", clientName=" + clientName + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (projId != other.projId)
			return false;
		if (projName == null) {
			if (other.projName != null)
				return false;
		} else if (!projName.equals(other.projName))
			return false;
		return true;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + projId;
		result = prime * result + ((projName == null) ? 0 : projName.hashCode());
		return result;
	}
	
	

}
