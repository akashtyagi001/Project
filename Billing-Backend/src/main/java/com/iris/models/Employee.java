package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="EmployeeId")
	private int employeeId;
	
	
	@Column(name="EmployeeName")
	private String employeeName;


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
}
