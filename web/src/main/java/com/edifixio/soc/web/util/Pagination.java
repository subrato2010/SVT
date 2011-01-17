package com.edifixio.soc.web.util;

import java.util.List;

public interface Pagination {
	
	public int getPageSize();
	public int getCurrentPage();
	
	public List<?> getTotalList();
	public List<?> decorate(List<?> list);
	/**
	 * maximum pages to show in index list
	 * @return
	 */
	public int getMaxIndexPage();
}