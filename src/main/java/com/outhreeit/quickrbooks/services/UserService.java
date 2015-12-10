package com.outhreeit.quickrbooks.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.outhreeit.quickrbooks.daos.Interface.IUserDao;
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
	
	public User getCurrentUser(){
		String name = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		return (User) dao.getByName(name);
	}



}
