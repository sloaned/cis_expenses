package com.outhreeit.quickrbooks.webcontroller;

import com.outhreeit.quickrbooks.entities.Project;
import com.outhreeit.quickrbooks.services.BaseService;
import com.outhreeit.quickrbooks.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectWebController extends BaseController<Project> {

    @Autowired
    public ProjectWebController(ProjectService service) {
        super(service);
    }
/*
    @RequestMapping(value="/project/create", method= RequestMethod.POST)
    public Project add(@RequestBody Project project) {
        project.setId(1);
        System.out.println(project.getName());
        return project;
    }

    @RequestMapping(value="/project/get", method= RequestMethod.GET)
    public List<Project> get() {
        List<Project> projects = new ArrayList<>();
        Project project1 = new Project();
        Project project2 = new Project();
        project1.setId(25);
        project1.setName("Project 1");
        project2.setId(34);
        project2.setName("Project 2");
        projects.add(project1);
        projects.add(project2);
        return projects;
    }*/

}
