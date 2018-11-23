package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.primefaces.PrimeFaces;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.RetroalimentacionController;
import dsi235.controllers.TicketController;
import dsi235.entities.Retroalimentacion;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
import dsi235.utilities.ESTADO;
import dsi235.utilities.EstadosLoader;
import dsi235.utilities.PageParser;

@ManagedBean(value = "historialUsuarioBackingBean")
@SessionScope
public class historialUsuarioBackingBean implements Serializable {

	private static final long serialVersionUID = 2432906255201655180L;

	private LazyDataModel<Ticket> model;
	private Ticket ticket;
	private Usuario usuarioLogeado;
	private TicketController tc;
	private LoginSessionBean sessionBean;
	private Page<Ticket> historialTicketUsuario;
	private Short calificacion;
	private String comentario;
	private RetroalimentacionController rc;
	private Retroalimentacion retroalimentacion;
	private EstadosLoader el;
	private boolean calificado;

	@PostConstruct
	public void init() {
		usuarioLogeado = sessionBean.getUsuarioLogueado();
		inicializarModelo();
		// historialTicketUsuario=
		// this.tc.findCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario(),
		// 0, 5);
		// System.out.println(historialTicketUsuario);
		// historialTicketTecnico=
		// tc.findCompletadosByEncargado(sessionBean.getUsuarioLogueado().getIdUsuario(),
		// 1, 5);
	}

	public void checkIfCalificado() {
		if (ticket.getRetroalimentacion() != null) {
			calificacion = ticket.getRetroalimentacion().getCalificacion();
			comentario = ticket.getRetroalimentacion().getComentario();
			calificado = true;
		} else {
			comentario = "";
			calificacion = 0;
			calificado = false;
		}
	}

	public void calificarTicket() {

		retroalimentacion = new Retroalimentacion();
		retroalimentacion.setCalificacion(calificacion);
		if (!comentario.isEmpty()) {
			retroalimentacion.setComentario(comentario);
		}
		retroalimentacion.setFechaCreacion(new Date());
		retroalimentacion.setIdTicket(ticket);
		retroalimentacion.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
		retroalimentacion.setActivo(true);
		try {
			rc.save(retroalimentacion);
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('calificarTicket').hide()");
			calificacion = 0;
			comentario = "";
			inicializarModelo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reabrirTicket() {
		Ticket nuevoTicket = new Ticket();
		nuevoTicket.setComentarioList(ticket.getComentarioList());
		nuevoTicket.setDescripcion(
				"Este ticket hace referencia al ticket#" + ticket.getIdTicket() + "\n" + ticket.getDescripcion());
		nuevoTicket.setFechaCreacion(new Date());
		nuevoTicket.setActivo(true);
		nuevoTicket.setIdEstado(el.get(ESTADO.creado.value));
		nuevoTicket.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
		try {
			tc.save(nuevoTicket);
		} catch (Exception e) {
		}

	}

	public void inicializarModelo() {
		try {
			model = new LazyDataModel<Ticket>() {

				@Override
				public Ticket getRowData(String rowKey) {
					return obtenerRowData(rowKey);
				}

				@Override
				public Object getRowKey(Ticket object) {
					return obtenerRowKey(object);
				}

				@Override
				public List<Ticket> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					return cargarDatos(first, pageSize, sortField, sortOrder, filters);
				}
			};
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	public Object obtenerRowKey(Ticket object) {
		if (object != null) {
			return object.getIdTicket();
		}
		return null;
	}

	public Ticket obtenerRowData(String rowKey) {
		try {
			List<Ticket> registros = (List<Ticket>) this.model.getWrappedData();
			if (registros != null && !registros.isEmpty()) {
				Long buscado = Long.parseLong(rowKey);
				for (Ticket r : registros) {
					if (r.getIdTicket().compareTo(buscado) == 0) {
						return r;
					}
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	public List<Ticket> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Ticket> salida = null;
		Page<Ticket> page = null;
		try {
			if (this.tc != null) {
				page = tc.findCompletadosByUsuario(usuarioLogeado.getIdUsuario(),
						PageRequest.of(PageParser.parsePage(first, pageSize), pageSize));
				salida = page.getContent();
				if (this.model != null) {
					this.model.setRowCount((Integer.valueOf(String.valueOf(page.getTotalElements()))));
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			if (salida == null) {
				salida = Collections.emptyList();
			}
		}
		return salida;
	}

	public LazyDataModel<Ticket> getModel() {
		return model;
	}

	public void setModel(LazyDataModel<Ticket> model) {
		this.model = model;
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

	public Short getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Short calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public RetroalimentacionController getRc() {
		return rc;
	}

	@Autowired
	public void setRc(RetroalimentacionController rc) {
		this.rc = rc;
	}

	public Retroalimentacion getRetroalimentacion() {
		return retroalimentacion;
	}

	public void setRetroalimentacion(Retroalimentacion retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}

	@Autowired
	public void setEl(EstadosLoader el) {
		this.el = el;
	}

	public boolean isCalificado() {
		return calificado;
	}

	public void setCalificado(boolean calificado) {
		this.calificado = calificado;
	}

}
