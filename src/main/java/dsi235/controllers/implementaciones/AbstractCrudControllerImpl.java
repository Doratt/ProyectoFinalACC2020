/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author doratt
 */
public abstract class AbstractCrudControllerImpl<T,ID>{
	
	abstract CrudRepository<T, ID> getRepository();
	
    public T findById(ID id){
        return null;
    }
	
	public List<T> findAll(){
        return null;    
        }
	
	public T save(T entity){
        return null;    
        }
	
	public void deleteById(int id){
            
        }
	
	public void delete(T entity){
            
        }
	
}
