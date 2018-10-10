package com.nasoto.tiendavirtual.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.nasoto.tiendavirtual.dao.api.IProductInfoDAO;
import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IProductInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback
public class ProductInfoTest {
	
	@Autowired
	private IProductInfoDAO productInfo;
	
	@Autowired
	private IProductInfoService service;
	
	@Before
	public void setUp(){
		Assert.notNull(productInfo);
		Assert.notNull(service);
	}	
	
	@Test
	public void getAllProductInfoTest(){
		log.info("getAllProductInfoTest");
		
	}
	
	@Test
	public void getAllProductInfoServiceTest(){
		try {
			List<ProductInfoDto> piDtoList = service.findAll();
			for(ProductInfoDto dto : piDtoList){
				log.info("dto {}" , dto);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
