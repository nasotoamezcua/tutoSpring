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

import com.nasoto.tiendavirtual.dao.api.IOrderItemsDAO;
import com.nasoto.tiendavirtual.dto.OrderItemsDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IOrderItemsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback
public class OrderItemsTest {
	
	@Autowired
	private IOrderItemsDAO orderItems;
	
	@Autowired
	private IOrderItemsService service;
	
	
	@Before
	public void setUp(){
		Assert.notNull(orderItems);
		Assert.notNull(service);
	}
	
	@Test
	public void getAllOrderItemsTest(){
		log.info("getAllOrderItemsTest");
	}
	
	@Test
	public void getAllOrderitemsServiceTest(){
		log.info("getAllOrderitemsServiceTest");
		List<OrderItemsDto> listOrderItemsDto;
		try {
			listOrderItemsDto = service.getOrderItemsFindByIdOrder(2l);
			for(OrderItemsDto dto : listOrderItemsDto){
				log.info("OrderItemsDto {}", dto);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
