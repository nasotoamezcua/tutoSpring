package com.nasoto.tiendavirtual.service.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nasoto.tiendavirtual.dao.IGenericDAO;
import com.nasoto.tiendavirtual.dao.PersistenceException;
import com.nasoto.tiendavirtual.service.IGenericService;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.assembler.Assembler;

@Transactional
public abstract class GenericHibernateService<T, D, PK extends Serializable> implements IGenericService<T, D, PK> {

	protected abstract IGenericDAO<T, PK> getDAO();

	protected abstract Assembler<D, T> getAssembler();

	@Override
	public PK create(D d) throws ServiceException {
		try {
			T t = getAssembler().getMappingTransform(d);
			PK t_ = getDAO().save(t);
			return t_;
		} catch (PersistenceException e) {
			throw new ServiceException("Error in create: " + e.getMessage(), e);
		}
	}

	@Override
	public D find(PK id) throws ServiceException {
		try {
			T t = getDAO().findByPK(id);
			D d = getAssembler().getDTOTransform(t);
			return d;
		} catch (PersistenceException e) {
			throw new ServiceException("Error in find: " + e.getMessage(), e);
		}
	}

	@Override
	public void update(D d) throws ServiceException {
		try {
			T t = getAssembler().getMappingTransform(d);
			getDAO().update(t);
		} catch (PersistenceException e) {
			throw new ServiceException("Error in update: " + e.getMessage(), e);
		}
	}


	@Override
	public List<D> findAll() throws ServiceException {
		try {
			List<T> list = getDAO().getAll();
			List<D> list_ = getAssembler().getDTOListTransform(list);
			return list_;
		} catch (PersistenceException e) {
			throw new ServiceException("Error in findAll: " + e.getMessage(), e);
		}
	}
	
	@Override
	public List<D> findAllSet() throws ServiceException{
		try{
			List<T> list = getDAO().getAllSet();
			List<D> list_ = getAssembler().getDTOListTransform(list);
			return list_;
		}catch(PersistenceException e){
			throw new ServiceException("Error in findAll: " + e.getMessage(), e);
		}
	}
	
	
	@Override
	public void delete(D d) throws ServiceException {
		try {
			T t = getAssembler().getMappingTransform(d);
			getDAO().remove(t);
		} catch (PersistenceException e) {
			throw new ServiceException("Error in delete: " + e.getMessage(), e);
		}
	}

	@Override
	public void saveList(List<D> list) throws ServiceException {
		try {
			List<T> list_ = getAssembler().getMappingListTransform(list);
			getDAO().saveList(list_);
		} catch (PersistenceException e) {
			throw new ServiceException("Error in saveList: " + e.getMessage(), e);
		}
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private Class<T> getPersistentClass() {

		Class<T> type = null;

		Class<?> clazz = getClass();

		while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
			clazz = clazz.getSuperclass();
		}

		type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];

		return type;
	}

}
