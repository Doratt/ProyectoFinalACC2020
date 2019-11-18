/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author doratt
 */
public abstract class AbstractCrudControllerImpl<T, ID> {

	abstract CrudRepository<T, ID> getRepository();
	

	public Optional<T> findById(ID id) {
		return getRepository().findById(id);
	}

	public List<T> findAll() {
		return (List<T>) getRepository().findAll();
	}

	public T save(T entity) {
		return getRepository().save(entity);
	}

	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}

	public void delete(T entity) {
		getRepository().delete(entity);
	}

}
