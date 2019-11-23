package com.iris.services;

import java.util.List;

import com.iris.models.Attandance;
import com.iris.models.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	public List <Employee> EmployeeAllocation(int empId);
	public Employee getEmployeeById(int id);
	public boolean setAttandance(Attandance obj);	
public Attandance getBill(Integer id,String month,String year);


}
