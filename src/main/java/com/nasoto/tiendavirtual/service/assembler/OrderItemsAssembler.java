package com.nasoto.tiendavirtual.service.assembler;

import org.springframework.stereotype.Component;

import com.nasoto.tiendavirtual.dto.OrderItemsDto;
import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.entities.OrderItems;
import com.nasoto.tiendavirtual.entities.ProductInfo;

@Component("orderItemsAssembler")
public class OrderItemsAssembler extends Assembler<OrderItemsDto, OrderItems> {

	@Override
	public OrderItemsDto getDTOTransform(OrderItems mapping) {
		
		ProductInfoDto piDto = new ProductInfoDto(mapping.getProductInfo().getId(), mapping.getProductInfo().getName(), 
											mapping.getProductInfo().getDescription(), mapping.getProductInfo().getCategory());
		
		OrderItemsDto dto = OrderItemsDto.builder()
				.idOrderItem(mapping.getId())
				.orderQuantity(mapping.getQuantity())
				.orderUnitPrice(mapping.getUnitPrice())
				.productInfoDto(piDto).build();
		
		return dto;
	}

	@Override
	public OrderItems getMappingTransform(OrderItemsDto dto) {
		
		ProductInfo piEntity = new ProductInfo(dto.getProductInfoDto().getIdProduct(), dto.getProductInfoDto().getProductName(), 
										dto.getProductInfoDto().getProductDescription(), dto.getProductInfoDto().getProductCategory());
		
		OrderItems entity = OrderItems.builder()
				.id(dto.getIdOrderItem())
				.quantity(dto.getOrderQuantity())
				.unitPrice(dto.getOrderUnitPrice())
				.productInfo(piEntity).build();
		
		return entity;
	}

}
