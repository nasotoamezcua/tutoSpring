package com.nasoto.tiendavirtual.dao.hibernate.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.dao.api.IUserDAO;
import com.nasoto.tiendavirtual.dao.hibernate.api.GenericHibernateDAO;
import com.nasoto.tiendavirtual.entities.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("userHibernateDAO")
public class UserHibernateDAO extends GenericHibernateDAO<User, Long>
	implements IUserDAO{

	@Override
	public User getUserByName(String userName) throws PersistenceException {
		
		User u = null;
		
		try{
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(User.class).add(Restrictions.eq("name", userName));				
			u = (User)c.uniqueResult();
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		
		return u;
	}

}
