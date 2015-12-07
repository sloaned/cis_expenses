package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class Project extends BaseEntity {

  @OneToMany
  private Set<ExpenseReport> reports;
  @OneToOne
  private User approver;

  public Set<ExpenseReport> getReports() {
    return reports;
  }

  public void setReports(Set<ExpenseReport> reports) {
    this.reports = reports;
  }



    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }


}
