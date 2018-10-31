package dsi235.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dsi235.entities.Ticket;

public interface TicketController extends AbstractCrudController<Ticket, Long>{
	
	public Page<Ticket> findCompletadosByEncargado(Long idEncargado, Pageable pg);

	//Ordenado por prioridad
	public List<Ticket> findNoCompletadosByEncargado(Long idEncargado);
	
	public Page<Ticket> findCompletadosByUsuario(Long idUsuario, Pageable pg);
	
	public List<Ticket> findNoCompletadosByUsuario(Long idUsuario);
	
	public List<Ticket> findNoAsignados(Short idSucursal, int first, int pageSize);
	
	public Ticket reabrirTicket(int idTicket);
	
	public Ticket asignarTicket(int idTicket, int... idEncargados);
	
	public Ticket marcarMalAsignado(int idTicket);
	
	public Ticket gestionarEstadoTicket(int idTicket, int idEstado);
	
	public Page<Ticket> findNoasignadosBySucursal(Short idSucursal,
			Short idEstado, Pageable pg);

	
}
