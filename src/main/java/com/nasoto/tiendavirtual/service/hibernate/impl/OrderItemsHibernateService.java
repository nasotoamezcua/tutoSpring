package com.nasoto.tiendavirtual.service.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IOrderItemsDAO;
import com.nasoto.tiendavirtual.dto.OrderItemsDto;
import com.nasoto.tiendavirtual.entities.OrderItems;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IOrderItemsService;
import com.nasoto.tiendavirtual.service.assembler.Assembler;
import com.nasoto.tiendavirtual.service.assembler.OrderItemsAssembler;
import com.nasoto.tiendavirtual.service.hibernate.GenericHibernateService;


@Service("orderItemsHibernateService")
public class OrderItemsHibernateService 
	extends GenericHibernateService<OrderItems, OrderItemsDto, Long> implements IOrderItemsService {
	
	@Autowired
	private IOrderItemsDAO dao;
	
	@Autowired
	private OrderItemsAssembler assembler; 

	@Override
	public List<OrderItemsDto> getOrderItemsFindByIdOrder(Long idOrder) throws ServiceException  {
		
		List<OrderItemsDto> dtoList = null;
		
		try{
			List<OrderItems> entityList = dao.getOrderItemsFindByIdOrder(idOrder);
			dtoList = assembler.getDTOListTransform(entityList);
		}catch(PersistenceException e){
			throw new ServiceException("Error in find: " + e.getMessage(), e);
		}
		
		return dtoList;
	}

	@Override
	protected IGenericDAO<OrderItems, Long> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<OrderItemsDto, OrderItems> getAssembler() {
		return assembler;
	}

}
