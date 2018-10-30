package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.TicketController;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;

@ManagedBean(value="historialUsuarioBackingBean")
@SessionScope
public class historialUsuarioBackingBean implements Serializable{
	
	private static final long serialVersionUID = 2432906255201655180L;
	
	private Ticket ticket;
	private Usuario usuarioLogeado;
	private TicketController tc;
	private LoginSessionBean sessionBean;
	private Page<Ticket> historialTicketUsuario;
	private Page<Ticket> historialTicketTecnico;
	
	
	@PostConstruct
    public void init() {
		System.out.println(sessionBean.getUsuarioLogueado().getIdUsuario());
		historialTicketUsuario= this.tc.findCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario(), 0, 5);
		System.out.println(historialTicketUsuario);
		historialTicketTecnico= tc.findCompletadosByEncargado(sessionBean.getUsuarioLogueado().getIdUsuario(), 1, 5);
	}
	
	public Page<Ticket> getHistorialTicketTecnico() {
		return historialTicketTecnico;
	}

	public void setHistorialTicketTecnico(Page<Ticket> historialTicketTecnico) {
		this.historialTicketTecnico = historialTicketTecnico;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
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

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public Page<Ticket> getHistorialTicketUsuario() {
		return historialTicketUsuario;
	}

	public void setHistorialTicketUsuario(Page<Ticket> historialTicket) {
		this.historialTicketUsuario = historialTicket;
	}

}
