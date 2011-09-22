// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.MsgDataCreationLog;

public interface MsgDataCreationLogDAO<T extends MsgDataCreationLog> {
    public List<T> findall()  throws SVTException;    
    public Date getMaxActionDate(String profileId) throws SVTException;
    public Date getMinActionDate(String profileId) throws SVTException;
    
}
