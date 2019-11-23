package com.iris.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.models.Attandance;
import com.iris.models.Employee;
import com.iris.models.Project;
import com.iris.daos.EmployeeDao;
import com.iris.daos.ProjectDao;
import com.iris.daos.RoleDao;


@Component
@Service("operatorService")
@Transactional
public class OperatorServiceImpl {


@Autowired 
private ProjectDao projectsDao;



@Autowired 
private RoleDao roleDao;

@Autowired
private EmployeeDao employeeDao;

public List<Employee> getAllEmployee() {

	return employeeDao.getAllEmployee();

}



public boolean setAttendance(Attandance dataObj) {

	return false;

}



public List<Project> getAllProject() {

	return projectsDao.getAllProject();

}



}