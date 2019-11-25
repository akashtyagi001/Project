package com.iris.daos;

import java.util.List;

import com.iris.models.Operator;
import com.iris.models.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployee();
	public List <Employee> EmployeeAllocation(int empId);
	public Employee getEmployeeById(int id);
	public boolean setAttandance(Operator obj);	

	public Operator getBill(Integer id,String month,String year);
}
