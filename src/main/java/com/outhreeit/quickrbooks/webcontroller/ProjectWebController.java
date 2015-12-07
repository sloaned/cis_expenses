package com.outhreeit.quickrbooks.webcontroller;

import com.outhreeit.quickrbooks.entities.Project;
import com.outhreeit.quickrbooks.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/project")
public class ProjectWebController extends BaseController<Project> {

    @Autowired
    public ProjectWebController(ProjectService service) {
        super(service);
    }

}
