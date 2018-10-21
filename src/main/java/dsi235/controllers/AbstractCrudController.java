package dsi235.controllers;

import java.util.List;
import java.util.Optional;

public interface AbstractCrudController<T, ID> {
	
	public Optional<T> findById(ID id);
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public void deleteById(ID id);
	
	public void delete(T entity);
	
	
	
}
