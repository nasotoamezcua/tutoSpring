package com.nasoto.tiendavirtual.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.api.ICustomerDAO;
import com.nasoto.tiendavirtual.dto.CustomerDto;
import com.nasoto.tiendavirtual.entities.Customer;
import com.nasoto.tiendavirtual.service.api.ICustomerService;
import com.nasoto.tiendavirtual.service.assembler.Assembler;
import com.nasoto.tiendavirtual.service.assembler.CustomerAssembler;
import com.nasoto.tiendavirtual.service.hibernate.GenericHibernateService;

@Service("customerHibernateService")
public class CustomerHibernateService 
	extends GenericHibernateService<Customer, CustomerDto, Long> implements ICustomerService {
	
	@Autowired
	private ICustomerDAO dao;
	
	@Autowired
	private CustomerAssembler assembler;

	@Override
	protected IGenericDAO<Customer, Long> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<CustomerDto, Customer> getAssembler() {
		return assembler;
	}

}
