package com.nasoto.tiendavirtual.service;

import com.nasoto.tiendavirtual.dao.PersistenceException;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(){}
	
	public ServiceException(String string, PersistenceException e) {
		super(string, e);
	}

}
