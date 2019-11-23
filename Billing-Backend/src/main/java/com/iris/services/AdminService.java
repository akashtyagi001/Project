package com.iris.services;

import java.util.List;

import com.iris.models.Employee;
import com.iris.models.Project;
import com.iris.models.ProjectConfiguration;
import com.iris.models.Role;

public interface AdminService {
  List<Project> getAllProject();
  List<Role> getAllRole();
  List<Employee> getAllEmployee();
  List<ProjectConfiguration> getAllProjectConfig();
  Project getProjectById(int pId);
  boolean setProjectConfig(ProjectConfiguration pObj1);
}
