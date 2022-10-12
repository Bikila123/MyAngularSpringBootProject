package Garama.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Garama.com.model.EmployeeLeave;

public interface EmployeeLeaveRepo extends JpaRepository<EmployeeLeave, Long>{

}
