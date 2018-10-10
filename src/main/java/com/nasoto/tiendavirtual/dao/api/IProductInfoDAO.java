package com.nasoto.tiendavirtual.dao.api;

import java.util.List;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.entities.ProductInfo;

public interface IProductInfoDAO extends IGenericDAO<ProductInfo, Long>{
	
	List<ProductInfo> getProductListAvail() throws PersistenceException;

}
