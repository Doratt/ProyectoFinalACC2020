/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers.implementaciones;

import java.time.Instant;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Ticket save(Ticket ticket) {
		ticket.setFechaSolicitud(Date.from(Instant.now()));
		return this.ticketRepository.save(ticket);
	}
	@Override
	public Page<Ticket> findCompletadosByEncargado(Long idEncargado, Pageable pg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findNoCompletadosByEncargado(Long idEncargado) {
		return this.ticketRepository.findNoCompletadosByEncargado(idEncargado, Short.valueOf("5"));
	}

	@Override
	public Page<Ticket> findCompletadosByUsuario(Long idUsuario, Pageable pg) {
	return this.ticketRepository.findByIdUsuario_IdUsuarioAndIdEstado_IdEstado(idUsuario, Short.valueOf("5"), pg);
	}

	@Override
	public List<Ticket> findNoCompletadosByUsuario(Long idUsuario) {
		
		return this.ticketRepository.findByIdUsuario_IdUsuarioAndIdEstado_IdEstadoNot(idUsuario, Short.valueOf("5"));
	}

	@Override
	public List<Ticket> findNoAsignados(Short idSucursal, int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket reabrirTicket(int idTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Ticket asignarTicket(int idTicket, int... idEncargados) {
		// TODO Auto-generated method stub
		return null;
	}*/

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
	public Page<Ticket> findNoasignadosBySucursal(Short idSucursal, Short idEstado, Pageable pg) {
		return this.ticketRepository.findByIdEstado_IdEstadoInAndIdUsuario_IdSucursal_IdSucursal(idSucursal, idEstado, pg);
	}

	


    
}
