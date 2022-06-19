package com.glic.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glic.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	public List<Employee> findByemployeeName(String empName);

	public List<Employee> findByDob(String dob);
}
