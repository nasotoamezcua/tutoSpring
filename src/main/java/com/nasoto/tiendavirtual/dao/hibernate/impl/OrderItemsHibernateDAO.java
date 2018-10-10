package com.nasoto.tiendavirtual.dao.hibernate.impl;

import java.util.List;

//import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IOrderItemsDAO;
import com.nasoto.tiendavirtual.dao.hibernate.api.GenericHibernateDAO;
import com.nasoto.tiendavirtual.entities.OrderItems;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("orderItemsHibernateDAO")
public class OrderItemsHibernateDAO extends GenericHibernateDAO<OrderItems, Long> 
	implements IOrderItemsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItems> getOrderItemsFindByIdOrder(Long idOrder) throws PersistenceException {		
		
		/* LOS DOS FUNCIONAN IGUAL
		String hql	=	"	SELECT distinct o" + 	
						"	FROM OrderItems o" + 
						"		JOIN FETCH o.productInfo p" + 
						"	WHERE o.order.id = :idOrder" + 
						"	ORDER BY p.name, p.category";
		
		
		Query q = getSessionFactory().getCurrentSession().createQuery(hql);
		q.setParameter("idOrder", idOrder);
		
		List<OrderItems> listOrderItems = q.list();
		*/
		
		List<OrderItems> listOrderItems = null;
		
		try{
			
			listOrderItems = getSessionFactory().getCurrentSession().createCriteria(OrderItems.class)
					.createAlias("productInfo", "p")
					.add(Restrictions.eq("order.id", idOrder))
					.addOrder(Order.asc("p.name"))
					.addOrder(Order.asc("p.category"))
					.list();
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		
		return listOrderItems;
	}

}
