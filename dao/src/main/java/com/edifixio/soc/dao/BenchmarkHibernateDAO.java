// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Benchmark;


@SuppressWarnings("unchecked")
public class BenchmarkHibernateDAO<T extends Benchmark> extends
        BaseHibernateDAO<T> implements BenchmarkDAO {
    private static final Log log = LogFactory
            .getLog(BenchmarkHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("BenchMarkHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    public List findallActive() throws SVTException {
        List<T> t = find().where("this.activeStatus=true").listWithoutFiler();
        return t;
    }

    public Benchmark getById(String id) throws SVTException {
        T t = find().where("this.benchMarkId=?", id).and("this.activeStatus=true").get();
        return t;
    }

    public Benchmark getByIdOrLatest(String id) throws SVTException {
        T t = null;
        if(id == null){
           t = find().where("this.activeStatus=true").orderDescending("this.benchmarkStDate").first(); 
        }else{
            t = find().where("this.benchMarkId=?", id).and("this.activeStatus=true").get();
        }        
        return t;
    }
    
    public Benchmark getByName(String name) throws SVTException {
        T t = find().where("this.benchMarkName=?", name).and("this.activeStatus=true").get();
        return t;
    }

    /**
     * {@inheritDoc}
     */
    public Benchmark addBenchMark(Benchmark benchMark) throws SVTException {
        log.debug("BenchMarkHibernateDAO.addBenchMark");
        Benchmark benchMark1 = save(benchMark);
        return benchMark1;
    }


    private Benchmark save(Benchmark benchMark) {
        if (benchMark == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(benchMark);
        transaction.commit();
        log.debug("Value saved successfully");
        return benchMark;
    }


    public Benchmark update(Benchmark benchMark) throws SVTException {
        if(benchMark == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(benchMark);
        transaction.commit();
        log.debug("Value saved successfully");
        return benchMark;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Benchmark.class;
    }

}
