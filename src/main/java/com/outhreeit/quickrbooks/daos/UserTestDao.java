package com.outhreeit.quickrbooks.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.outhreeit.quickrbooks.entities.Username;

public class UserTestDao implements IUserTestDao{
	
	public UserTestDao(){}

	@PersistenceContext
    protected EntityManager em;

	public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
	@Override
	public void add(Username t) {
		em.persist(t);
		
	}

	@Override
	public void update(Username t) {
		em.merge(t);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Username> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Username getByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesNameExist(String Name) {
    	System.out.println("name = " + Name);
    	System.out.println("em = " + em);
    	ArrayList<Username> results = (ArrayList<Username>) em.createQuery("SELECT x FROM Username x WHERE x.name = :name", Username.class).setParameter("name", Name).getResultList();
    	return(results != null && results.size() != 0);
	}

}
