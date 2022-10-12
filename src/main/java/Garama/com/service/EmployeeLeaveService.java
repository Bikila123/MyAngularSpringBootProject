package Garama.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Garama.com.dao.EmployeeLeaveRepo;
import Garama.com.exception.UserNotFoundException;
import Garama.com.model.EmployeeLeave;

@Service
public class EmployeeLeaveService {
  @Autowired
  EmployeeLeaveRepo employeeLeaveRepo;
  
  //Method That will add Employee Leave Detail
  public EmployeeLeave addEmployeeLeave(EmployeeLeave employeeLeave){
	  return employeeLeaveRepo.save(employeeLeave);
  }
  //Method That will update employee leave detail 
  public EmployeeLeave updateEmployeeLeave(EmployeeLeave employeeLeave) {
	  return employeeLeaveRepo.save(employeeLeave);
  }
  //Method That will List all Employee's leave detail
  public List<EmployeeLeave> findAllEmployeeLeaveDetails(){
	  return employeeLeaveRepo.findAll();
  }
  //Method That will return employee leave detail by employee id
  public EmployeeLeave findEmployeeById(Long id) {
	  return employeeLeaveRepo.findById(id).orElseThrow(()-> new UserNotFoundException("This Leave detail with"+id+" Not Found"));
  }
  //The Method that will delete Employee leave detail
  public void deleteEmployeeLeave(Long id) {
        EmployeeLeave leave = employeeLeaveRepo.getOne(id);
          employeeLeaveRepo.delete(leave);
  }
}
