/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.ComentarioController;
import dsi235.entities.Comentario;
import dsi235.repositories.ComentarioRepository;

/**
 *
 * @author doratt
 */
@Controller
public class ComentarioControllerImpl extends AbstractCrudControllerImpl<Comentario, Long> implements ComentarioController{

	private ComentarioRepository repo;
	@Autowired
    public ComentarioControllerImpl(ComentarioRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
    public List<Comentario> findByIdTicket(Long idTicket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	CrudRepository<Comentario, Long> getRepository() {
		return this.repo;
	}
    
}
