package com.nasoto.tiendavirtual.service.api;

import java.util.List;

import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.entities.ProductInfo;
import com.nasoto.tiendavirtual.service.IGenericService;
import com.nasoto.tiendavirtual.service.ServiceException;

public interface IProductInfoService  extends IGenericService<ProductInfo, ProductInfoDto, Long>{
	
	List<ProductInfoDto> getProductListAvailService() throws ServiceException;

}
