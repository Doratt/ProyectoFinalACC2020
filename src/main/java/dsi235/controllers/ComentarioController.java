package dsi235.controllers;

import java.util.List;

import dsi235.entities.Comentario;
import dsi235.entities.Ticket;

public interface ComentarioController extends AbstractCrudController<Comentario, Long>{
	List<Comentario> findByIdTicket(Ticket idTicket);

}
