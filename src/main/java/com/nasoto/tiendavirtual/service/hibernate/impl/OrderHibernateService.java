package com.nasoto.tiendavirtual.service.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IOrderDAO;
import com.nasoto.tiendavirtual.dto.OrderDto;
import com.nasoto.tiendavirtual.entities.Order;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IOrderService;
import com.nasoto.tiendavirtual.service.assembler.Assembler;
import com.nasoto.tiendavirtual.service.assembler.OrderAssembler;
import com.nasoto.tiendavirtual.service.hibernate.GenericHibernateService;

@Service("orderHibernateService")
public class OrderHibernateService 
	extends GenericHibernateService<Order, OrderDto, Long> implements IOrderService {
	
	@Autowired
	private IOrderDAO dao;
	
	@Autowired
	private OrderAssembler assembler;

	@Override
	public List<OrderDto> getOrderFindByIdCustomerService(Long idCustomer) throws ServiceException {
		
		List<OrderDto> orderDtoList = null;
		
			try{
				List<Order> oderEntityList = dao.getOrderFindByIdCustomer(idCustomer);
				orderDtoList = assembler.getDTOListTransform(oderEntityList);
				
			}catch(PersistenceException e){
				throw new ServiceException("Error in find: " + e.getMessage(), e);
			}
			
			return orderDtoList;
		
	}
	
	@Override
	public List<OrderDto> getOrderCustomerByUserIdService(Long idUser) throws ServiceException {
		
		List<OrderDto> orderDtoList = null;
		
		try{
			List<Order> orderEntityList = dao.getOrderCustomerByUserId(idUser);
			orderDtoList = assembler.getDTOListTransform(orderEntityList);
			
		}catch(PersistenceException e){
			throw new ServiceException("Error in find: " + e.getMessage(), e);
		}
		
		return orderDtoList;
	}

	@Override
	protected IGenericDAO<Order, Long> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<OrderDto, Order> getAssembler() {
		return assembler;
	}

	

}
