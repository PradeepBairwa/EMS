package com.glic.ems.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.glic.ems.enums.Gender;

@Entity
public class Employee {
	

	


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee-sequence-generator")
    @SequenceGenerator(name = "employee-sequence-generator", sequenceName = "user_sequence", initialValue = 100 )
	private Long employeeId;
	
    
	private String employeeName;
	private Long salary;
	private String contactNo;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String dob;
	
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Employee( String employeeName, Gender gender, Long salary, String contactNo, String dob) {
		super();
		this.employeeName = employeeName;
		this.gender = gender;
		this.salary = salary;
		this.contactNo = contactNo;
		this.dob = dob;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}
