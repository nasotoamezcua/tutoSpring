package com.nasoto.tiendavirtual.dao.hibernate.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IProductInfoDAO;
import com.nasoto.tiendavirtual.dao.hibernate.api.GenericHibernateDAO;
import com.nasoto.tiendavirtual.entities.ProductInfo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository("productInfoHibernateDAO")
public class ProductInfoHibernateDAO extends GenericHibernateDAO<ProductInfo, Long> 
	implements IProductInfoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductInfo> getProductListAvail() throws PersistenceException {
		
		List<ProductInfo> listProductInfo = null;
		
		try{
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(ProductInfo.class)
					.add(Restrictions.eq("avail", "Y"));
			
			listProductInfo = c.list();
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		
		return listProductInfo;
	}	

}
