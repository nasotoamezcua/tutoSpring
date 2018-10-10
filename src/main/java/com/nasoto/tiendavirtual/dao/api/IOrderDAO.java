package com.nasoto.tiendavirtual.dao.api;

import java.util.List;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.entities.Order;

public interface IOrderDAO extends IGenericDAO<Order, Long> {
	
	List<Order> getOrderFindByIdCustomer(Long idCustomer) throws PersistenceException;
	
	List<Order> getOrderCustomerByUserId(Long idUser) throws PersistenceException;

}
