package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Currency;

/**
 * Created by gfisher on 12/3/2015.
 */
@Entity
public class LineItem extends BaseEntity {
    Currency datMoney;
    @OneToOne
    LineItemType type;
}
