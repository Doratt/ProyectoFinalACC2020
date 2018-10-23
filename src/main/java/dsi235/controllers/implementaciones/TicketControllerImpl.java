/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.TicketController;
import dsi235.entities.Ticket;
import dsi235.entities.repositories.TicketRepository;

/**
 *
 * @author doratt
 */
@Controller
public class TicketControllerImpl extends AbstractCrudControllerImpl<Ticket, Long> implements TicketController{

	private TicketRepository ticketRepository;
	
	@Autowired
	public TicketControllerImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> findCompletadosByEncargado(int idEncargado, int fisrt, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findNoCompletadosByEncargado(int idEncargado, int fisrt, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findCompletadosByUsuario(int idUsuario, int fisrt, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findNoCompletadosByUsuario(Long idUsuario, Short idEstado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findNoAsignados(Short idSucursal, int fisrt, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket reabrirTicket(int idTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket asignarTicket(int idTicket, int... idEncargados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket marcarMalAsignado(int idTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket gestionarEstadoTicket(int idTicket, int idEstado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	CrudRepository<Ticket, Long> getRepository() {
		return this.ticketRepository;
	}

	@Override
	public Page<Ticket> findAll(Pageable pageable) {
		return this.ticketRepository.findAll(pageable);
	}
    
}
