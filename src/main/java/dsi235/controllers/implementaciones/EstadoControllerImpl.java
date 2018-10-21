/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.EstadoController;
import dsi235.entities.Estado;
import dsi235.entities.repositories.EstadoRepository;

/**
 *
 * @author doratt
 */
@Controller
public class EstadoControllerImpl extends AbstractCrudControllerImpl<Estado, Short> implements EstadoController{

	private EstadoRepository estadoRepository;
	
	@Autowired
	public EstadoControllerImpl(EstadoRepository estadoRepository) {
		super();
		this.estadoRepository = estadoRepository;
	}



	@Override
	CrudRepository<Estado, Short> getRepository() {
		return this.estadoRepository;
	}



    
}
