package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.ComentarioController;
import dsi235.controllers.NotificationController;
import dsi235.controllers.TicketController;
import dsi235.controllers.TicketEncargadoController;
import dsi235.entities.Comentario;
import dsi235.entities.Estado;
import dsi235.entities.Ticket;
import dsi235.entities.TicketEncargado;
import dsi235.utilities.ESTADO;
import dsi235.utilities.EstadosLoader;

@ManagedBean(value = "asignacionesBackingBean")
@ViewScoped
public class AsignacionesBackingBean implements Serializable {

	private static final long serialVersionUID = -9176707771226005862L;
	private LoginSessionBean sessionBean;
	private TicketController ticketController;
	private NotificationController nc;

	private List<Ticket> tickets;
	private Ticket ticketSeleccionado;

	private Comentario comentario;
	private ComentarioController comentarioController;
	private List<Comentario> comentarios;

	private EstadosLoader el;
	private Short estadoSeleccionado;

	private TicketEncargadoController tec;
	private List<TicketEncargado> asignados;

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
		}
	}

	public void cargarComentarios() {
		setEstadoSeleccionado(Short.valueOf(String.valueOf(ticketSeleccionado.getIdEstado().getIdEstado() - 1)));
		setComentarios(comentarioController.findByIdTicket(ticketSeleccionado));
	}

	public void marcarMalAsignado() {

		ticketSeleccionado.setIdEstado(el.get(ESTADO.creado.value));
		asignados = tec.findByIdTicket_IdTicket(ticketSeleccionado.getIdTicket());
		for (TicketEncargado ticketEncargado : asignados) {
			ticketEncargado.setActivo(false);
			StringBuilder contenido = new StringBuilder().append("<!DOCTYPE html>\n" + "<html>\n" + "    <head>\n"
					+ "        <title>Ticket System e-mail</title>\n"
					+ "        <p style=\"font-family: calibri, serif; font-size:20pt; color:#73ad41\"><b>Ticket System</b></p>\n"
					+ "    </head>\n" + "    <body>\n"
					+ "        <p style=\"font-family: calibri, serif; font-size:14pt; font-style:bold; color:black\"><i>Saludos</i>\n"
					+ "        <br>Le informamos que " + ticketEncargado.getIdUsuarioCreador().getNombre()
					+ " uno de los tecnicos a quien usted asigno el ticket con la descripcion:\n"
					+ ticketEncargado.getIdTicket().getDescripcion()
					+ "\n ha marcado el ticket como mal asignado. Ha vuelto a las asignaciones pendientes.\n"
					+ "        <br>Por favor asignar a un tecnico/s lo mas antes posible.\n" + "        </p>\n"
					+ "    </body>\n"
					+ "    <footer><p  style=\"font-family: calibri, serif; font-size:12pt; color: black\"><b>Muchas gracias por utilizar nuestros servicios</b></p></footer>\n"
					+ "</html>\n" + "");
			nc.enviarCorreo(ticketEncargado.getIdUsuarioCreador(), contenido.toString());
			try {
				tec.save(ticketEncargado);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			ticketController.save(ticketSeleccionado);
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		init();

		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('infoTicket').hide()");

	}

	public void modificarEstadoTicket() {
		if (estadoSeleccionado != 0) {
			if ((estadoSeleccionado + 1) != ticketSeleccionado.getIdEstado().getIdEstado()) {
				ticketSeleccionado.setIdUsuarioModificador(sessionBean.getUsuarioLogueado());
				ticketSeleccionado.setFechaModificacion(new Date());
				if (estadoSeleccionado == ESTADO.completado.value) {
					ticketSeleccionado.setFechaCompletado(new Date());
					asignados = tec.findByIdTicket_IdTicket(ticketSeleccionado.getIdTicket());
					for (TicketEncargado ticketEncargado : asignados) {
						ticketEncargado.setActivo(false);
						ticketEncargado.setFechaModificacion(new Date());
						ticketEncargado.setIdUsuarioModificador(sessionBean.getUsuarioLogueado());
						try {
							tec.save(ticketEncargado);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					StringBuilder contenido = new StringBuilder().append("<!DOCTYPE html>\n" + "<html>\n"
							+ "    <head>\n" + "        <title>Ticket System e-mail</title>\n"
							+ "        <p style=\"font-family: calibri, serif; font-size:20pt; color:#73ad41\"><b>Ticket System</b></p>\n"
							+ "    </head>\n" + "    <body>\n"
							+ "        <p style=\"font-family: calibri, serif; font-size:14pt; font-style:bold; color:black\"><i>Saludos</i>\n"
							+ ticketSeleccionado.getIdUsuarioCreador().getNombre()
							+ "        <br>Le informamos que su problema ha sido resuelto exitosamente\n"
							+ "        <br>Lo invitamos a asignar una calificacion a la solucion del problema desde su aplicacion, puede dejar un comentario para mejorar el servicio para usted.\n"
							+ "        </p>\n" + "    </body>\n"
							+ "    <footer><p  style=\"font-family: calibri, serif; font-size:12pt; color: black\"><b>Muchas gracias por utilizar nuestros servicios</b></p></footer>\n"
							+ "</html>\n" + "");
					nc.enviarCorreo(ticketSeleccionado.getIdUsuarioCreador(), contenido.toString());
				}
				ticketSeleccionado.setIdEstado(el.get(estadoSeleccionado));
				try {
					ticketController.save(ticketSeleccionado);
				} catch (Exception e) {
					e.printStackTrace();
				}
				init();
				PrimeFaces current = PrimeFaces.current();
				current.executeScript("PF('infoTicket').hide()");
			}
		}
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

	@Autowired
	public void setTec(TicketEncargadoController tec) {
		this.tec = tec;
	}

	public List<TicketEncargado> getAsignados() {
		return asignados;
	}

	public void setAsignados(List<TicketEncargado> asignados) {
		this.asignados = asignados;
	}

	public NotificationController getNc() {
		return nc;
	}

	@Autowired
	public void setNc(NotificationController nc) {
		this.nc = nc;
	}

}
