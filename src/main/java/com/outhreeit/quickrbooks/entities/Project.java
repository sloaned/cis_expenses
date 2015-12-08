package com.outhreeit.quickrbooks.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Project extends BaseEntity {

  @OneToMany
  private Set<ExpenseReport> reports;
  @ManyToOne
  private User approver;

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

}
