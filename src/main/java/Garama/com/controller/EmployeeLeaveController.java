package Garama.com.controller;

import java.util.List;

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

import Garama.com.model.EmployeeLeave;
import Garama.com.service.EmployeeLeaveService;

@RestController
@RequestMapping("/employee/leave")

public class EmployeeLeaveController {
	@Autowired
   EmployeeLeaveService employeeLeaveService;
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeLeave>> getAllEmployeeLeaveDetail(){
		
		List<EmployeeLeave> employeeLeave = employeeLeaveService.findAllEmployeeLeaveDetails();
		return new ResponseEntity<>(employeeLeave,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeLeave> addEmployeeLeaveDetail(@RequestBody EmployeeLeave employeeLeave){
		EmployeeLeave leave = employeeLeaveService.addEmployeeLeave(employeeLeave);
		return new ResponseEntity<>(leave,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeLeave> updateEmployeeLeaveDetail(@RequestBody EmployeeLeave employeeLeave){
		EmployeeLeave leave = employeeLeaveService.updateEmployeeLeave(employeeLeave);
		return new ResponseEntity<>(leave,HttpStatus.OK);
	}
  
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeLeaveDetail(@PathVariable String id) {
	   Long leaveId = Long.parseLong(id);
	   employeeLeaveService.deleteEmployeeLeave(leaveId);
	   return new ResponseEntity<>(HttpStatus.OK);
   }
	
}
