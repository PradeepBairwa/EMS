package com.glic.ems.controller;

import java.util.List;

import javax.activation.MimeType;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glic.ems.customexception.BusinessException;
import com.glic.ems.customexception.ControllerException;
import com.glic.ems.model.Employee;
import com.glic.ems.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//Add New Employee
//	@RequestMapping(value = "/add",produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},consumes ={MimeTypeUtils.APPLICATION_JSON_VALUE} )
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee( @RequestBody Employee employee) {
		try {
		Employee saved= this.employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(saved,HttpStatus.CREATED); 
		}catch(BusinessException e) { 
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}catch(Exception e) {
			ControllerException ce=new ControllerException("613","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
			
		}
	}
	
	//Delete Employee
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		this.employeeService.deleteEmployee(id);
	}
	
	//Update Employee
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			Employee update=this.employeeService.updateEmployee(employee);
			return new ResponseEntity<Employee>(update,HttpStatus.ACCEPTED);
		}catch(BusinessException e){
			
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		}catch(Exception e) {
			ControllerException ce=new ControllerException("613","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	//Get By Id
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long id) {
		try {
		List<Employee> empList= this.employeeService.getById(id);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		}catch(BusinessException b) {
			ControllerException c=new ControllerException(b.getErrorCode(),b.getErrorMessage());
			return new ResponseEntity<ControllerException>(c,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce=new ControllerException("613","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Get All Employee
	@GetMapping("/all")
	public ResponseEntity< List<Employee>> getAllEmployee(){
		List<Employee> allEmployee=this.employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK); 
	}
	
	//Get Employee By Name
	@GetMapping("/name/{name}")
	public ResponseEntity<?>  getByName(@PathVariable("name") String name){
		List<Employee> empRetrived;
		try {
		 empRetrived= this.employeeService.getByName(name);
		return new ResponseEntity<List<Employee>>(empRetrived,HttpStatus.OK);
		}catch(BusinessException b) {
			ControllerException c=new ControllerException(b.getErrorCode(),b.getErrorMessage());
			return new ResponseEntity<ControllerException>(c,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce=new ControllerException("613","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	//Get Employee By DOB
	@GetMapping("/dob/{dob}")
	public ResponseEntity<?> getByDob(@PathVariable("dob") String dob){
		try {
		List<Employee> empGet= this.employeeService.getByDob(dob);
		return new ResponseEntity<List<Employee>>(empGet,HttpStatus.OK);
		}catch(BusinessException b) {
			ControllerException c=new ControllerException(b.getErrorCode(),b.getErrorMessage());
			return new ResponseEntity<ControllerException>(c,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce=new ControllerException("613","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
}
