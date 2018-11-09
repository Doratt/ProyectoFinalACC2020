package dsi235.controllers;

import java.util.List;

import dsi235.entities.TicketEncargado;

public interface TicketEncargadoController extends AbstractCrudController<TicketEncargado, Long>{

	public List<TicketEncargado> findByIdTicket_IdTicket(Long idTicket);
	
}
