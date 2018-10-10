package com.nasoto.tiendavirtual.service.api;

import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.entities.User;
import com.nasoto.tiendavirtual.service.IGenericService;
import com.nasoto.tiendavirtual.service.ServiceException;

public interface IUserService extends IGenericService<User, UserDto, Long> {
	
	 UserDto  getUserByNameService(String userName) throws ServiceException;

}
