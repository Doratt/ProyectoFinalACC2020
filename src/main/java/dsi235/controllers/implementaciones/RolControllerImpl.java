/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.RolController;
import dsi235.entities.Rol;
import dsi235.repositories.RolRepository;

/**
 *
 * @author doratt
 */
@Controller
public class RolControllerImpl extends AbstractCrudControllerImpl<Rol, Short> implements RolController{

	private RolRepository rolRepository;
	
	@Autowired
	public RolControllerImpl(RolRepository rolRepository) {
		super();
		this.rolRepository = rolRepository;
	}


	@Override
	CrudRepository<Rol, Short> getRepository() {
		return this.rolRepository;
	}
    
}
