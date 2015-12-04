package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by gfisher on 12/3/2015.
 */
@Entity
public class ExpenseReport extends BaseEntity {
    @ManyToMany
    Set<LineItem> lineItems;

    @OneToMany
    Usr usr;
}
