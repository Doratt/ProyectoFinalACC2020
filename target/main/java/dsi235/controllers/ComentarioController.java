package dsi235.controllers;

import java.util.List;

import dsi235.entities.Comentario;

public interface ComentarioController extends AbstractCrudController<Comentario, Long>{
	List<Comentario> findByIdTicket(Long idTicket);

}
