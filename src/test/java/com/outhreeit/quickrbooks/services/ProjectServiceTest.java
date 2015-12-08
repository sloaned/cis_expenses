package com.outhreeit.quickrbooks.services;

import com.outhreeit.quickrbooks.daos.ProjectDao;
import com.outhreeit.quickrbooks.entities.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * Created by scha on 12/7/2015.
 */
public class ProjectServiceTest {
    private ProjectService service;
    private ProjectDao mockProjectDao;

    @Before
    public void setup(){
        mockProjectDao = mock(ProjectDao.class);
        service = new ProjectService(mockProjectDao);
    }

    @Test
    public void addTest(){
        service.add(null);
        verify(mockProjectDao, times(1)).add(null);
    }

    @Test
    public void updateTest(){
        service.update(null);
        verify(mockProjectDao, times(1)).update(null);
    }

    @Test
    public void deleteTest(){
        service.delete(null);
        verify(mockProjectDao, times(1)).delete(null);
    }

    @Test
    public void getByIdTest(){
        service.getByID(1);
        verify(mockProjectDao, times(1)).getByID(any());
    }

    @Test
    public void getAllTest(){
        int expected = 2;
        List<Project> projects = projectList();
        when(mockProjectDao.getAll()).thenReturn((ArrayList)projects);
        List<Project> actual = service.getAll();
        assertEquals(expected, actual.size());
    }

    private List<Project> projectList() {
        List<Project> projects = new ArrayList<>();
        Project project = new Project();
        projects.add(project);
        project = new Project();
        projects.add(project);
        return projects;
    }

}