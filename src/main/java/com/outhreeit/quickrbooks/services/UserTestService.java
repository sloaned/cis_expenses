package com.outhreeit.quickrbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.outhreeit.quickrbooks.daos.IUserTestDao;
import com.outhreeit.quickrbooks.entities.Username;

public class UserTestService implements IUserTestService{
	@Autowired
	protected IUserTestDao dao;
	
	public UserTestService(IUserTestDao dao){
		this.dao = dao;
	}

    public List<Username> getAll() {
        return dao.getAll();
    }

    public void add(Username t) {
        dao.add(t);
    }

    public void update(Username t) {
        dao.update(t);
    }

    public void delete(Integer id) {

    }

    public UserTestService() {

    }

    public Username getByID(Integer id){
        return (Username) dao.getByID(id);
    }
    
    public boolean doesNameExist(String name){
    	return dao.doesNameExist(name);
    }

}
