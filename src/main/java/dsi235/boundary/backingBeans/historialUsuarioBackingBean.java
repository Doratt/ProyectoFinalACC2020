package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.TicketController;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;

@ManagedBean(value="historialUsuarioBackingBeans")
@SessionScope
public class historialUsuarioBackingBean implements Serializable{
	
	private static final long serialVersionUID = 2432906255201655180L;
	
	private Ticket ticket;
	private String descripcion;
	private Usuario usuarioLogeado;
	private TicketController tc;
	private LoginSessionBean sessionBean;
	private List<Ticket> historialTicket;
	
	@PostConstruct
    public void init() {
		historialTicket= tc.findCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario(), 1, 5);
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

	public void setTc(TicketController tc) {
		this.tc = tc;
	}

	public LoginSessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public List<Ticket> getHistorialTicket() {
		return historialTicket;
	}

	public void setHistorialTicket(List<Ticket> historialTicket) {
		this.historialTicket = historialTicket;
	}

}
