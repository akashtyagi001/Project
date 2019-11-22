package com.iris.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.EmployeeDao;
import com.iris.daos.ProjectDao;
import com.iris.daos.RoleDao;
import com.iris.models.Employee;
import com.iris.models.Project;
import com.iris.models.ProjectConfiguration;
import com.iris.models.Role;
import com.iris.services.AdminService;
@Component
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	
	 @Autowired
	 private ProjectDao projectDao;
	 @Autowired
	 private RoleDao roleDao;
	 @Autowired
	 private EmployeeDao employeeDao;
	 
	 
	public List<Project> getAllProject() {
		return projectDao.getAllProject();
	}

	public List<Role> getAllRole() {
		
		return roleDao.getAllRole();
	}

	public List<Employee> getAllEmployee() {
				return employeeDao.getAllEmployee();
	}

	public List<ProjectConfiguration> getAllProjectConfig() {
		return projectDao.getAllProjectConfig();
	}
	public Project getProjectById(int pId) {
		
		return projectDao.getProjectById(pId);
	}


	public boolean setProjectConfig(ProjectConfiguration pObj1) {
		 
 {

			boolean save = projectDao.setProjectConfig(pObj1);

			return save;

		}
	

}
}
