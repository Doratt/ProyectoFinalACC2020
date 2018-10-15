/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.RetroalimentacionController;
import dsi235.entities.Retroalimentacion;
import dsi235.entities.Ticket;
import dsi235.repositories.RetroalimentacionRepository;

/**
 *
 * @author doratt
 */
@Controller
public class RetroalimentacionControllerImpl extends AbstractCrudControllerImpl<Retroalimentacion, Long> implements RetroalimentacionController{

	private RetroalimentacionRepository retroalimentacionRepository;
	
	@Autowired
    public RetroalimentacionControllerImpl(RetroalimentacionRepository retroalimentacionRepository) {
		super();
		this.retroalimentacionRepository = retroalimentacionRepository;
	}

	@Override
    public void calificarTicket(int calificacion, Ticket ticket, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	CrudRepository<Retroalimentacion, Long> getRepository() {
		return this.retroalimentacionRepository;
	}
    
}
