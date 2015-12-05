package com.outhreeit.quickrbooks.daos;

import com.outhreeit.quickrbooks.entities.LineItemType;
import org.springframework.stereotype.Repository;

/**
 * Created by gfisher on 12/4/2015.
 */
@Repository
public class LineItemTypeDao extends BaseDao<LineItemType> implements ILineItemTypeDao {
    public LineItemTypeDao() {
        super(LineItemType.class);
    }
}
