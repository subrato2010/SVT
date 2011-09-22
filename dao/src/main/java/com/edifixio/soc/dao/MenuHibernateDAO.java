// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Menu;


@SuppressWarnings("unchecked")
public class MenuHibernateDAO<T extends Menu> extends
        BaseHibernateDAO<T> implements MenuDAO {
    private static final Log log = LogFactory
            .getLog(MenuHibernateDAO.class);

    public List findall() {
        List<T> t = find().list();
        return t;
    }

    public Menu getById(String id) throws SVTException {
        T category = find().where("this.menuId=?", id).get();
        return category;
    }    
    
    public List findByRoleId(String roleId) throws SVTException {
        List<T> roles = find().where("this.role.roleId=?", roleId).list();
        return roles;
    }

    public List findByRoleId(String roleId, String menuCode) throws SVTException {
        List<T> roles = find().where("this.role.roleId=?", roleId).and("this.menuCode=?", menuCode).list();
        return roles;
    }

    public List findByRoleIdAccountOption(String roleId) throws SVTException {
        List<T> roles = find().where("this.role.roleId=?", roleId).and("this.menuCode='1'").list();
        return roles;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Menu.class;
    }
}
