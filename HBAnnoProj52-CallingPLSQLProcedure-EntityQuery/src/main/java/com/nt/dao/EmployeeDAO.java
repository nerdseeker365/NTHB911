package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface EmployeeDAO {
	 public  List<Employee>  getEmpsByEIDRange(int start,int end); 

}
