package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.entities.BaseEntity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

/**
 * Created by g on 12/3/15.
 */
@Transactional
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class BaseDao<T extends BaseEntity> implements IBaseDao<T>{

    public BaseDao(String table, Class<T> entity) {
        this.table = table;
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
