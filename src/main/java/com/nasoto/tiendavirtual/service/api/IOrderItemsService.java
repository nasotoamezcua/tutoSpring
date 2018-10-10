package com.nasoto.tiendavirtual.service.api;

import java.util.List;

import com.nasoto.tiendavirtual.dto.OrderItemsDto;
import com.nasoto.tiendavirtual.entities.OrderItems;
import com.nasoto.tiendavirtual.service.IGenericService;
import com.nasoto.tiendavirtual.service.ServiceException;

public interface IOrderItemsService extends IGenericService<OrderItems, OrderItemsDto, Long> {
	
	List<OrderItemsDto> getOrderItemsFindByIdOrder(Long idOrder) throws ServiceException;

}
