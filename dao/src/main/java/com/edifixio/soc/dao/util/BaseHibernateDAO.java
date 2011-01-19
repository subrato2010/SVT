// $Author: subratog $
package com.edifixio.soc.dao.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edifixio.soc.persist.TrackedEntity;

public abstract class BaseHibernateDAO <T extends TrackedEntity> extends HibernateDaoSupport{
    private static final Log log = LogFactory.getLog(BaseHibernateDAO.class);

    abstract protected Class<?> getConcreteClass();
    
    private String benchmarkId;

    protected enum StatementType {
       STATEMENT_ONLY,
       ORDERED_PARAMS,
       NAMED_PARAMS
    }
    
    protected Find<T> find() {
        return new Find<T>(getConcreteClass());
        //return new Find<T>(getConcreteClass());
    }

    protected class Find<TT> {
        protected StringBuilder orderBy;
        protected String primary;
        protected int maxRows = 0;
        protected int startRow = 0;
        protected String select;
        protected int args = 0;
        protected boolean emptyWithoutWhere = false;
        protected boolean forceEmpty = false;
        protected List<String> tables = new ArrayList<String>();
        protected List<String> joins = new ArrayList<String>();
        protected List<String> wheres = new ArrayList<String>();
        protected List<String> names = new ArrayList<String>();
        protected List<Object> values = new ArrayList<Object>();
        

        @SuppressWarnings("unchecked")
        public Find(Class clazz)
        {
           this.tables.add(clazz.getName() + " this");
           this.primary = clazz.getName();
           this.select = "this";
        }
        
        @SuppressWarnings("unchecked")
        public Find(Class clazz, String name)
        {
           this.tables.add(clazz.getName() + " " + name);
           this.primary = clazz.getName();
           this.select = name;
        }
        
        public Find<TT> order(String attribute)
        {
           if (this.orderBy == null) {
              this.orderBy = new StringBuilder();
              this.orderBy.append(attribute);
           } else {
              int index = this.orderBy.lastIndexOf(" asc");
              int insert = this.orderBy.length();
              boolean eatDirection = false;
              if (index == insert - 4) {
                 insert = index;
                 eatDirection = true;
              } else {
                 index = this.orderBy.lastIndexOf(" desc");
                 if (index == insert - 5) {
                    insert = index;
                    eatDirection = true;
                 }
              }
              this.orderBy.insert(insert, ", ");
              if (eatDirection) {
                 index = attribute.lastIndexOf(" asc");
                 if (index != attribute.length() - 4) {
                    index = attribute.lastIndexOf(" desc");
                    if (index != attribute.length() - 5) {
                       index = attribute.length();
                    }
                 }
                 this.orderBy.insert(insert + 2, attribute.substring(0, index));
              }
              else {
                 this.orderBy.append(attribute);
              }
           }
           return this;
        }
        
        public Find<TT> orderAscending(String attribute)
        {
           return order(attribute + " asc");
        }
        
        public Find<TT> orderDescending(String attribute)
        {
           return order(attribute + " desc");
        }

        public Find<TT> withoutOrder()
        {
           this.orderBy = null;
           return this;
        }
                
        public Find<TT> where(String where)
        {
           if (where != null) {
              this.wheres.add(" " + where);
           }
           return this;
        }
               
        public Find<TT> where(String where, Object param)
        {
           if (where != null) {
              where(where).param(param);
           }
           return this;
        }
        public Find<TT> and(String where)
        {
           if (where != null && !isEmpty()) {
              this.wheres.add(" and " + where);
           }
           else {
              where(where);
           }
           return this;
        }
               
        public Find<TT> and(String where, Object param)
        {
           if (where != null) {
              and(where).param(param);
           }
           return this;
        }

        public Find<TT> andIfNotNull(String where, Object param)
        {
           if (param != null) {
              and(where, param);
           }
           return this;
        }
        
        public Find<TT> or(String where)
        {
           if (where != null) {
              this.wheres.add(" or " + where);
           }
           return this;
        }
        
        public Find<TT> param(Object thing)
        {
           if (getType().equals(StatementType.NAMED_PARAMS)) {
           }
           this.values.add(thing);
           return this;
        }
        
        protected String getSelect()
        {
           return this.select;
        }
        
        public boolean isEmpty()
        {
           return this.wheres.size() == 0;
        }
        
         public StatementType getType()
        {
           if (this.names.size() > 0) {
              return StatementType.NAMED_PARAMS;
           }
           if (this.values.size() > 0) {
              return StatementType.ORDERED_PARAMS;
           }
           return StatementType.STATEMENT_ONLY;
        }
        
        @Override
        public String toString()
        {
           return toObjectHQL();
        }

        private String toObjectHQL()
        {
           addFilterToHQL();
           StringBuilder query = toHQL();
           query.insert(0, "select " + getSelect());
           return query.toString();
        }

        private String toOrderedHQL()
        {
           addFilterToHQL();            
           return toOrderedHQL1();
        }

        private String toOrderedHQL1() {
            StringBuilder query = toHQL1();
               query.insert(0, "select " + getSelect());
               if (this.orderBy != null) {
                  query.append(" order by ").append(this.orderBy);
               }
               return query.toString();
        }

        private StringBuilder toHQL()
        {
           addFilterToHQL();
           return toHQL1();
        }

        private StringBuilder toHQL1() {
            StringBuilder query = new StringBuilder();
               query.append(" from ");
               for (String table: this.tables) {
                  query.append(table);
               }
               for (String join: this.joins) {
                  query.append(join);
               }
               if (this.wheres.size() > 0) {
                  query.append(" where");
                  for (String where: this.wheres) {
                     query.append(where);
                  }
               }
               return query;
        }
 
        private void addFilterToHQL() {
            
        }
        
        public List<String> getNames()
        {
           return this.names;
        }
        
        public List<Object> getValues()
        {
           return this.values;
        }
        
        @SuppressWarnings("unchecked")
        public T get()
        {
           if (isEmpty() || this.forceEmpty) {
              return null;
           }
           Query q = getCurrentSession("subrato").createQuery(toObjectHQL());
           log.debug("Query done");
           return (T) applyParameters(q).uniqueResult();
        }

        @SuppressWarnings("unchecked")
        public T first()
        {
           if (isEmpty() || this.forceEmpty) {
              return null;
           }
           Query q = getCurrentSession("subrato").createQuery(toOrderedHQL());
           List<T> results = applyParameters(q).setMaxResults(1).list();
           if (results.size() > 0) {
              return results.get(0);
           }
           return null;
        }
        
        @SuppressWarnings("unchecked")
        public List<T> list()
        {
           if ((this.emptyWithoutWhere && isEmpty()) || this.forceEmpty) {
              return new ArrayList<T>();
           }

           Query q = getCurrentSession("subrato").createQuery(toOrderedHQL());
           return applyParameters(applyLimits(q)).list();
        }
       
        private Query applyLimits(Query q)
        {
           if (this.maxRows > 0) {
              q = q.setMaxResults(this.maxRows);
           }
           q = q.setFirstResult(this.startRow);
           return q;
        }

        private Query applyParameters(Query q)
        {
           if (getType().equals(StatementType.ORDERED_PARAMS)) {
              int arg = 0;
              for (Object value: getValues()) {
                 if (value instanceof Collection) {
                    log.error("Collection parameters must be named");
                    throw new IllegalArgumentException();
                 }
                 else if (value instanceof Object[]) {
                    log.error("Array parameters must be named");
                    throw new IllegalArgumentException();
                 }
                 else {
                    q.setParameter(arg++, value);
                 }
              }
           }
           else if (getType().equals(StatementType.NAMED_PARAMS)) {
              for (int arg = 0; arg < names.size(); arg++) {
                 if (values.get(arg) instanceof Collection) {
                    q.setParameterList(names.get(arg), (Collection) values.get(arg));
                 }
                 else if (values.get(arg) instanceof Object[]) {
                    q.setParameterList(names.get(arg), (Object[]) values.get(arg));
                 }
                 else {
                    q.setParameter(names.get(arg), values.get(arg));
                 }
              }
           }
           return q;
        }
        
        protected String getOrderBy()
        {
           return "this.created";
        }
     }
                
     protected Session getCurrentSession(String schemaName) {
         return HBService.currentSession(schemaName);
     }
  
    public String getBenchmarkId() {
        return benchmarkId;
    }
    
    public void setBenchmarkId(String benchmarkId) {
        this.benchmarkId = benchmarkId;
    }

  
}
