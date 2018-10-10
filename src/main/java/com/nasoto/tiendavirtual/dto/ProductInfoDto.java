package com.nasoto.tiendavirtual.dto;

import java.util.Date;

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
@Builder
@ToString
@EqualsAndHashCode
public class ProductInfoDto {
	
	private Long idProduct;
	private String productName;
	private String productDescription;
	private String productCategory;
	private String productAvail;
	private int productPrice;
	private String productType;
	private String productFileName;
	@Temporal(TemporalType.DATE)
	private Date productDateUpdate;
	
	
	public ProductInfoDto(Long idProduct, String productName, String productDescription, String productCategory) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
	}
	
	 

}
