package com.iris.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.ProjectDao;
import com.iris.models.Project;
import com.iris.models.ProjectConfiguration;
import com.iris.services.ProjectService;
@Component
@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {


	@Autowired
   private ProjectDao projectDaoObj;

	public List<Project> getAllProject() {
		
		return projectDaoObj.getAllProject();
	}


	public List<ProjectConfiguration> getAllProjectConfig() {
	
		return projectDaoObj.getAllProjectConfig();
	}



	

}
