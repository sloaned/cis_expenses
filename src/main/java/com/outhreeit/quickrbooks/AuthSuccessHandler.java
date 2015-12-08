package com.outhreeit.quickrbooks;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.outhreeit.quickrbooks.daos.UserTestDao;
import com.outhreeit.quickrbooks.daos.UsernameDao;
import com.outhreeit.quickrbooks.entities.Username;
import com.outhreeit.quickrbooks.services.UserTestService;
import com.outhreeit.quickrbooks.services.UsernameService;
import com.outhreeit.quickrbooks.webcontroller.UsernameController;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private UsernameDao usernameDao = new UsernameDao();
	private UsernameService usernameService = new UsernameService(usernameDao); 
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("user = " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		String authUser = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		System.out.println("user = " + authUser);
		boolean inDatabase = usernameService.doesNameExist(authUser);
		if(!inDatabase){
			Username username = new Username(authUser);
			usernameService.add(username);
		}
		redirectStrategy.sendRedirect(request,  response,  "/");
	}
	
	
}
