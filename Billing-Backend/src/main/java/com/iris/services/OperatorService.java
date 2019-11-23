package com.iris.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.models.Attandance;
import com.iris.models.Employee;
import com.iris.models.Project;

public interface OperatorService {

	List<Employee> getAllEmployee();

	boolean setAttandance(Attandance dataObj);

	List<Project> getAllProject();

}
