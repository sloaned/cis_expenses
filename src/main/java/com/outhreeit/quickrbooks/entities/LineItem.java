package com.outhreeit.quickrbooks.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by gfisher on 12/3/2015.
 */
@Entity
public class LineItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    BigDecimal datMoney;

    @ManyToOne
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
}
