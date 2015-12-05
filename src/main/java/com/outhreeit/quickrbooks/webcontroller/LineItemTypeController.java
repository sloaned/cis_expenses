package com.outhreeit.quickrbooks.webcontroller;

import com.outhreeit.quickrbooks.entities.LineItemType;
import com.outhreeit.quickrbooks.services.BaseService;
import com.outhreeit.quickrbooks.services.LineItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfisher on 12/4/2015.
 */
@RestController
@RequestMapping(value = "/line-item-types")
public class LineItemTypeController extends BaseController<LineItemType>{

    @Autowired
    public LineItemTypeController(LineItemTypeService service) {
        super(service);
    }
}
