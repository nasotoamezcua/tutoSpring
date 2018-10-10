package com.nasoto.tiendavirtual.service.assembler;

import org.springframework.stereotype.Component;

import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.entities.ProductInfo;

@Component("productInfoAssembler")
public class ProductInfoAssembler extends Assembler<ProductInfoDto, ProductInfo> {

	@Override
	public ProductInfoDto getDTOTransform(ProductInfo mapping) {
		
		ProductInfoDto piDto = ProductInfoDto.builder()
				.idProduct(mapping.getId())
				.productName(mapping.getName())
				.productDescription(mapping.getDescription())
				.productCategory(mapping.getCategory())
				.productAvail(mapping.getAvail())
				.productPrice(mapping.getPrice())
				.productType(mapping.getType())
				.productFileName(mapping.getFileName())
				.productDateUpdate(mapping.getDateUpdate()).build();
		
		return piDto;
	}

	@Override
	public ProductInfo getMappingTransform(ProductInfoDto dto) {
		
		ProductInfo piEntity = ProductInfo.builder()
				.id(dto.getIdProduct())
				.name(dto.getProductName())
				.description(dto.getProductDescription())
				.category(dto.getProductCategory())
				.avail(dto.getProductAvail())
				.price(dto.getProductPrice())
				.type(dto.getProductType())
				.fileName(dto.getProductFileName())
				.dateUpdate(dto.getProductDateUpdate()).build();
		
		return piEntity;
	}

}
