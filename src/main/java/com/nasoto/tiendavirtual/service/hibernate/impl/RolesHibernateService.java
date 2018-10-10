package com.nasoto.tiendavirtual.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.api.IRolesDAO;
import com.nasoto.tiendavirtual.dto.RolesDto;
import com.nasoto.tiendavirtual.entities.Roles;
import com.nasoto.tiendavirtual.service.api.IRolesService;
import com.nasoto.tiendavirtual.service.assembler.Assembler;
import com.nasoto.tiendavirtual.service.assembler.RolesAssembler;
import com.nasoto.tiendavirtual.service.hibernate.GenericHibernateService;

@Service("rolesHibernateService")
public class RolesHibernateService 
	extends GenericHibernateService<Roles, RolesDto, Long>
	implements IRolesService{
	
	@Autowired
	private IRolesDAO dao;
	
	@Autowired
	private RolesAssembler assembler;

	@Override
	protected IGenericDAO<Roles, Long> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<RolesDto, Roles> getAssembler() {
		return assembler;
	}

}
