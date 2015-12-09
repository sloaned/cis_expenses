package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.entities.BaseEntity;
import com.outhreeit.quickrbooks.entities.User;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;


@Transactional
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class BaseDao<T extends BaseEntity> implements IBaseDao<T>{

    public BaseDao(Class<T> entity) {
        this.table = entity.getSimpleName();
        this.entity = entity;
    }

    @PersistenceContext
    protected EntityManager em;
    private String table;

    public void setEntity(Class<T> entity) {
        this.entity = entity;
    }

    public void setTable(String table) {
        this.table = table;
    }

    protected Class<T> entity;

    public BaseDao() {
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    private String getSelect(){
        return "SELECT x from  "+ table;
    }

    public T getByID(Integer id) {
        return em.createQuery(getSelect() +" x where x.id = :id", entity).setParameter("id",id).getSingleResult();
    }
    
    public boolean doesNameExist(String Name){
    	System.out.println("entity = " + entity);
    	System.out.println("name = " + Name);
    	System.out.println("em = " + em);
    	ArrayList<T> results = (ArrayList<T>) em.createQuery(getSelect() + " x WHERE x.name = :name", entity).setParameter("name", Name).getResultList();
    	System.out.println("entity = " + entity);
    	return(results != null && results.size() != 0);
    }
    
    public T getByName(String Name){
    	System.out.println("entity = " + entity);
    	System.out.println("name = " + Name);
    	System.out.println("em = " + em);
    	User user = (User) em.createQuery(getSelect() + " x WHERE x.name = :name", entity).setParameter("name", Name).getSingleResult();
    	ArrayList<T> users = (ArrayList<T>) em.createQuery(getSelect() +" x", entity).getResultList();
    	System.out.println("all users = " + users);
    	System.out.println("result = " + user);
    	return em.createQuery(getSelect() + " x WHERE x.name = :name", entity).setParameter("name", Name).getSingleResult();
    }

    public ArrayList<T> getAll() {
        //there is a bug wherein you cannot set the table with setParameter and must use string concat
        //http://stackoverflow.com/questions/18576864/table-name-as-parameter-in-hql
        return (ArrayList<T>) em.createQuery(getSelect() +" x", entity).getResultList();
    }

    public void add(T t){
        em.persist(t);
    }
    public void update(T t){
        em.merge(t);
    }
    public void delete(Integer id){
        em.remove(getByID(id));
    }
}
