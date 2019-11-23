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
import com.iris.models.Attandance;
import com.iris.models.Employee;
import com.iris.models.Project;
import com.iris.services.OperatorService;
@Controller
public class OperatorController {

	@Autowired

	private OperatorService operatorService;	

	@Autowired

	private EmployeeDao employeeDao;


	@Autowired

	private ProjectDao projectDao;
	

	@Autowired

	HttpSession session;

	@RequestMapping(value= "/Attandance",method=RequestMethod.GET)
	public String Allocation(ModelMap map) {

		List<Employee> Dlist=operatorService.getAllEmployee();
        List<Project> projectList = operatorService.getAllProject();

		Attandance dataObj=new Attandance();

		map.addAttribute("dataObj", dataObj);

		map.addAttribute("proj", projectList);

		map.addAttribute("dObj", Dlist);
		return "Attandance";

	}
	
	@RequestMapping(value= {"/submitAttendance"},method=RequestMethod.GET)
	public ModelAndView submitAttendance(@Valid @ModelAttribute(name="dataObj")  Attandance dataObj,BindingResult result,ModelMap map) {

		

		try {

			boolean saved = operatorService.setAttandance(dataObj);

			map.addAttribute("msg","set Attendance Successful");

			System.out.println("done in project config");

		

			if(saved) {

				ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBilling/Config");

				mv.addObject("msg","Configuration Added Succesfully..");

				System.out.println("return to page and added successfully");

				return mv;

			} else {

				ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBilling/Config");

				mv.addObject("errorMsg","noooo");

				System.out.println("return to page and not added added successfully");

				return mv;

			}

		}

		catch(Exception e)

		{

			System.out.println("I m catch");

			//e.printStackTrace();

			ModelAndView mv=new ModelAndView("redirect:http://localhost:1234/ProjectBilling/Config");

			mv.addObject("errorMsg","Project already configured..");

			return mv;

		}

	}

}
