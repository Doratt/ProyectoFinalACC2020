package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.ComentarioController;
import dsi235.controllers.TicketController;
import dsi235.entities.Comentario;
import dsi235.entities.Estado;
import dsi235.entities.Ticket;
import dsi235.utilities.EstadosLoader;

@ManagedBean(value = "asignacionesBackingBean")
@ViewScoped
public class AsignacionesBackingBean implements Serializable {

	private static final long serialVersionUID = -9176707771226005862L;
	private LoginSessionBean sessionBean;
	private TicketController ticketController;
	
	private List<Ticket> tickets;
	private Ticket ticketSeleccionado;
	
	private Comentario comentario;
	private ComentarioController comentarioController;
	private List<Comentario> comentarios;
	
	private EstadosLoader el;
	private Short estadoSeleccionado;
	
	
	@PostConstruct
	public void init() {
		this.tickets = ticketController.findNoCompletadosByEncargado(sessionBean.getUsuarioLogueado().getIdUsuario());   
		setComentario(new Comentario());
		
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
	
	public void mostrarEstadoSeleccionado() {
		System.out.println(estadoSeleccionado);
	}
	
	public void cargarComentarios() {
		estadoSeleccionado=Short.valueOf(String.valueOf((ticketSeleccionado.getIdEstado().getIdEstado()-1)));
		setComentarios(comentarioController.findByIdTicket(ticketSeleccionado));
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
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	@Autowired
	public void setComentarioController(ComentarioController comentarioController) {
		this.comentarioController = comentarioController;
	}
	@Autowired
	public void setEl(EstadosLoader el) {
		this.el = el;
	}

	public Short getEstadoSeleccionado() {
		return estadoSeleccionado;
	}

	public void setEstadoSeleccionado(Short estadoSeleccionado) {
		this.estadoSeleccionado = estadoSeleccionado;
	}

	
	
	
}
