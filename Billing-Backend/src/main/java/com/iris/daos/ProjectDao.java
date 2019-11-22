package com.iris.daos;

import java.util.List;

import com.iris.models.Project;
import com.iris.models.ProjectConfiguration;

public interface ProjectDao {
	List<Project> getAllProject();
	List<ProjectConfiguration> getAllProjectConfig();
	public Project getProjectById(int pId);
     public boolean setProjectConfig(ProjectConfiguration pObj1);


}
