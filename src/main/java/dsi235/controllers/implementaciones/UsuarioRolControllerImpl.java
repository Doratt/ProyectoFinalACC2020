/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.UsuarioRolController;
import dsi235.entities.UsuarioRol;
import dsi235.entities.repositories.UsuarioRolRepository;

/**
 *
 * @author doratt
 */
@Controller
public class UsuarioRolControllerImpl extends AbstractCrudControllerImpl<UsuarioRol, Integer> implements UsuarioRolController{

	private UsuarioRolRepository usuarioRolRepository;
	
	@Autowired
	public UsuarioRolControllerImpl(UsuarioRolRepository usuarioRolRepository) {
		super();
		this.usuarioRolRepository = usuarioRolRepository;
	}



	@Override
	CrudRepository<UsuarioRol, Integer> getRepository() {
		return this.usuarioRolRepository;
	}
    
}
