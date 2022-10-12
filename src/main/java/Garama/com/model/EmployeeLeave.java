package Garama.com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeLeave")
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_generator")
    @SequenceGenerator(name = "leave_generator", sequenceName = "leave_seq")
    @Column(nullable = false, updatable = false)
	private Long leaveId;
    private String leaveType;
    private int leaveAmount;
    private Date registrationDate;
    @Column(nullable = false)
    private Long employeeId;
	
	public EmployeeLeave() {
		
	}
	

	public EmployeeLeave(String leaveType, int leaveAmount, Date registrationDate, Long employeeId) {
		super();
		this.leaveType = leaveType;
		this.leaveAmount = leaveAmount;
		this.registrationDate = registrationDate;
		this.employeeId = employeeId;
	}


	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getLeaveAmount() {
		return leaveAmount;
	}

	public void setLeaveAmount(int leaveAmount) {
		this.leaveAmount = leaveAmount;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeLeave [leaveId=" + leaveId + ", leaveType=" + leaveType + ", leaveAmount=" + leaveAmount
				+ ", registrationDate=" + registrationDate + ", employeeId=" + employeeId + "]";
	}
    
	
}
