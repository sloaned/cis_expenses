package com.outhreeit.quickrbooks.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by gfisher on 12/3/2015.
 */
@Entity
public class ExpenseReport extends BaseEntity {
    @ManyToMany(cascade = CascadeType.ALL)
    Set<LineItem> lineItems;

    @ManyToOne(cascade = CascadeType.MERGE)
    User user;

    @ManyToOne
    Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
