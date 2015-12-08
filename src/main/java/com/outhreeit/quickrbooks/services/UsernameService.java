package com.outhreeit.quickrbooks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outhreeit.quickrbooks.daos.IBaseDao;
import com.outhreeit.quickrbooks.entities.Username;

@Service
public class UsernameService extends BaseService<Username> implements IBaseService<Username>{
	
	@Autowired
	public UsernameService(IBaseDao dao){
		super(dao);
	}



}
