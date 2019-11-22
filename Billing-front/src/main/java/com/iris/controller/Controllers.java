package com.iris.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Controller
public class Controllers {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
    public String sayHello(){
           return "homepage";
}
    @RequestMapping(value="/login",method=RequestMethod.GET)
  public String getSignInForm(){
          return "login";
  }
    
    @Autowired
	HttpServletRequest session;
@RequestMapping(value="/getSignInForm",method=RequestMethod.POST)
public String validateUser(@RequestParam int userId,@RequestParam String password) {
	User uObj=userDao.validateUser(userId,password);
	if(uObj!=null){
		session.setAttribute("uObj",uObj);
		if(uObj.getEmployeeRole().equals("admin")) {
			return "admin";
		}
		else
		return "operator";
}
	else {
		
		return "login";
	}
}
}
