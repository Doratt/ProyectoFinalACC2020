/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.PrioridadController;
import dsi235.entities.Prioridad;
import dsi235.entities.repositories.PrioridadRepository;

/**
 *
 * @author doratt
 */
@Controller
public class PrioridadControllerImpl extends AbstractCrudControllerImpl<Prioridad, Short> implements PrioridadController{

	private PrioridadRepository prioridadRepository;
	
	@Autowired
	public PrioridadControllerImpl(PrioridadRepository prioridadRepository) {
		super();
		this.prioridadRepository = prioridadRepository;
	}


	@Override
	CrudRepository<Prioridad, Short> getRepository() {
		return this.prioridadRepository;
	}
    
}
