package com.nasoto.tiendavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class OrderItemsDto {
	
	private Long idOrderItem;
	private int orderQuantity;
	private int orderUnitPrice;
	private ProductInfoDto productInfoDto;

}
