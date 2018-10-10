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

import com.nasoto.tiendavirtual.dao.api.IOrderDAO;
import com.nasoto.tiendavirtual.dao.api.IOrderItemsDAO;
import com.nasoto.tiendavirtual.dto.OrderDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback
public class OrderTest {
	
	@Autowired
	private IOrderDAO order;
	
	@Autowired
	private IOrderItemsDAO orderItems;
	
	@Autowired
	private IOrderService service;
	
	@Before
	public void setUp(){
		Assert.notNull(order);
		Assert.notNull(orderItems);
		Assert.notNull(service);
	}
	
	@Test
	public void getAllOrderTest(){
		log.info("getAllOrderTest");
	}
	
	@Test
	public void getAllOrderSeriviceTest(){
		log.info("getAllOrderSeriviceTest");
		List<OrderDto> orderDtoList;
		try {
			orderDtoList = service.findAll();
			for(OrderDto dto : orderDtoList){
				log.info("OrderDto {}", dto);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getOrderByCustomerIdServiceTest(){
		log.info("getOrderByCustomerIdServiceTest");
		List<OrderDto> orderDtoList;
		try {
			orderDtoList = service.getOrderFindByIdCustomerService(3l);
			for(OrderDto dto : orderDtoList){
				log.info("OrderDto {}", dto);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void getOrderCustomerByUserIdServiceTest(){
		log.info("getOrderCustomerByUserIdServiceTest");
		
		List<OrderDto> orderDtoList;
		
		try{
			orderDtoList = service.getOrderCustomerByUserIdService(2L);
				for(OrderDto dto : orderDtoList){
					log.info("OrderDto {}", dto);
				}
		}catch(ServiceException e){
			e.printStackTrace();
		}
	}

}
