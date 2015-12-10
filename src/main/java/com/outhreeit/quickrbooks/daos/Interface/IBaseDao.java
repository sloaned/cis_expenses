package com.outhreeit.quickrbooks.daos.Interface;

import com.outhreeit.quickrbooks.entities.BaseEntity;

import java.util.List;

public interface IBaseDao<T extends BaseEntity> {
    void add(T t);
    void update(T t);
    void delete(Integer id);
    List<T> getAll();
    T getByID(Integer id);
    boolean doesNameExist(String name);
    T getByName(String name);
}
