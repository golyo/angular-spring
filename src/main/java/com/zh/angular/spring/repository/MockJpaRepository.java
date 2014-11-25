package com.zh.angular.spring.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class MockJpaRepository<T, ID extends Serializable> implements JpaRepository<T, Serializable> {

	private Map<ID, T> entityMap;
	
	public MockJpaRepository(List<T> entities) {
		entityMap = new ConcurrentHashMap<ID, T>();
		for (T e: entities) {
			entityMap.put(getId(e), e);
		}
	}

	
	protected abstract ID getId(T entity);
	
	protected abstract void setId(T entity, ID id);
	
	protected abstract ID nextId();
	
	public Page<T> findAll(Pageable pageable) {
		List<T> entityList = findAll(pageable.getSort());
		entityList = entityList.subList(pageable.getOffset(), pageable.getPageSize());
		Page<T> page = new PageImpl<T>(entityList, pageable, entityMap.size());
		return page;
	}

	public long count() {
		return entityMap.size();
	}

	public void delete(Serializable arg0) {
		entityMap.remove(arg0);		
	}

	public void delete(T arg0) {
		entityMap.remove(getId(arg0));				
	}

	public void delete(Iterable<? extends T> arg0) {
		for (T e: arg0) {
			delete(e);
		}
	}

	public void deleteAll() {
		entityMap.clear();
	}

	public boolean exists(Serializable arg0) {
		return entityMap.containsKey(arg0);
	}

	public T findOne(Serializable arg0) {
		return entityMap.get(arg0);
	}

	public <S extends T> S save(S arg0) {
		if (getId(arg0) == null) {
			ID id = nextId();
			setId(arg0, id);
		}
		entityMap.put(getId(arg0), arg0);
		return arg0;
	}

	public List<T> findAll() {
		return new ArrayList<T>(entityMap.values());
	}

	public List<T> findAll(Sort sort) {
		return findAll();
	}

	public List<T> findAll(Iterable<Serializable> ids) {
		List<T> ret = new ArrayList<T>();
		for (Serializable id: ids) {
			ret.add(entityMap.get(id));
		}
		return ret;
	}

	public <S extends T> List<S> save(Iterable<S> entities) {
		List<S> ret = new ArrayList<S>();
		for (S entity: entities) {
			ret.add(save(entity));
		}
		return ret;
	}

	public void flush() {
	}

	public <S extends T> S saveAndFlush(S entity) {
		return save(entity);
	}

	public void deleteInBatch(Iterable<T> entities) {
		delete(entities);
	}

	public void deleteAllInBatch() {
		deleteAll();
	}

	public T getOne(Serializable id) {
		return findOne(id);
	}
}
