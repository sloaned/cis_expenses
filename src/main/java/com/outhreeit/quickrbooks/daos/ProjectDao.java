package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.daos.Interface.IProjectDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class ProjectDao extends BaseDao<Project> implements IProjectDao {
    public ProjectDao() {
        super(Project.class);
    }

    public Project getByID(Integer id){
        Set<ExpenseReport> reports=  new HashSet<>(em.createQuery("Select e from ExpenseReport e join e.project p " +
            "where p.id = :id",ExpenseReport.class).setParameter("id",id).getResultList());
        Project p = super.getByID(id);
        p.setReports(reports);
        System.out.println(p);
        return p;
    }
}
