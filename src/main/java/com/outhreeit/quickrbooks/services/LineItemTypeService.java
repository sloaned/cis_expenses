package com.outhreeit.quickrbooks.services;
import com.outhreeit.quickrbooks.daos.ILineItemTypeDao;
import com.outhreeit.quickrbooks.entities.LineItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gfisher on 12/4/2015.
 */
@Service
public class LineItemTypeService extends BaseService<LineItemType> {

    @Autowired
    public LineItemTypeService(ILineItemTypeDao dao) {
        super(dao);
    }
}
