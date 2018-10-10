package com.nasoto.tiendavirtual.dao.hibernate.api;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;



/**
 * Implementation BaseDAO class for generic persistence operations.
 * 
 * @author Nestor Soto
 * @version 1.1
 * @since Build 1.0
 */

public class GenericHibernateDAO<T, PK extends Serializable> implements IGenericDAO<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;

	private final static Logger LOGGER = LoggerFactory.getLogger(IGenericDAO.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() throws PersistenceException {
		List<T> entities = new ArrayList<T>();
		try {
			entities = getSessionFactory().getCurrentSession()
					.createCriteria(this.getPersistentClass()).list();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return entities;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#getAllSet()
	 */
	public List<T> getAllSet() throws PersistenceException{
		List<T> entities = this.getAll();
		Set<T> entitiesSet = new LinkedHashSet<T>(entities);
		entities.clear();
		entities.addAll(entitiesSet);
		return entities;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#findByPK(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T findByPK(PK id) throws PersistenceException {
		try {
			 T t = (T) getSessionFactory().getCurrentSession().get(
						this.getPersistentClass(), id);
			getSessionFactory().getCurrentSession().evict(t);
			return t;
		} catch (Exception e) {
			throw new PersistenceException("Excepci&oacute;n en BD", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#update(java.lang.Object)
	 */
	public void update(T object) throws PersistenceException {
		try {
			getSessionFactory().getCurrentSession().update(object);
		} catch (Exception e) {
			LOGGER.debug("Cayo en exception al actualizar el objeto", e);
			throw new PersistenceException("Excepci&oacute;n en BD", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#remove(java.lang.Object)
	 */
	public void remove(T object) throws PersistenceException {
		try {
			getSessionFactory().getCurrentSession().delete(object);
			LOGGER.debug("Se ejecuto el borrado del objeto");
		} catch (Exception e) {
			LOGGER.debug("Cayo en exception al borrar el objeto", e);
			throw new PersistenceException("Excepci&oacute;n en BD", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#save(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public PK save(T object) throws PersistenceException {
		try {
			return (PK) getSessionFactory().getCurrentSession().save(object);
		} catch (Exception e) {
			throw new PersistenceException("Excepci&oacute;n en BD", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T object) throws PersistenceException {
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(object);
		} catch (Exception e) {
			throw new PersistenceException("Excepci&oacute;n en BD", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.peycash.persistence.dao.BaseDAO#exists(java.io.Serializable)
	 */
	public boolean exists(PK paramPK) throws PersistenceException {
		try {
			Object entity = this.findByPK(paramPK);
			return (entity != null);
		} catch (Exception e) {
			throw new PersistenceException("Excepcion en BD", e);
		}
	}
	
	@Override
	public void saveList(List<T> list) throws PersistenceException{
		try {
			 Session session = getSessionFactory().getCurrentSession();
			 int batchSize = 100;
				for (int i = 0; i < list.size(); i++) {
					T entity = list.get(i);
				    session.save(entity);
				    if(i % batchSize == 0) {
				        session.flush();
				        session.clear();
				    }
				    
				}
				session.flush();
				session.clear();
		} catch (Exception e) {
			throw new PersistenceException("Excepcion en saveList", e);
		}
	}

	/**
	 * Method that obtains the DAO's persistence class.
	 * 
	 * @return <T> clase a persistir.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getPersistentClass() {

		Class<T> type = null;

		Class<?> clazz = getClass();

		while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
			clazz = clazz.getSuperclass();
		}

		type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass())
				.getActualTypeArguments()[0];

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("type DO :: " + type);
		}
		return type;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
