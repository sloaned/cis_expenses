package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.daos.Interface.IProjectDao;
import com.outhreeit.quickrbooks.entities.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProjectDao extends BaseDao<Project> implements IProjectDao {
    public ProjectDao() {
        super("Project", Project.class);
    }
}
