package com.outhreeit.quickrbooks.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.outhreeit.quickrbooks.entities.User;
import com.outhreeit.quickrbooks.services.UserService;

@RequestMapping(value="/user")
@RestController
public class UserWebController extends BaseController<User>{

	@Autowired
	public UserWebController(UserService service){
		super(service);
	}
	
	
}
