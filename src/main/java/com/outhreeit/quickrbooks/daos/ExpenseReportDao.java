package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.daos.Interface.IExpenseReportDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ddelaney on 12/4/2015.
 */
@Repository
public class ExpenseReportDao extends BaseDao<ExpenseReport> implements IExpenseReportDao {
    public ExpenseReportDao() {
        super(ExpenseReport.class);
    }

    public List<ExpenseReport> getAllByUser(String name) {
        Integer id = em.createQuery("SELECT u.id FROM User u WHERE u.name = :name", Integer.class)
                   .setParameter("name", name).getSingleResult();
        System.out.println(id);
        return em.createQuery("SELECT e From ExpenseReport e WHERE user_id = :id", ExpenseReport.class)
                 .setParameter("id", id).getResultList();
    }
}
