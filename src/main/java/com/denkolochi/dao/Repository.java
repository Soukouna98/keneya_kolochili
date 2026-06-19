package com.denkolochi.dao;

import java.util.List;

public interface Repository<T, ID> {
	void save(T entity);

	T findById(ID id);

	List<T> findAll();

	void delete(ID id);

	void update(ID id, T entity);

	void update(Integer id, T entity);
}