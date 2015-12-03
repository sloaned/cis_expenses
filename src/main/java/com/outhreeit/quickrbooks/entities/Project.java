package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;

/**
 * Created by g on 12/3/15.
 */
@Entity
public class Project extends BaseEntity {
    private Set<Expense> reports;


}
