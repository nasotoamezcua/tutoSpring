package com.nasoto.tiendavirtual.service.api;

import java.util.List;

import com.nasoto.tiendavirtual.dto.OrderDto;
import com.nasoto.tiendavirtual.entities.Order;
import com.nasoto.tiendavirtual.service.IGenericService;
import com.nasoto.tiendavirtual.service.ServiceException;

public interface IOrderService extends IGenericService<Order, OrderDto, Long> {
	
	List<OrderDto> getOrderFindByIdCustomerService(Long idCustomer) throws ServiceException;
	
	List<OrderDto> getOrderCustomerByUserIdService(Long idUser) throws ServiceException;

}
