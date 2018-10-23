package dsi235.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dsi235.entities.Ticket;

public interface TicketController extends AbstractCrudController<Ticket, Long>{
	
	public List<Ticket> findCompletadosByEncargado(int idEncargado, int fisrt, int pageSize);

	//Ordenado por prioridad
	public List<Ticket> findNoCompletadosByEncargado(int idEncargado, int fisrt, int pageSize);
	
	public List<Ticket> findCompletadosByUsuario(Long idUsuario, int fisrt, int pageSize);
	
	public List<Ticket> findNoCompletadosByUsuario(Long idUsuario, Short idEstado);
	
	public List<Ticket> findNoAsignados(Short idSucursal, int fisrt, int pageSize);
	
	public Ticket reabrirTicket(int idTicket);
	
	public Ticket asignarTicket(int idTicket, int... idEncargados);
	
	public Ticket marcarMalAsignado(int idTicket);
	
	public Ticket gestionarEstadoTicket(int idTicket, int idEstado);
	
	public Page<Ticket> findAll(Pageable pageable);

	
}
