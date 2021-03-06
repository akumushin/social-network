package com.socialnetwork.common.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CustomDaoImpl<E, EID> implements CustomDao<E>{
	@PersistenceContext
	protected EntityManager em;
	/**
	 * insert record into table
	 */
	@Override
	@Transactional
	public void persist(E entity) {
		em.persist(entity);
	}
	/**
	 * update record from table
	 */
	@Override
	@Transactional
	public E merge(E entity) {
		return em.merge(entity);
	}
	@Override
	@Transactional
	public int deleteList(Collection< E> entities) {
		checkNull(entities);
		List<E> list = new ArrayList<>(entities.size());
		for(E e: entities) {
			if(e!=null)
				list.add(e);
		}
		if(list.size()==0)
			return 0;
		Class<E> clazz=this.getEntityClass(list.get(0));
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaDelete<E> query = cb.createCriteriaDelete(clazz);
		Root<E> root= query.from(clazz);
		query.where(root.in(list));
		return em.createQuery(query).executeUpdate();
	}
	@Transactional
	@Override
	public int deleteOne(E entity) {
		Class<E> clazz=this.getEntityClass(entity);
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaDelete<E> query = cb.createCriteriaDelete(clazz);
		Root<E> root= query.from(clazz);
		query.where(cb.equal(root, entity));
		return em.createQuery(query).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass(Object o){
		checkNull(o);
		Entity e = o.getClass().getAnnotation(Entity.class);
		if(e==null)
			throw new IllegalArgumentException("Parameter is not entity");
		return (Class<E>) o.getClass();
	}
	
	public void checkNull(Object o) {
		if(o==null)
			throw new IllegalArgumentException("Parameter is null");
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public int deleteList(E... entities) {
		return deleteList(Arrays.asList(entities));
	}
	@Override
	@Transactional
	public E selectForUpdate(E entity, Class<E> clazz) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<E> query = cb.createQuery(clazz);
		Root<E> root = query.from(clazz);
		query.select(root);
		query.where(cb.equal(root, entity));
		return em.createQuery(query).setLockMode(LockModeType.PESSIMISTIC_WRITE).getSingleResult();
	}


}
