package com.nt.service;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO dao;
	 public EmployeeServiceImpl() {
		dao=EmployeeDAOFactory.getInstance();
	}
	
	@Override
	public EmployeeDTO searchEmployee(int eno) {
		Employee emp=null;
		EmployeeDTO dto=null;
		//use DAO
		emp=dao.findEmployee(eno);
		//Convert Entity obj to DTO class object
		if(emp!=null) {
		dto=new EmployeeDTO();
		dto.setEid(emp.getEid());
		dto.setEname(emp.getEname());
		dto.setSalary(emp.getSalary());
		dto.setEmail(emp.getEmail());
		}
		return dto;
	}

}
