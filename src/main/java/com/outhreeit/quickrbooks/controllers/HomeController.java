package com.outhreeit.quickrbooks.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.outhreeit.quickrbooks.entities.User;
import com.outhreeit.quickrbooks.services.BaseService;
import com.outhreeit.quickrbooks.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	protected UserService service;

	public HomeController(UserService service) {
	    this.service = service;
	}
	
	public HomeController(){}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "/index.html";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response){
    	/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }*/
        return "/log-in.html";
    }
    
    
    @RequestMapping(value="/loginsuccess", method=RequestMethod.GET)
    public String loginSuccess(){
    	service.addUserIfNotInDatabase();
    	return "redirect:/index.html";
    }
    
  /*  @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }*/
    
 

}
