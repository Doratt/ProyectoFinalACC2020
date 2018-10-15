package dsi235.controllers;

import java.util.List;

public interface AbstractCrudController<T, ID> {
	
	public T findById(ID id);
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public void deleteById(int id);
	
	public void delete(T entity);
	
	
	
}
