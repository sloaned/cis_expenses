package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.Interface.IProjectDao;
import com.outhreeit.quickrbooks.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends BaseService<Project> {

    @Autowired
    public ProjectService(IProjectDao dao) {
        super(dao);
    }

}
