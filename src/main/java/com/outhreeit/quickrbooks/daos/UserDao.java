package com.outhreeit.quickrbooks.daos;


import com.outhreeit.quickrbooks.daos.Interface.IUserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.outhreeit.quickrbooks.entities.User;

@Repository
@Transactional
public class UserDao extends BaseDao<User> implements IUserDao {
	
	public UserDao(){
		super(User.class);
	}
}
