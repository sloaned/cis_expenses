package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.IBaseDao;
import com.outhreeit.quickrbooks.entities.BaseEntity;

import java.util.List;

/**
 * Created by gfisher on 12/3/15.
 */

public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {
    protected IBaseDao dao;

    public BaseService(IBaseDao dao) {
        this.dao = dao;
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    public void add(T t) {
        dao.add(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }

    public BaseService() {

    }

    public T getByID(Integer id){
        return (T) dao.getByID(id);
    }
}
