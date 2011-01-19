// $Author: subratog $
package com.edifixio.soc.persist.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author subrato
 */
@SuppressWarnings("serial")
public class HibernateProperties extends java.util.Properties
{
   @SuppressWarnings("unused")
   private static final Log log = LogFactory.getLog(HibernateProperties.class);

   /**
    * @param s
    */
   public void setDialect(String s)
   {
      setProperty("hibernate.dialect", s);
   }

   /**
    * @param s
    */
   public void setShowSql(String s)
   {
      setProperty("hibernate.show_sql", s);
   }

   /**
    * @param s
    */
   public void setCacheProviderClass(String s)
   {
      setProperty("hibernate.cache.provider_class", s);
   }

   /**
    * @param s
    */
   public void setCglibUseReflectionOptimizer(String s)
   {
      setProperty("hibernate.cglib.use_reflection_optimizer", s);
   }
   
   /**
    * @param s
    */
   public void setJdbcUseStreamsForBinary(String s)
   {
      setProperty("hibernate.jdbc.use_streams_for_binary", s);
   }

   /**
    * @param s
    */
   public void setConnectionLogin(String s)
   {
      setProperty("hibernate.connection.login", s);
   }

   /**
    * @param s
    */
   public void setConnectionPassword(String s)
   {
      setProperty("hibernate.connection.password", s);
   }

   /**
    * @param s
    */
   public void setConnectionDriverClass(String s)
   {
      setProperty("hibernate.connection.driver_class", s);
   }

   /**
    * @param s
    */
   public void setConnectionProviderClass(String s)
   {
      setProperty("hibernate.connection.provider_class", s);
   }

   /**
    * @param s
    */
   public void setConnectionUrl(String s)
   {
      setProperty("hibernate.connection.url", s);
   }

   /**
    * @param s
    */
   public void setProxoolXml(String s)
   {
      setProperty("hibernate.proxool.xml", s);
   }

   /**
    * @param s
    */
   public void setProxoolPoolAlias(String s)
   {
      setProperty("hibernate.proxool.pool_alias", s);
   }

   /**
    * @param s
    */
   public void setDefaultSchema(String s)
   {
      setProperty("hibernate.default_schema", s);
   }

   public void setAutoCommit(String s)
   {
      // log.debug("setting hibernate.connection.autocommit to: " + s);
      setProperty("hibernate.connection.autocommit", s);
   }

   public void setMaxFetchDepth(String s)
   {
      setProperty("hibernate.max_fetch_depth", s);
   }

   public void setStatementCacheSize(String s)
   {
      setProperty("hibernate.statement_cache.size", s);
   }

   public void setConnectionPoolMaxSize(String s)
   {
      setProperty("hibernate.c3p0.max_size", s);
   }

   public void setConnectionPoolMinSize(String s)
   {
      setProperty("hibernate.c3p0.min_size", s);
   }

   public void setConnectionPoolIdleTestPeriod(String s)
   {
      setProperty("hibernate.c3p0.idle_test_period", s);
   }

   public void setConnectionPoolAcquireIncrement(String s)
   {
      setProperty("hibernate.c3p0.acquire_increment", s);
   }

   public void setConnectionPoolMaxStatements(String s)
   {
      setProperty("hibernate.c3p0.max_statements", s);
   }

   public void setConnectionPoolTimeout(String s)
   {
      setProperty("hibernate.c3p0.timeout", s);
   }
}
