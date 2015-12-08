package com.outhreeit.quickrbooks.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
