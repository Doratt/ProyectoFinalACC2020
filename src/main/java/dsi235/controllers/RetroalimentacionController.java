package dsi235.controllers;

import dsi235.entities.Retroalimentacion;
import dsi235.entities.Ticket;

public interface RetroalimentacionController extends AbstractCrudController<Retroalimentacion, Long>{
	
	public void calificarTicket(int calificacion, Ticket ticket, String comentario);
	

}
