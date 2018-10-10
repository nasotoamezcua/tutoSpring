package com.nasoto.tiendavirtual.dao.hibernate.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IOrderDAO;
import com.nasoto.tiendavirtual.dao.hibernate.api.GenericHibernateDAO;
import com.nasoto.tiendavirtual.entities.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("orderHibernateDAO")
public class OrderHibernateDAO extends GenericHibernateDAO<Order, Long> 
	implements IOrderDAO {
	
	/**
	 * Muestra las ordenes por customer.id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderFindByIdCustomer(Long idCustomer) throws PersistenceException {
		
		List<Order> listOrders = null;
		
		try{
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(Order.class)
					.add(Restrictions.eq("customer.Id", idCustomer))
					.addOrder(org.hibernate.criterion.Order.asc("id"));
			
			listOrders = c.list();
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return listOrders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderCustomerByUserId(Long idUser) throws PersistenceException {
		List<Order> listOrders = null;
		
		try{
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(Order.class)
					.createAlias("customer", "c")
					.add(Restrictions.eq("user.id", idUser))
					.addOrder(org.hibernate.criterion.Order.asc("id"));
			
			listOrders = c.list();
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		
		return listOrders;
	}

}
