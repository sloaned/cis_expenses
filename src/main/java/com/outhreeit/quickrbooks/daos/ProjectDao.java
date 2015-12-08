package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.daos.Interface.IProjectDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public class ProjectDao extends BaseDao<Project> implements IProjectDao {
    public ProjectDao() {
        super(Project.class);
    }

    public Project getByID(Integer id){
        Set<ExpenseReport> reports= (Set<ExpenseReport>) em.createQuery("Select e from ExpenseReport e join Project p on p.id = e.project_id" +
            "where e.project_id = :id").setParameter("id",id).getResultList();
        Project p = super.getByID(id);
        p.setReports(reports);
        return p;
    }
}
