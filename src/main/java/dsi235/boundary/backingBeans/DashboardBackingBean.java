package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.ComentarioController;
import dsi235.controllers.TicketController;
import dsi235.entities.Comentario;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
import dsi235.utilities.ESTADO;
import dsi235.utilities.EstadosLoader;

@ManagedBean(value = "dashboardBackingBean")
@SessionScope
public class DashboardBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2432906255201655180L;

	private Ticket ticket;
	private Ticket ticketSeleccionado;
	private String descripcion;
	private Usuario usuarioLogeado;
	private TicketController tc;
	private LoginSessionBean sessionBean;
	private EstadosLoader el;
	private List<Ticket> ticketsPendientes;
	private Comentario comentario;
	private ComentarioController comentarioController;
	private List<Comentario> comentarios;

	@PostConstruct
	public void init() {
		setTicketsPendientes(tc.findNoCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario()));
		setComentario(new Comentario());
	}

	public void crearTicket() {
		setTicket(new Ticket());
		ticket.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
		if (getDescripcion().length() <= 3000 && getDescripcion().length() > 25) {

			ticket.setDescripcion(getDescripcion());
			ticket.setIdEstado(el.get(ESTADO.creado.value));
			descripcion = null;
			try {
				tc.save(getTicket());
				init();
				PrimeFaces current = PrimeFaces.current();
				this.ticket = new Ticket();
				current.executeScript("PF('createTicket').hide()");
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error!", "Parece que hubo un problema con la creación de tu ticket"));
			}
		}
	}

	public void crearComentario() {

		if (!comentario.getContenido().isEmpty()) {
			comentario.setActivo(true);
			comentario.setFechaCreacion(new Date());
			comentario.setIdTicket(this.ticketSeleccionado);
			comentario.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
			try {
				comentarioController.save(comentario);
				this.comentario = new Comentario();
				cargarComentarios();
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error!", "Hubo un problema con la creación del comentario"));
			}
		} else {
			System.out.println("contenido isempty");
		}
	}
	
	public void cargarComentarios() {
		setComentarios(comentarioController.findByIdTicket(ticketSeleccionado));
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

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	@Autowired
	public void setEl(EstadosLoader el) {
		this.el = el;
	}

	public List<Ticket> getTicketsPendientes() {
		return ticketsPendientes;
	}

	public void setTicketsPendientes(List<Ticket> ticketsPendientes) {
		this.ticketsPendientes = ticketsPendientes;
	}

	public Ticket getTicketSeleccionado() {
		return ticketSeleccionado;
	}

	public void setTicketSeleccionado(Ticket ticketSeleccionado) {
		this.ticketSeleccionado = ticketSeleccionado;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	@Autowired
	public void setComentarioController(ComentarioController comentarioController) {
		this.comentarioController = comentarioController;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

}
