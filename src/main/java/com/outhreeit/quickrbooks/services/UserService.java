package com.outhreeit.quickrbooks.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.outhreeit.quickrbooks.daos.IBaseDao;
import com.outhreeit.quickrbooks.daos.IUserDao;
import com.outhreeit.quickrbooks.entities.User;

@Service
public class UserService extends BaseService<User>{
	
	@Autowired
	public UserService(IUserDao dao){
		super(dao);
	}
	
	public void addUserIfNotInDatabase(){
		String authUser = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        boolean inDatabase = dao.doesNameExist(authUser);
        if(!inDatabase){
        	User user = new User(authUser);
        	dao.add(user);
        }
	}



}
