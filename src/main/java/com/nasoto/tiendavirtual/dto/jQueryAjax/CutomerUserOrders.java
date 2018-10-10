package com.nasoto.tiendavirtual.dto.jQueryAjax;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class CutomerUserOrders {
	
	private Long cliente;
	private Long usuario;
	private Long orden;
	private String desc;
}
