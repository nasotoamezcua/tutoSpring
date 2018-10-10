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

import com.nasoto.tiendavirtual.dao.api.ICustomerDAO;
import com.nasoto.tiendavirtual.dao.api.IOrderDAO;
import com.nasoto.tiendavirtual.dto.CustomerDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.ICustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback
public class CustomerTest {
	
	@Autowired
	private ICustomerDAO customer;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IOrderDAO order;
	
	@Before
	public void setUp(){
		Assert.notNull(customer);
		Assert.notNull(order);
		Assert.notNull(customerService);
	}
	
	@Test
	public void getAllCustomerTest(){
		log.info("getAllCustomerTest");
	}
	
	@Test
	public void getAllCustomerServiceTest(){
		log.info("getAllCustomerServiceTest");
		try {
			List<CustomerDto> custDtoList = customerService.findAll();
				for(CustomerDto dto: custDtoList){
					log.info("CustomerDto {}", dto);
				}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		

}
