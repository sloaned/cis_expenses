package com.outhreeit.quickrbooks.daos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.outhreeit.quickrbooks.entities.Username;

@Repository
@Transactional
public class UsernameDao extends BaseDao<Username> implements IUsernameDao{
	
	public UsernameDao(){
		super("Username", Username.class);
	}
}
