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

import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback(false)
public class UserTest {
	
	@Autowired
	private IUserService service;
	
	@Before
	public void setUp(){
		Assert.notNull(service);
	}
	
	@Test
	public void getAllUserServiceTest(){
		try {
			List<UserDto> userDtoLits = service.findAll();
				for(UserDto dto : userDtoLits){
					log.info("dto {}" , dto);
				}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUserByNameServiceTest(){
		try{
			UserDto userDto= service.getUserByNameService("TEPOS05");
			log.info("userDto {}", userDto);
			
		}catch(ServiceException e){
			
		}
	}

}
