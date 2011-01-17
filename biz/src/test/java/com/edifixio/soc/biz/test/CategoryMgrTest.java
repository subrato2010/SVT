//
//                               EDIFIXIO.
//                     Confidential and Proprietary
//                         ALL RIGHTS RESERVED.
//
//      This software is provided under license and may be used
//      or distributed only in accordance with the terms of
//      such license.
//

// History: Date        By whom   what
//          30-03-2010  Himadri   Created 

// CVS version control block - do not edit manually
// $Author: subratog $
// $Revision: 1.1 $
// $Date: 2010/11/17 11:37:47 $
// $Source: /home/cvs/batissor/TWT/biz/src/test/java/com/edifixio/soc/biz/test/CategoryMgrTest.java,v $

package com.edifixio.soc.biz.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.CategoryDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;

public class CategoryMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(CategoryMgrTest.class);

    public void testCategoryFindAll() throws SVTException {
        log.debug("CategoryMgrTest.testCategoryFindAll");
        List<CategoryDTO> dtos = getCategoryMgr().findAll();
        for (CategoryDTO dto : dtos) {
            log.debug("=========================================================");
            log.debug("Category Code   : "+ dto.getCategoryCode());
            log.debug("Category Name   : "+ dto.getCategoryName());
        }
    }
}
