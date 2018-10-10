package com.nasoto.tiendavirtual.dao.api;

import java.util.List;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.entities.OrderItems;

public interface IOrderItemsDAO extends IGenericDAO<OrderItems, Long> {
	
	List<OrderItems> getOrderItemsFindByIdOrder(Long idOrder) throws PersistenceException;

}
