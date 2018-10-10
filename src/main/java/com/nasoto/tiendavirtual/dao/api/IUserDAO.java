package com.nasoto.tiendavirtual.dao.api;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.entities.User;

public interface IUserDAO extends IGenericDAO<User, Long> {
	
	User getUserByName(String userName) throws PersistenceException;

}
