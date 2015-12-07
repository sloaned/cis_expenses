package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.entities.Project;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;


import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by scha on 12/7/2015.
 */
public class ProjectDaoTest {
    private EntityManager mockEm;
    private ProjectDao dao;

    @Before
    public void setup() {
        dao = new ProjectDao();
        mockEm = mock(EntityManager.class);
        dao.setEm(mockEm);
    }

    @Test
    public void getAllTest() {
        ArrayList<Project> expected = new ArrayList<>();
        TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(expected);
        dao.getAll();
        verify(mockTypedQuery, times(1)).getResultList();

    }
}