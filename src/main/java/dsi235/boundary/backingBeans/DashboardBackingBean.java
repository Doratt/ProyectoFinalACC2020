package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.PostUpdate;

import org.primefaces.PrimeFaces;
import org.primefaces.push.annotation.OnOpen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.ComentarioController;
import dsi235.controllers.NotificationController;
import dsi235.controllers.TicketController;
import dsi235.controllers.TicketEncargadoController;
import dsi235.entities.Comentario;
import dsi235.entities.Correlativo;
import dsi235.entities.Prioridad;
import dsi235.entities.Ticket;
import dsi235.entities.TicketEncargado;
import dsi235.entities.TipoMantenimiento;
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

	private NotificationController nc;
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
	private TicketEncargadoController tec;
	private Correlativo correlativo = new Correlativo();
	
	@PostConstruct
	public void init() {
		setTicketsPendientes(tc.findNoCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario()));
		setComentario(new Comentario());
		correlativo = new Correlativo();
	}

	public void reload() {
		init();
	}

	public void crearTicket() {
		setTicket(new Ticket());
		ticket.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
		
		if (getDescripcion().length() <= 3000 && getDescripcion().length() > 25) {
			ticket.setDescripcion(getDescripcion());
			ticket.setIdEstado(el.get(ESTADO.creado.value));
			ticket.setActivo(true);
			descripcion = null;
			ticket.setCorrelativo(correlativo);
			ticket.setIdTipoMantenimiento(new TipoMantenimiento(3));
			ticket.setIdPrioridad(new Prioridad( (short) 3 ));
			try {
				PrimeFaces current = PrimeFaces.current();
				tc.save(getTicket());
				current.executeScript("PF('createTicket').hide()");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Exito", "Ticket creado exitosamente"));
				StringBuilder contenido = new StringBuilder()

						.append("<!DOCTYPE html>\n" + "<html>\n" + "    <head>\n"
								+ "        <title>Ticket System e-mail</title>\n"
								+ "        <p style=\"font-family: calibri, serif; font-size:20pt; color:#73ad41\"><b>Ticket System</b></p>\n"
								+ "    </head>\n" + "    <body>\n"
								+ "        <p style=\"font-family: calibri, serif; font-size:14pt; font-style:bold; color:black\"><i>Saludos</i>\n"
								+ sessionBean.getUsuarioLogueado().getNombre()
								+ "        <br>Queremos informarle que su ticket fue exitosamente creado y esta en espera a ser asignado.\n"
								+ "        <br>Le mantendremos informado sobre el proceso\n" + "        </p>\n"
								+ "    </body>\n"
								+ "    <footer><p  style=\"font-family: calibri, serif; font-size:12pt; color: black\"><b>Muchas gracias por utilizar nuestros servicios</b></p></footer>\n"
								+ "</html>\n" + "");
				init();
				this.ticket = new Ticket();
				nc.enviarCorreo(sessionBean.getUsuarioLogueado(), contenido.toString());
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error!", "Parece que hubo un problema con la creación de tu ticket"));
				e.printStackTrace();
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

				List<TicketEncargado> encargados = tec.findByIdTicket_IdTicket(ticketSeleccionado.getIdTicket());
				for (TicketEncargado ticketEncargado : encargados) {
					StringBuilder contenido = new StringBuilder().append("<!DOCTYPE html>\n" + "<html>\n"
							+ "    <head>\n" + "        <title>Ticket System e-mail</title>\n"
							+ "        <p style=\"font-family: calibri, serif; font-size:20pt; color:#73ad41\"><b>Ticket System</b></p>\n"
							+ "    </head>\n" + "    <body>\n"
							+ "        <p style=\"font-family: calibri, serif; font-size:14pt; font-style:bold; color:black\"><i>Saludos</i>\n"
							+ ticketEncargado.getIdUsuario().getNombre()
							+ "        <br>Le informamos que hay un nuevo comentario en uno de sus tickets asignados\n"
							+ "        <br>Puede revisar todos los comentarios en la aplicacion\n" + "        </p>\n"
							+ "    </body>\n"
							+ "    <footer><p  style=\"font-family: calibri, serif; font-size:12pt; color: black\"><b>Muchas gracias por utilizar nuestros servicios</b></p></footer>\n"
							+ "</html>\n" + "");
					nc.enviarCorreo(ticketEncargado.getIdUsuario(), contenido.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error!", "Hubo un problema con la creación del comentario"));
			}
		} else {
		}
	}

	public void cancelarTicket() {
		ticketSeleccionado.setFechaCompletado(new Date());
		ticketSeleccionado.setFechaModificacion(new Date());
		ticketSeleccionado.setIdEstado(el.get(ESTADO.completado.value));
		ticketSeleccionado.setIdUsuarioModificador(sessionBean.getUsuarioLogueado());
		try {
			tc.save(ticketSeleccionado);
			init();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Cancelado", "Ticket cancelado"));
			
			List<TicketEncargado> encargados = tec.findByIdTicket_IdTicket(ticketSeleccionado.getIdTicket());
			if (encargados != null && !encargados.isEmpty()) {
				for (TicketEncargado ticketEncargado : encargados) {
					StringBuilder contenido = new StringBuilder().append("<!DOCTYPE html>\n" + "<html>\n"
							+ "    <head>\n" + "        <title>Ticket System e-mail</title>\n"
							+ "        <p style=\"font-family: calibri, serif; font-size:20pt; color:#73ad41\"><b>Ticket System</b></p>\n"
							+ "    </head>\n" + "    <body>\n"
							+ "        <p style=\"font-family: calibri, serif; font-size:14pt; font-style:bold; color:black\"><i>Saludos</i>\n"
							+ ticketEncargado.getIdUsuario().getNombre() + "        <br>Le informamos que el ticket "
							+ ticketSeleccionado.getIdTicket() + "ha sido cancelado por el solicitante.\n"
							+ "        <br>Ya no aparecera asignado a usted. Puede verificar en el sistema.\n"
							+ "        </p>\n" + "    </body>\n"
							+ "    <footer><p  style=\"font-family: calibri, serif; font-size:12pt; color: black\"><b>Muchas gracias por utilizar nuestros servicios</b></p></footer>\n"
							+ "</html>");
					nc.enviarCorreo(ticketEncargado.getIdUsuario(), contenido.toString());
				}
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Hubo un problema al cancelar su ticket"));
			e.printStackTrace();
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

	@Autowired
	public void setNc(NotificationController nc) {
		this.nc = nc;
	}

	@Autowired
	public void setTec(TicketEncargadoController tec) {
		this.tec = tec;
	}

	public Correlativo getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Correlativo correlativo) {
		this.correlativo = correlativo;
	}
	
	

}
