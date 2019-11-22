package com.iris.services;

import java.util.List;

import com.iris.models.Project;
import com.iris.models.ProjectConfiguration;

public interface ProjectService {
	List<Project> getAllProject();
	List<ProjectConfiguration> getAllProjectConfig();
	
    }
