package com.nasoto.tiendavirtual.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderItemsDto"})
@EqualsAndHashCode(exclude = {"orderItemsDto"})
@Builder
public class OrderDto {
	
	private Long idOrder;
	private int orderTotal;
	@Temporal(TemporalType.DATE)
	private Date timeStamp;
	
	private CustomerDto customerDto;
	
	private List<OrderItemsDto> orderItemsDto = new ArrayList<OrderItemsDto>();

}
