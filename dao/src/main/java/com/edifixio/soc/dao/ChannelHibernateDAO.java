// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Channel;


@SuppressWarnings("unchecked")
public class ChannelHibernateDAO<T extends Channel> extends BaseHibernateDAO<T>
        implements ChannelDAO {
    private static final Log log = LogFactory.getLog(ChannelHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("ChannelHibernateDAO.findall");
        List<T> t = find().order("this.displayOrder").list();
        return t;
    }

    public List findAllLightOnlyChannel() throws SVTException {
        log.debug("ChannelHibernateDAO.findall");
        List<T> t = find().and("this.channel=true").order("this.displayOrder").list();
        return t;
    }

    public Channel update(Channel channel) throws SVTException {
        if(channel == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(channel);
        transaction.commit();
        log.debug("Value saved successfully");
        return channel;
    }

    /**
     * {@inheritDoc}
     */
    public Channel addChannel(Channel channel) throws SVTException {
        log.debug("ChannelHibernateDAO.addChannel");
        Channel channel1 = save(channel);
        return channel1;
    }


    private Channel save(Channel channel) {
        if (channel == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(channel);
        transaction.commit();
        log.debug("Value saved successfully");
        return channel;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Channel.class;
    }


    /**
     * This method will return the channel based on channelId
     * 
     * @param id
     *            the ChannelId of the channel
     * @return Customer the customer object
     */
    public Channel getChannelById(String id) throws SVTException {
        log.debug("ChannelHibernateDAO.getChannelById");
        T channel = find().where("this.channelId=?", id).get();
        return channel;
    }


    public Channel getChannelByCode(String code) throws SVTException {
        log.debug("ChannelHibernateDAO.getChannelByCode");
        T channel = find().where("this.channelCode=?", code).get();
        return channel;
    }


    public Channel getChannelByName(String name) throws SVTException {
        log.debug("ChannelHibernateDAO.getChannelByName");
        T channel = find().where("this.channelName=?", name).get();
        return channel;
    }

}
