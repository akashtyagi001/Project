package com.iris.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.EmployeeDao;
import com.iris.models.Employee;
import com.iris.services.EmployeeService;

@Component
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
   private EmployeeDao EmployeeDaoObj;
	
	
	public List<Employee> getAllEmployee() {
		
		return EmployeeDaoObj.getAllEmployee();
	}

}













