package com.iris.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.EmployeeDao;
import com.iris.daos.ProjectDao;
import com.iris.models.Project;
import com.iris.models.ProjectConfiguration;
import com.iris.models.Role;
import com.iris.services.AdminService;

@Controller
public class AdminController {

	@Autowired
  private AdminService adminService;
 
	@Autowired
	  private EmployeeDao employeeDao;
	@Autowired
	  private ProjectDao projectDao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/Config",method=RequestMethod.GET)
	public String config(ModelMap map)
	{
		List<ProjectConfiguration> projConfig = adminService.getAllProjectConfig();
		map.addAttribute("configList",projConfig);
		List<Project> projectList = adminService.getAllProject();
		ProjectConfiguration projectConf=new ProjectConfiguration();
		Role roleObj =new Role();
		List<Role> roleList=adminService.getAllRole();
		map.addAttribute("pObj",projectConf);
        map.addAttribute("rObj",roleObj);
        map.addAttribute("proj",projectList);
        map.addAttribute("role",roleList);
        
      
        return "Config";
	}
	


	@RequestMapping(value= {"/Allocation"},method=RequestMethod.GET)

	public String Allocation(ModelMap map) {

	return "Allocation";

	}

	

	@RequestMapping(value= {"/submitConfig"},method=RequestMethod.GET)

	public ModelAndView submitConfig(@ModelAttribute(name="pObj") @Valid ProjectConfiguration pObj1,BindingResult result,ModelMap map) {

		try {

			boolean saved = adminService.setProjectConfig(pObj1);

			map.addAttribute("msg","Project Configuration Successful");

			System.out.println("done in project config");

		

			if(saved) {

				ModelAndView mv=new ModelAndView("redirect:http://localhost:8007/Billing-front/Config");

				mv.addObject("msg","Configuration Added Succesfully..");

				System.out.println("return to page and added successfully");

				return mv;

			} else {

				ModelAndView mv=new ModelAndView("redirect:http://localhost:8007/Billing-front/Config");

				mv.addObject("errorMsg","noooo");

				System.out.println("return to page and not added added successfully");

				return mv;

			}

		}

		catch(Exception e)

		{

			System.out.println("I m catch");

			//e.printStackTrace();

			ModelAndView mv=new ModelAndView("redirect:http://localhost:8007/Billing-front/Config");

			mv.addObject("errorMsg","Project already configured..");

			return mv;

		}

		

	}
	}
