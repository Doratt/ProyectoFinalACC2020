/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import java.sql.Date;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.TicketEncargadoController;
import dsi235.entities.TicketEncargado;
import dsi235.entities.repositories.TicketEncargadoRepository;

/**
 *
 * @author doratt
 */
@Controller
public class TicketEncargadoControllerImpl extends AbstractCrudControllerImpl<TicketEncargado, Long> implements TicketEncargadoController{
    private TicketEncargadoRepository ticketEncargadoRepository;

    @Autowired
	public TicketEncargadoControllerImpl(TicketEncargadoRepository ticketEncargadoRepository) {
		super();
		this.ticketEncargadoRepository = ticketEncargadoRepository;
	}
    
    public TicketEncargado save(TicketEncargado ticketEncargado) {
    	ticketEncargado.setFechaCreacion(Date.from(Instant.now()));
    	
    	return getRepository().save(ticketEncargado);
    }
    
    

	@Override
	CrudRepository<TicketEncargado, Long> getRepository() {
		return this.ticketEncargadoRepository;
	}
    
    
}
