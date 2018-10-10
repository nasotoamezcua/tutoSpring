package com.nasoto.tiendavirtual.service.assembler;


import org.springframework.stereotype.Component;

import com.nasoto.tiendavirtual.dto.CustomerDto;
import com.nasoto.tiendavirtual.dto.OrderDto;
import com.nasoto.tiendavirtual.entities.Customer;
import com.nasoto.tiendavirtual.entities.Order;

@Component("orderAssembler")
public class OrderAssembler extends Assembler<OrderDto, Order>{

	@Override
	public OrderDto getDTOTransform(Order mapping) {
		
		CustomerDto customerDto = new CustomerDto(mapping.getCustomer().getId(), 
										mapping.getCustomer().getFirstName(), 
										mapping.getCustomer().getLastName());
		
		OrderDto orderDto = OrderDto.builder()
				.idOrder(mapping.getId())
				.orderTotal(mapping.getOrderTotal())
				.timeStamp(mapping.getTimeStamp())
				.customerDto(customerDto)
				.build();
		
		return orderDto;
	}

	@Override
	public Order getMappingTransform(OrderDto dto) {
		
		Customer customerEntity = new Customer(dto.getCustomerDto().getIdCustomer(), 
										dto.getCustomerDto().getFirstName(), 
										dto.getCustomerDto().getLastName());
		
		Order orderEntity = Order.builder()
				.id(dto.getIdOrder())
				.orderTotal(dto.getOrderTotal())
				.timeStamp(dto.getTimeStamp())
				.customer(customerEntity)
				.build();
		
		return orderEntity;
	}

}
