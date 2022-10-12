  package Garama.com.service;
  
 import java.util.List; 
 import java.util.UUID;
 import  org.springframework.stereotype.Service;
  
  import Garama.com.dao.EmployeeRepo;

  import Garama.com.exception.UserNotFoundException;
  import Garama.com.model.Employee;
  
  @Service
  public class EmployeeService {
   private final EmployeeRepo employeeRepo;
  
  public EmployeeService(EmployeeRepo employeeRepo) {
	  this.employeeRepo = employeeRepo; 
  }
  
  
  public Employee addEmployee(Employee employee ){
	  employee.setEmployeeCode(UUID.randomUUID().toString());
	  return employeeRepo.save(employee); 
  }
  
  public List<Employee> findAllEmployee(){
	  return employeeRepo.findAll();
  }
 
  public Employee findEmployeeById(Long id) {
	  return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("user by id "+id+"was not found"));
  }
  
  public Employee updateEmployee(Employee employee) {
	  return employeeRepo.save(employee);
  }
  
  public void deleteEmployee(Long id) {
	  Employee e = employeeRepo.getOne(id);
	  employeeRepo.delete(e);
	  //employeeRepo.deleteEmployeeById(id);
  }
  }
 