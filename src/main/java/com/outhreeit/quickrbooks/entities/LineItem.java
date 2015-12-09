package com.outhreeit.quickrbooks.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class LineItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    BigDecimal datMoney;

    @ManyToOne(cascade = CascadeType.MERGE)
    LineItemType type;

    public Integer getId() {
        return id;
    }

    public LineItemType getType() {
        return type;
    }

    public void setType(LineItemType type) {
        this.type = type;
    }

    public BigDecimal getDatMoney() {
        return datMoney;
    }

    public void setDatMoney(BigDecimal datMoney) {
        this.datMoney = datMoney;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", datMoney=" + datMoney +
                ", type=" + type +
                '}';
    }
}
