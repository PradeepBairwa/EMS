package com.glic.ems.serviceImpl;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.glic.ems.customexception.BusinessException;
import com.glic.ems.model.Employee;
import com.glic.ems.repository.EmployeeRepository;
import com.glic.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	String regex;
	// ADD - Employee
	
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// Employee Null/empty
		if (employee.getEmployeeName().isEmpty() || employee.getEmployeeName().length() == 0) {
			throw new BusinessException("601", "Please send proper name ,Its blank ");
		}
		//convert first latter into capital
		String cap = employee.getEmployeeName().substring(0, 1).toUpperCase() + employee.getEmployeeName().substring(1);
		employee.setEmployeeName(cap);
		// Employee first character Capital
		if (false == Character.isUpperCase(employee.getEmployeeName().codePointAt(0))) {
			throw new BusinessException("608", "Employee name should be start with Capital Latter");
		}
		

		// Min length
		if (employee.getEmployeeName().length() >= 2) {

		} else {
			throw new BusinessException("611", "Name should be Greater then 2");
		}
		// - salary
		if (employee.getSalary() < 1) {
			throw new BusinessException("609", "Salary should not be negative or zero");
		}
		//phone
		 regex="\\d{10}";
		if(false == employee.getContactNo().matches(regex)) {
			throw new BusinessException("615","Please enter correct phone number");
		}
		// Date
		LocalDate ld = null;
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyy");
		try {
			ld = LocalDate.parse(employee.getDob(), f);
		} catch (Exception e) {
			throw new BusinessException("612", "DOB should be dd-MM-yyy this format");
		}
		LocalDate today = LocalDate.now();
		if (ld.isAfter(today)) { // After today.
			throw new BusinessException("610", "DOB can't be future date");
		}
		
		try {
			return this.employeeRepository.save(employee);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service layer" + e.getMessage());
		}
		
	}

	//Delete-Employee
	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		try {
			this.employeeRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("612", "Given id is null" + e.getMessage());

		}

	}

	//Update - Employee
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// Employee Null/empty
				if (employee.getEmployeeName().isEmpty() || employee.getEmployeeName().length() == 0) {
					throw new BusinessException("601", "Please send proper name ,Its blank ");
				}
				// Employee first character Capital
				if (false == Character.isUpperCase(employee.getEmployeeName().codePointAt(0))) {
					throw new BusinessException("608", "Employee name should be start with Capital Latter");
				}
				// min length
				if (employee.getEmployeeName().length() >= 2) {

				} else {
					throw new BusinessException("611", "Name should be Greater then 2");
				}
				// - salary
				if (employee.getSalary() < 1) {
					throw new BusinessException("609", "Salary should not be negative or zero");
				}
				//phone
				String regex="\\d{10}";
				if(false == employee.getContactNo().matches(regex)) {
					throw new BusinessException("615","Please enter correct phone number");
				}
				// Date
				LocalDate ld = null;
				DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyy");
				try {
					ld = LocalDate.parse(employee.getDob(), f);
				} catch (Exception e) {
					throw new BusinessException("612", "DOB should be dd-MM-yyy this format");
				}
				LocalDate today = LocalDate.now();
				if (ld.isAfter(today)) { // After today.
					throw new BusinessException("610", "DOB can't be future date");
				}

				try {
					return this.employeeRepository.save(employee);
				} catch (IllegalArgumentException e) {
					throw new BusinessException("602", "Given employee is null" + e.getMessage());
				} catch (Exception e) {
					throw new BusinessException("603", "Something went wrong in service layer" + e.getMessage());
				}

	}

	//Get - Employee
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		try {
			List<Employee> empList = this.employeeRepository.findAll();
			if (empList.isEmpty()) {
				throw new BusinessException("604", "Hey list is empty, we have no data");
			}
			return empList;
		} catch (Exception e) {
			throw new BusinessException("604", "something went wrong in service layer");
		}
	}

	//Get - By Name
	@Override
	public List<Employee> getByName(String empName) {
		// TODO Auto-generated method stub
		List<Employee> employee;
		try {
		 employee = this.employeeRepository.findByemployeeName(empName);
		if(employee.isEmpty()) {
			throw new BusinessException("615","Given Employee name is does not exist in db  ");
		}
		return employee;
		}catch (NoSuchElementException e) {
			throw new BusinessException("613", "Given Employee name is does not exist in db " + e.getMessage());
		}
		
	}

	//Get - By DOB
	@Override
	public List<Employee> getByDob(String dob) {
		// TODO Auto-generated method stub
		if(dob.length()!=10) {
			throw new BusinessException("614","date should be in this format 15-11-1998");
		}
		try {
		return this.employeeRepository.findByDob(dob);
		}catch (NoSuchElementException e) {
			throw new BusinessException("613", "Given Employee Date is does not exist in db / Date format should be 03-06-2022" + e.getMessage());
		}
		
	}

	//Get - By Id
	@Override
	public List<Employee> getById(Long id) {
		// TODO Auto-generated method stub
		try {
			return Arrays.asList(this.employeeRepository.findById(id).get()); 

		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "Given id is null" + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("607", "Given Employee id is does not exist in db" + e.getMessage());
		}
	}

}
