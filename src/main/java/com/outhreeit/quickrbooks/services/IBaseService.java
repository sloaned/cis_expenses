package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.entities.BaseEntity;

import java.util.List;

public interface IBaseService<T extends BaseEntity> {
    void add(T t);
    void update(T t);
    void delete(Integer id);
    List<T> getAll();
    T getByID(Integer id);
}
