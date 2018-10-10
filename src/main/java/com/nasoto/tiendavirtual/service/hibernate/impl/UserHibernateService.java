package com.nasoto.tiendavirtual.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IUserDAO;
import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.entities.User;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IUserService;
import com.nasoto.tiendavirtual.service.assembler.Assembler;
import com.nasoto.tiendavirtual.service.assembler.UserAssembler;
import com.nasoto.tiendavirtual.service.hibernate.GenericHibernateService;

@Service("userHibernateService")
public class UserHibernateService 
	extends GenericHibernateService<User, UserDto, Long> implements IUserService {
	
	@Autowired
	private IUserDAO dao;
	
	@Autowired
	private UserAssembler assembler;

	@Override
	protected IGenericDAO<User, Long> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<UserDto, User> getAssembler() {
		return assembler;
	}

	@Override
	public UserDto getUserByNameService(String userName) throws ServiceException {
		
		UserDto userDto = null;
		
		try{
			
			User userEntity = dao.getUserByName(userName);
			userDto = assembler.getDTOTransform(userEntity);
			
		}catch(PersistenceException e){
			throw new ServiceException("Error in find: " + e.getMessage(), e);
		}
		
		return userDto;
	}

}
