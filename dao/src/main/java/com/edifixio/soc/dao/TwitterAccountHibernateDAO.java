// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.TwitterAccount;


@SuppressWarnings("unchecked")
public class TwitterAccountHibernateDAO<T extends TwitterAccount> extends BaseHibernateDAO<T>
        implements TwitterAccountDAO {
    private static final Log log = LogFactory.getLog(TwitterAccountHibernateDAO.class);

    /**
     * Returns all the TwitterAccount
     * <p>
     * 
     * @return List of TwitterAccounts
     */
    public List findall() {
        log.debug("TwitterAccountHibernateDAO.findall");
        List<T> t = find().list();
        
        return t;
    }

    public TwitterAccount getTwitterAccountById(String id) throws SVTException {
        log.debug("TwitterAccountHibernateDAO.getTwitterAccountById");
        T twitterAccount = find().where("this.twitterAccountId=?", id).get();
        return twitterAccount;
    }

    public List getByProfilePreferenceId(String id) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profilePrefrenceId=?", id).orderAscending("this.twitterAccountId").list();
        return twitterAccount;
    }
    

    public List getByProfilePreferenceIdNOTSELF(String id) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profilePrefrenceId=?", id).and("this.self=false").list();
        return twitterAccount;
    }

    public List getByProfilePreferenceIdCompIdNOTSELF(String id, String companyId) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profilePrefrenceId=?", id).and("this.company.companyId=?", companyId).and("this.self=false").list();
        return twitterAccount;
    }
    
    public List getByProfilePreferenceIdSELF(String id) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profilePrefrenceId=?", id).and("this.self=true").list();
        return twitterAccount;
    }

    public List getByProfileUserIdNOTSELF(String id) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profileUserId=?", id).and("this.self=false").list();
        return twitterAccount;
    }

    public List getByProfileUserIdCompIdNOTSELF(String id, String companyId) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profileUserId=?", id).and("this.company.companyId=?", companyId).and("this.self=false").list();
        return twitterAccount;
    }
    
    public List getByProfileUserIdSELF(String id) throws SVTException {
        List<T> twitterAccount = find().where("this.profilePreference.profileUserId=?", id).and("this.self=true").list();
        return twitterAccount;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return TwitterAccount.class;
    }


}
