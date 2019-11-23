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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.EmployeeDao;
import com.iris.daos.ProjectDao;
import com.iris.models.Employee;
import com.iris.models.Project;
import com.iris.models.ProjectAllocation;
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

		List<Project> projectList = adminService.getAllProject();
       List<Role> rolesList = adminService.getAllRole();
		List<Employee> Elist=adminService.getAllEmployee();
	map.addAttribute("dObj", Elist);
	map.addAttribute("proj", projectList);
	map.addAttribute("role",rolesList);
		

		return "Allocation";

	}


	@RequestMapping(value="/submitAllocate",method=RequestMethod.GET)

	public String validateConfigr(@RequestParam int projectId,@RequestParam int roleId,@RequestParam String location,@RequestParam int employeeId,ModelMap map){

		System.out.println(projectId+""+roleId+""+location+""+employeeId);

		List<Project> projectList = adminService.getAllProject();
	       List<Role> rolesList = adminService.getAllRole();
			List<Employee> Elist=adminService.getAllEmployee();
		map.addAttribute("dObj", Elist);
		map.addAttribute("proj", projectList);
		map.addAttribute("role",rolesList);
	
	List<ProjectConfiguration> Obj=projectDao.validateProject(projectId,roleId,location);



	ProjectConfiguration confObj=Obj.get(0);

	Employee EmpObj=employeeDao.getEmployeeById(employeeId);
       ProjectAllocation ab=new ProjectAllocation();
        ab.setEmplObj(EmpObj);
         ab.setConfigObj(confObj);
	boolean saved=projectDao.setProjectAllocation(ab);

	if(saved) {

		map.addAttribute("msg","Allocation done");

		return "Allocation";
	

	}

	else {

		map.addAttribute("msg","Allocation error");

	return "Allocation";

	}



	}	
	
	@RequestMapping(value= {"/ProjectConfig"},method=RequestMethod.GET)

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