package com.glic.ems.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.glic.ems.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public void deleteEmployee(long id);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public List<Employee>getByName(String empName);
	public List<Employee>getByDob(String dob);
	public List<Employee> getById(Long id);
	
	
	

}
