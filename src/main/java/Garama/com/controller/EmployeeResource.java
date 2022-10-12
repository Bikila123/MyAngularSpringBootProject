  package Garama.com.controller;
  
  import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Garama.com.model.Employee;
  import Garama.com.service.EmployeeService;

  
  @RestController
  @RequestMapping("/employee") 
  
  public class EmployeeResource {
	  @Autowired
      EmployeeService employeeService;
 
 
 @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees(){
  List<Employee> employees = employeeService.findAllEmployee(); 
  return new ResponseEntity<>(employees,HttpStatus.OK);
  
  }	
  
  @GetMapping("/find/{id}") 
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){ 
	  Employee employee = employeeService.findEmployeeById(id);
	  return new ResponseEntity<>(employee,HttpStatus.OK);
	 }
  
  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
	  Employee newEmployee = employeeService.addEmployee(employee);
	  return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
	 }
  
  @PutMapping("/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
	  Employee updateEmployee = employeeService.updateEmployee(employee);
	  return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	  
	 }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable String id){
	  Long employeeId = Long.parseLong(id);
      employeeService.deleteEmployee(employeeId);
      return new ResponseEntity<>(HttpStatus.OK);
  }
  
  }
 