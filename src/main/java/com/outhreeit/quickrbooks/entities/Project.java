package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Project extends BaseEntity {
    @ManyToOne
    private User approver;

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

}
