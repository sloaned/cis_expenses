package com.outhreeit.quickrbooks.daos;

import java.util.List;

import com.outhreeit.quickrbooks.entities.Username;

public interface IUserTestDao {
	void add(Username t);
    void update(Username t);
    void delete(Integer id);
    List<Username> getAll();
    Username getByID(Integer id);
    boolean doesNameExist(String name);
}
