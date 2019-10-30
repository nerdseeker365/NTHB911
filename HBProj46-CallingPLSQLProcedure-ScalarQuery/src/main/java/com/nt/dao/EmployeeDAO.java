package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface EmployeeDAO {
	 public  List<Object[]>  getEmpsBySalaryRange(int start,int end); 

}
