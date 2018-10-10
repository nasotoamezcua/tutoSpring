package com.nasoto.tiendavirtual.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.nasoto.tiendavirtual.dao.api.ICustomerDAO;
import com.nasoto.tiendavirtual.dao.hibernate.api.GenericHibernateDAO;
import com.nasoto.tiendavirtual.entities.Customer;

@Repository("customerHibernateDAO")
public class CustomerHibernateDAO extends GenericHibernateDAO<Customer, Long> 
	implements ICustomerDAO {

}
