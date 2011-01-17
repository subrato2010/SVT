package com.edifixio.soc.batch;

import twitter4j.TwitterException;
import com.edifixio.soc.biz.BaseMgr;
import com.edifixio.soc.common.SVTException;

public interface TwitterMgr extends BaseMgr{
    
    public String callTwitterAPI() throws SVTException, TwitterException;
    
    
}
