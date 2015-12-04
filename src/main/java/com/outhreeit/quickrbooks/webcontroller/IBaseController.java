package com.outhreeit.quickrbooks.webcontroller;

import com.outhreeit.quickrbooks.entities.BaseEntity;

import java.util.List;


public interface IBaseController<T extends BaseEntity> {
    void add(T t);
    void update(T t);
    void delete(Integer id);
    List<T> getAll();
    T getByID(Integer id);
}
