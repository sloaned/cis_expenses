package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.Interface.IProjectDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.LineItem;
import com.outhreeit.quickrbooks.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectService extends BaseService<Project> {

    @Autowired
    public ProjectService(IProjectDao dao) {
        super(dao);
    }

}
