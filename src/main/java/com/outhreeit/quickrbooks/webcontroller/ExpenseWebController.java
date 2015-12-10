package com.outhreeit.quickrbooks.webcontroller;

import com.outhreeit.quickrbooks.entities.ExpenseReport;
import com.outhreeit.quickrbooks.entities.User;
import com.outhreeit.quickrbooks.services.ExpenseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/expense-report")
public class ExpenseWebController extends BaseController<ExpenseReport> {

    @Autowired
    public ExpenseWebController(ExpenseReportService service) {
        super(service);
    }

    @RequestMapping(params = {"userId"})
    public List<ExpenseReport> getAllByUser(@RequestParam("userId") Integer id) {
        return ((ExpenseReportService) service).getAllByUser(id);
    }
}
