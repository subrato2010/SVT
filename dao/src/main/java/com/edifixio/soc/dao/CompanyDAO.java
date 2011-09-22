// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Company;

public interface CompanyDAO<T extends Company> {
    public List<T> findall()  throws SVTException;
    public T add(Company company)  throws SVTException; 
    public T update(Company company)  throws SVTException;
    public Company getByName(String handlerName) throws SVTException; 
    public Company getById(String companyId) throws SVTException;  
    
}
