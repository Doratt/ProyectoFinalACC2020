package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.TicketController;
import dsi235.entities.Ticket;

@ManagedBean(value = "asignacionesBackingBean")
@ViewScoped
public class AsignacionesBackingBean implements Serializable {

	private static final long serialVersionUID = -9176707771226005862L;
	private LoginSessionBean sessionBean;
	private TicketController ticketController;
	
	private List<Ticket> tickets;
	
	@PostConstruct
	public void init() {
		this.tickets = ticketController.findNoCompletadosByEncargado(sessionBean.getUsuarioLogueado().getIdUsuario());   
	}
	
	
	
	
	
	
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	@Autowired
	public void setTicketController(TicketController ticketController) {
		this.ticketController = ticketController;
	}
	
	
	
}
