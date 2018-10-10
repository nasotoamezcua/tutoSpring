package com.nasoto.tiendavirtual.service.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IProductInfoDAO;
import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.entities.ProductInfo;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IProductInfoService;
import com.nasoto.tiendavirtual.service.assembler.Assembler;
import com.nasoto.tiendavirtual.service.assembler.ProductInfoAssembler;
import com.nasoto.tiendavirtual.service.hibernate.GenericHibernateService;

@Service("productInfoHibernateService")
public class ProductInfoHibernateService 
	extends GenericHibernateService<ProductInfo, ProductInfoDto, Long>
	implements IProductInfoService{
	

	@Autowired
	private IProductInfoDAO dao;
	
	@Autowired
	private ProductInfoAssembler assembler;
	
	@Override
	protected IGenericDAO<ProductInfo, Long> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<ProductInfoDto, ProductInfo> getAssembler() {
		return assembler;
	}

	@Override
	public List<ProductInfoDto> getProductListAvailService() throws ServiceException {
		
		List<ProductInfoDto> piDtoList = null;
		
		try{
			List<ProductInfo> piEntityList = dao.getProductListAvail();
			piDtoList = assembler.getDTOListTransform(piEntityList);
		}catch(PersistenceException e){
			throw new ServiceException("Error in find: " + e.getMessage(), e);
		}
		
		return piDtoList;
	}

}
