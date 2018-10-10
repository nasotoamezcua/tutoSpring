package com.nasoto.tiendavirtual.dao;

import java.io.Serializable;
import java.util.List;


/**
 * Interface that defines basic persistence operations.
 * 
 * @author Nestor Soto
 * @version 1.1
 * @since 1.0
 * @param <T>
 *            Entity class to persist
 * @param <PK>
 *            Primary key of the entity class
 */
public interface IGenericDAO<T, PK extends Serializable> {

	/**
	 * Generic method that gets all objects of a particular domain class.
	 * 
	 * @return Object list
	 */
	List<T> getAll() throws PersistenceException;
	
	/**
	 * Generic method that gets all objects of a particular domain class.
	 * @return Object list	 
	 */
	List<T> getAllSet() throws PersistenceException;
	
	/**
	 * Generic method used to get all objects of a particular domain class based
	 * on its Primary key.
	 * 
	 * @param id
	 *            Identifier (primary key) of the class.
	 * @return Loaded object
	 */
	T findByPK(PK id) throws PersistenceException;

	/**
	 * Generic method used to save an object in database - handle update &
	 * insertion.
	 * 
	 * @param object
	 *            Object to save.
	 */
	void update(T object) throws PersistenceException;

	/**
	 * Generic method used to delete an object based on its primary key.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to delete
	 */
	void remove(T object) throws PersistenceException;

	/**
	 * Generic method used to insert an object.
	 */
	PK save(T object) throws PersistenceException;

	/**
	 * Generic method used to save or update an object.
	 * 
	 * @param object
	 */
	void saveOrUpdate(T object) throws PersistenceException;

	/**
	 * Check the existence of an object based on its primary key.
	 * 
	 * @param paramPK
	 *            Primary Key
	 * @return true if the object related with the primary key exists.
	 */
	boolean exists(PK paramPK) throws PersistenceException;

	void saveList(List<T> list) throws PersistenceException;

}
