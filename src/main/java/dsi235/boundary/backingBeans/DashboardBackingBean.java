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
import dsi235.entities.Ticket;
import dsi235.entities.TicketEncargado;
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
	private NotificationController nc;
	private TicketEncargadoController tec;


	@PostConstruct
	public void init() {
		setTicketsPendientes(tc.findNoCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario()));
		setComentario(new Comentario());
	}

	
	public void reload() {
		init();
	}
	
	public void crearTicket() {
		System.out.println("Llegue al metodo");
		setTicket(new Ticket());
		ticket.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
		if (getDescripcion().length() <= 3000 && getDescripcion().length() > 25) {
			System.out.println("Pase del if");
			ticket.setDescripcion(getDescripcion());
			ticket.setIdEstado(el.get(ESTADO.creado.value));
			ticket.setActivo(true);
			descripcion = null;
			try {
				System.out.println("Entre al try");
				tc.save(getTicket());
				StringBuilder contenido = new StringBuilder().append("Saludos ")
						.append(sessionBean.getUsuarioLogueado().getNombre())
						.append(", su ticket ha sido creado y esta en espera de ser asignado"
								+ ", le mantendremos al tanto del proceso.");
				nc.enviarCorreo(sessionBean.getUsuarioLogueado(), contenido.toString());
				init();
				PrimeFaces current = PrimeFaces.current();
				this.ticket = new Ticket();
				current.executeScript("PF('createTicket').hide()");
				 FacesContext context = FacesContext.getCurrentInstance();
		         
			        context.addMessage(null, new FacesMessage("Éxito",  "Ticket creado exitosamente") );
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
					StringBuilder contenido = new StringBuilder().append("Saludos estimado ")
							.append(ticketEncargado.getIdUsuario().getNombre())
							.append(", le informamos que hay un nuevo comentario en uno de sus tickets asignados");
					nc.enviarCorreo(ticketEncargado.getIdUsuario(), contenido.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error!", "Hubo un problema con la creación del comentario"));
			}
		} else {
			System.out.println("contenido isempty");
		}
	}
	
	public void cancelarTicket() {
		System.out.println("Llegue al metodo");
		ticketSeleccionado.setFechaCompletado(new Date());
		ticketSeleccionado.setFechaModificacion(new Date());
		ticketSeleccionado.setIdEstado(el.get(ESTADO.completado.value));
		ticketSeleccionado.setIdUsuarioModificador(sessionBean.getUsuarioLogueado());
		try {
			List<TicketEncargado> encargados = tec.findByIdTicket_IdTicket(ticketSeleccionado.getIdTicket());
			System.out.println("Lista de encargados:"+encargados);
			if(encargados!=null && !encargados.isEmpty()) {
				System.out.println("encargados no es null ni esta vacio");
				for (TicketEncargado ticketEncargado : encargados) {
					StringBuilder contenido = new StringBuilder().append("Saludos estimado ")
							.append(ticketEncargado.getIdUsuario().getNombre())
							.append(", le informamos que el ticket #")
							.append(ticketSeleccionado.getIdTicket())
							.append("\n que estaba asignado a usted, ha sido cancelado por su solicitante");
					nc.enviarCorreo(ticketEncargado.getIdUsuario(), contenido.toString());
				}
			}
			tc.save(ticketSeleccionado);
			init();
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Cancelado",  "Ticket cancelado") );
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error!", "Hubo un problema al cancelar su ticket"));
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
	
	

}
