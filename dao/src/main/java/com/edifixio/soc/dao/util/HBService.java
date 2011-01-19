// $Author: subratog $
package com.edifixio.soc.dao.util;


import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class HBService {
    
    /** Logger */
    private static final Log log = LogFactory.getLog(HBService.class);    
		private static HBService hBService ;
		
        private static final ThreadLocal session = new ThreadLocal();
		private static final SessionFactory sessionFactory;

        private static HashMap<String, SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
        public static final ThreadLocal sessionMapsThreadLocal = new ThreadLocal();
    
	    static {
	        try {
	            // Create the SessionFactory
	            sessionFactory = new Configuration().configure().buildSessionFactory();
	            buildSessionFactory();
            } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            log.error("Initial SessionFactory creation failed.", ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static Session currentSession() throws HibernateException {
	        Session s = (Session) session.get();
	        // Open a new Session, if this Thread has none yet
	        if (s == null) {
	            s = sessionFactory.openSession();
	            session.set(s);
	        }
	        return s;
	    }
	    
	    public static void closeSession() throws HibernateException {
	        Session s = (Session) session.get();
	        session.set(null);
	        if (s != null)
	            s.close();
	    }    
	
		private HBService(){
		}
////////////////////////////////////////////////////////////////////////////////////////
        public static Session currentSession(String key) throws HibernateException {

            //HBService.class.getResource("");
            
            HashMap<String, Session> sessionMaps = (HashMap<String, Session>) sessionMapsThreadLocal.get();

            if (sessionMaps == null) {
                sessionMaps = new HashMap();
                sessionMapsThreadLocal.set(sessionMaps);
            }

            // Open a new Session, if this Thread has none yet
            Session s = (Session) sessionMaps.get(key);
             if (s == null) {
                s = ((SessionFactory) sessionFactoryMap.get(key)).openSession();
                //s.setFlushMode(FlushMode.ALWAYS);
                sessionMaps.put(key, s);
            }
             s.clear();
            return s;
        }

        public static void closeSessions() throws HibernateException {
            HashMap<String, Session> sessionMaps = (HashMap<String, Session>) sessionMapsThreadLocal.get();
            sessionMapsThreadLocal.set(null);
            if (sessionMaps != null) {
                for (Session session : sessionMaps.values()) {
                    if (session.isOpen())
                        session.close();
                };
            }
        }

        public static void buildSessionFactory() {
            try {
                // Create the SessionFactory
                Properties pro = load("database.properties");
                Enumeration em = pro.keys();
                while(em.hasMoreElements()){
                    String key = (String)em.nextElement();
                    SessionFactory sessionFactory = new Configuration().configure(pro.get(key).toString()).buildSessionFactory();
                    sessionFactoryMap.put(key, sessionFactory);
                }

            } catch (Throwable ex) {

                log.error("Initial SessionFactory creation failed.", ex);
                throw new ExceptionInInitializerError(ex);

            } // end of the try - catch block
        }

////////////////////////////////////////////////////////////////////////////////////////
        
		public static synchronized HBService getHBService(){
            if(hBService == null){
                hBService = new HBService();
            }
            return hBService;
        }
		
		public void saveOrUpdate(Object object) throws Exception{
			Session session = currentSession();
			if(session != null){
			    Transaction transaction = session.beginTransaction();
	            session.saveOrUpdate(object);
	            transaction.commit();
	            session.close();
			}
		}
		
		public void deleteObject(Object obj){
		    Session session = currentSession();
            if(session != null){
                Transaction transaction = session.beginTransaction();
                session.delete(obj);
                transaction.commit();
                session.close();
            }
	    }
	    
	    public void findById(String id){
	        Session session = currentSession();
            if(session != null){
                Transaction transaction = session.beginTransaction();
                transaction.commit();
                session.close();    
            }	        
	    }
        
        /**
         * Load a properties file from the classpath
         * @param propsName
         * @return Properties
         * @throws Exception
         */
        public static Properties load(String propsName) throws Exception {
            Properties props = new Properties();
            //URL url = ClassLoader.getSystemResource(propsName);
            ClassLoader  classLoader = Thread.currentThread().getContextClassLoader();
            URL url = classLoader.getResource(propsName);
            props.load(url.openStream());
            return props;
        }

		
}
