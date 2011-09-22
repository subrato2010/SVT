package com.edifixio.soc.web.util;

import java.util.ArrayList;
import java.util.List;

public class Paginator {
	private Pagination pagination;
	
	public Paginator(Pagination pagination){
		this.pagination = pagination;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<?> getCurrentList(){
	    List<?> list = new ArrayList<String>();
	    try {
	        list = getCurrentPageList();
	        list = this.pagination.decorate(list);
	    } catch (Exception e) {
        }
	    return list;
	}
	
	public int getTotalPageCount(){
		int totalPage = 0;
		int itemCount = pagination.getTotalList().size();
		int size = pagination.getPageSize();
		if(itemCount == 0 || size == 0)
			return 0;
		totalPage = itemCount / size;
		int remainder = itemCount % size;
		if(remainder > 0)
			totalPage = totalPage + 1;
		
		return totalPage;
		
	}
	 
	public int getBegnningIndex(){
	    return getFromIndex() + 1;
	}
	public int getEndIndex(){
	    return getToIndex();
	}
	public int getTotalListCount(){
        int count = 0;
        if(pagination.getTotalList() != null)
            count =   pagination.getTotalList().size();
        return count;
    }
    
    
    public Integer[] getPageIndexes(){
        int cp = pagination.getCurrentPage();
        int lp = getLastPage();
        int tp = getTotalPageCount();
        int mp = pagination.getMaxIndexPage();
        
        System.out.println("cp=" + cp + " lp=" + lp + " tp=" + tp);
       
        int pageCount = (mp < tp)? mp : tp;
        Integer[] indexArray = new Integer[pageCount];
        if(cp <= pageCount)
        { 
            for(int i=0; i<pageCount; i++){
                indexArray[i] = i+1;
            }
        }else{
            //when current greater that max page
            for(int i = 0; i<pageCount; i++){
                indexArray[i] = cp - pageCount + i + 1;
            }
        }
        
        return indexArray;
    }
    
    public boolean isNextPossible(){
        int cp = pagination.getCurrentPage();
        int lp = getLastPage();
        if(cp != lp){
               return true;
        }else
            return false;
        
    }
    
    public boolean isPreviousPossible(){
        int cp = pagination.getCurrentPage();
        if(cp > 1 ){
               return true;
        }else
            return false;
    }
	private int getFromIndex(){
	    int pageSize  = pagination.getPageSize();
        int currentPage = pagination.getCurrentPage();
        int lastPage = getLastPage();
        
        //handle external page param tamparing
        if(currentPage > lastPage)
            currentPage = lastPage;
        
        if(currentPage < 1)
            currentPage = 1;
	    return (currentPage - 1)* pageSize;
	}
	
	private int getToIndex()
	{
	    int pageSize  = pagination.getPageSize();
        int currentPage = pagination.getCurrentPage();
        int lastPage = getLastPage();
        
        //handle external page param tamparing
        if(currentPage > lastPage)
            currentPage = lastPage;
        
        if(currentPage < 1)
            currentPage = 1;
        List<?> totalList = pagination.getTotalList();
        int toIndex = currentPage * pageSize;
        if(toIndex > totalList.size()) {
            toIndex = totalList.size();
        }
        return toIndex;
    }
	private List<?> getCurrentPageList()
    {
        List<?> list = null;
                
        int fromIndex = getFromIndex();
        int toIndex = getToIndex();
         List<?> totalList = pagination.getTotalList();
        list = totalList.subList(fromIndex, toIndex);
        
        return list;
    }
    
    private int getLastPage()
    {
        int i = pagination.getTotalList().size()/pagination.getPageSize();
        int r = pagination.getTotalList().size()%pagination.getPageSize();
        if(r > 0)
            i = i+1;
        
        return i;
    }
	
	
	
}
