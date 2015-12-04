package com.outhreeit.quickrbooks.webcontroller;

import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.services.ExpenseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/expense-report")
public class ExpenseWebController extends BaseController<ExpenseReport> {

    @Autowired
    public ExpenseWebController(ExpenseReportService service) {
        super(service);
    }
}
