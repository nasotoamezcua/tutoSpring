package com.nasoto.tiendavirtual.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.nasoto.tiendavirtual.dao.api.IRolesDAO;
import com.nasoto.tiendavirtual.dao.hibernate.api.GenericHibernateDAO;
import com.nasoto.tiendavirtual.entities.Roles;

@Repository("rolesHibernateDAO")
public class RolesHibernateDAO 
	extends GenericHibernateDAO<Roles, Long> implements IRolesDAO{

}
