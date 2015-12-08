package com.outhreeit.quickrbooks.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outhreeit.quickrbooks.entities.Username;
import com.outhreeit.quickrbooks.services.UsernameService;

@RequestMapping(value="/user")
@RestController
public class UsernameController extends BaseController<Username> implements IBaseController<Username>{

	@Autowired
	public UsernameController(UsernameService service){
		super(service);
	}
}
