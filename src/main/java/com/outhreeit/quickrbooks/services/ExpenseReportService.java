package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.Interface.IExpenseReportDao;
import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.LineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseReportService extends BaseService<ExpenseReport> {

    private IExpenseReportDao edao;

    @Autowired
    public ExpenseReportService(IExpenseReportDao dao) {
        super(dao);
        edao = dao;
    }

    public List<ExpenseReport> getAllByUser(String name) {
        return edao.getAllByUser(name);
    }

    @Override
    public void add(ExpenseReport expenseReport) {
        if (expenseReport.getProject() != null) {
            if (expenseReport.getProject().getId() == null) {
                expenseReport.setProject(null);
            }
        }
        ArrayList<LineItem> list = new ArrayList<>(expenseReport.getLineItems());
        //LineItem[] list = (LineItem[]) expenseReport.getLineItems().toArray();
        int size = list.size();
        boolean dupe = false;
        for (int i = 0; i < size; i++) {
            LineItem item = list.get(i);
            //System.out.println(item.getType().getId());
            for (int j = i + 1; j < size; j++) {
                System.out.println(item.getType().getId());
                System.out.println(list.get(j).getType().getId());
                if (item.getType().getId().equals(list.get(j).getType().getId())) {
                    dupe = true;
                    break;
                }
            }
            if (dupe)
                break;
        }
        if (dupe)
            throw new RuntimeException("No dupes allowed");
        super.add(expenseReport);
    }
}
