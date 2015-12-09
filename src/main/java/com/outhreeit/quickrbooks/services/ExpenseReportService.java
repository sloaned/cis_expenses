package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.ExpenseReportDao;
import com.outhreeit.quickrbooks.daos.IExpenseReportDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseReportService extends BaseService<ExpenseReport> {

    private IExpenseReportDao edao;

    @Autowired
    public ExpenseReportService(IExpenseReportDao dao) {
        super(dao);
        edao = dao;
    }

    public List<ExpenseReport> getAllByUser(Integer id) {
        return edao.getAllByUser(id);
    }

    @Override
    public void add(ExpenseReport expenseReport) {
        if (expenseReport.getProject() != null) {
            if (expenseReport.getProject().getId() == null) {
                expenseReport.setProject(null);
            }
        }
        super.add(expenseReport);
    }
}
