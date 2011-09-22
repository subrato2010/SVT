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
// $Revision: 1.2 $
// $Date: 2011/06/30 07:31:17 $
// $Source: /home/cvs/batissor/TWT/biz/src/main/java/com/edifixio/soc/biz/CategoryMgrImpl.java,v $

package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.CategoryDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Category;


public class CategoryMgrImpl extends BaseBizObject implements CategoryMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(CategoryMgrImpl.class);
    private ChannelMgr channelMgr;

    public List<CategoryDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getCategoryDTOList(getDaoProvider().getCategoryDAO().findall());
    }


    private List<CategoryDTO> getCategoryDTOList(List<Category> categories) {
        List<CategoryDTO> categoryDTOList = null;
        if (categories != null && categories.size() > 0) {
            categoryDTOList = new ArrayList<CategoryDTO>();
            for (Category category : categories) {
                categoryDTOList.add(getCategoryDTO(category));
            }
        }
        return categoryDTOList;
    }


    /**
     * @param category
     * @return CategoryDTO object
     */
    private CategoryDTO getCategoryDTO(Category category) {
        CategoryDTO categoryDTO = null;
        if (category != null) {
            categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryCode(category.getCategoryCode());
            categoryDTO.setCategoryDesc(category.getCategoryDesc());
            
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTO.setDisplayOrder(category.getDisplayOrder());
            categoryDTO.setActiveStatus(category.isActiveStatus());
        }
        return categoryDTO;
    }


    public ChannelMgr getChannelMgr() {
        return channelMgr;
    }


    public void setChannelMgr(ChannelMgr channelMgr) {
        this.channelMgr = channelMgr;
    }
}
