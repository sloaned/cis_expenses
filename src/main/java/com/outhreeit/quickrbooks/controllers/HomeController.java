package com.outhreeit.quickrbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "/index.html";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/log-in.html";
    }

}
