package com.edifixio.soc.web.util;

import java.util.List;

import com.edifixio.soc.web.controllers.BaseWebObject;

public class MakePagination extends BaseWebObject implements Pagination{
    
    private static final String NEAR_BY_LOC = "nearByLoc";
    private Paginator paginator = new Paginator(this);
    
    public List<?> decorate(List<?> list) {
        return list;
    }

    public int getCurrentPage() {
        int cp = 1;
        String strCurrentPage = getParameter("currentpage");
        if(strCurrentPage != null){
            cp = Integer.parseInt(strCurrentPage.trim());
        }
        return cp;
    }

    public int getMaxIndexPage() {
        return 4;
    }

    public int getPageSize() {
        return 4;
    }

    @SuppressWarnings("unchecked")
    public List<?> getTotalList() {
        List<String> list = null;
        try {
            list =  (List<String>)getObjSessionAttribute(NEAR_BY_LOC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Paginator getPaginator() {
        return paginator;
    }
}
