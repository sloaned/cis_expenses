package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.ExpenseReportDao;
import com.outhreeit.quickrbooks.daos.IBaseDao;
import com.outhreeit.quickrbooks.daos.IExpenseReportDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ddelaney on 12/4/2015.
 */
@Service
public class ExpenseReportService extends BaseService<ExpenseReport> {

    @Autowired
    public ExpenseReportService(IExpenseReportDao dao) {
        super(dao);
    }
}
