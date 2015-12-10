package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.entities.ExpenseReport;

import java.util.List;

/**
 * Created by ddelaney on 12/4/2015.
 */
public interface IExpenseReportDao extends IBaseDao<ExpenseReport> {
    List<ExpenseReport> getAllByUser(Integer id);
}
