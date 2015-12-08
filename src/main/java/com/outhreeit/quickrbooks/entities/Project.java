package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Project extends BaseEntity {

  public Set<ExpenseReport> getReports() {
    return reports;
  }

  public void setReports(Set<ExpenseReport> reports) {
    this.reports = reports;
  }

  @Transient
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
