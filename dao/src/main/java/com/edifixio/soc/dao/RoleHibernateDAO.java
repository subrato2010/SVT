// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Role;


@SuppressWarnings("unchecked")
public class RoleHibernateDAO<T extends Role> extends
        BaseHibernateDAO<T> implements RoleDAO {
    private static final Log log = LogFactory
            .getLog(RoleHibernateDAO.class);

    public List findall() {
        List<T> t = find().list();
        return t;
    }

    public Role getById(String id) throws SVTException {
        T role = find().where("this.roleId=?", id).get();
        return role;
    }    

    public Role getAdminRole() throws SVTException {
        T role = find().where("this.roleName='ADMIN'").get();
        return role;
    }

    public Role getUserRole() throws SVTException {
        T role = find().where("this.roleName='USER'").get();
        return role;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Role.class;
    }

}
