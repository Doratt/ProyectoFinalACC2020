package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.TicketController;
import dsi235.controllers.implementaciones.TicketControllerImpl;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;

@ManagedBean(value="ticketbb")
@SessionScope
public class TicketBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2432906255201655180L;

	private Ticket ticket;
	private String descripcion;
	private Usuario usuarioLogeado;
	private TicketController tc;
	
	
	public void crearTicket() {
		setTicket(new Ticket());
		ticket.setDescripcion(getDescripcion());
		ticket.setFechaSolicitud(Date.from(Instant.now()));
		try {
			tc.save(getTicket());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Su ticket se creo con éxito"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Parece que hubo un problema con la creación de tu ticket"));
		}
		
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}


	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}


	public TicketController getTc() {
		return tc;
	}

	@Autowired
	public void setTc(TicketController tc) {
		this.tc = tc;
	}
	
	
}


