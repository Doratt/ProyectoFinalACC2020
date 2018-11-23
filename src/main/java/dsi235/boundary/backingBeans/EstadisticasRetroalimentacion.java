package dsi235.boundary.backingBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.EstadisticaController;
import dsi235.controllers.UsuarioController;
import dsi235.entities.Retroalimentacion;
import dsi235.entities.Sucursal;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
import dsi235.entities.estadisticas.NumeroTickets;

@ManagedBean(value = "estadisticasBackingBean")
@ViewScoped
public class EstadisticasRetroalimentacion {

	private String parametro = "Sucursal";
	private Date fechaInicio;
	private Date fechaFin;
	private Short idSucursal = Short.valueOf("1");
	private Integer idDepartamento = 1;
	private List<Ticket> lista;
	private List<NumeroTickets> listaNumero;
	private EstadisticaController ec;
	private Usuario tecnico;
	private List<Usuario> tecnicos;
	private UsuarioController uc;

	public boolean isSucursalSeleccionado() {
		return parametro.equals("Sucursal");
	}

	public boolean isDepartamentoSeleccionado() {
		return parametro.equals("Departamento");
	}

	public boolean isTecnicoSeleccionado() {
		return parametro.equals("Tecnico");
	}

	@PostConstruct
	public void init() {
		this.tecnicos = this.uc.findAll();
	}

	public void buscar() {

		if (fechaInicio.getTime() > fechaFin.getTime()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"La fecha de finalización debe ser mayor que la fecha de inicio"));
		} else {

			if (isSucursalSeleccionado()) {
				lista = ec.verRetroalimentacion(fechaInicio, fechaFin, idSucursal, null, null);
			} else if (isDepartamentoSeleccionado()) {
				lista = ec.verRetroalimentacion(fechaInicio, fechaFin, null, idDepartamento, null);
			} else if (isTecnicoSeleccionado()) {
				if (tecnico == null) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Seleccione el Técnico"));
				} else {
					lista = ec.verRetroalimentacion(fechaInicio, fechaFin, null, null, this.tecnico.getIdUsuario());

				}
			}
		}
	}

	public void buscarNumero() {

		if (fechaInicio.getTime() > fechaFin.getTime()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"La fecha de finalización debe ser mayor que la fecha de inicio"));
		} else {

			if (isSucursalSeleccionado()) {
				listaNumero = ec.calcularNumTicketsSucursal(fechaInicio, fechaFin, idSucursal);
			} else if (isDepartamentoSeleccionado()) {
				listaNumero = ec.calcularNumTicketsDepto(fechaInicio, fechaFin, idDepartamento);
			} else if (isTecnicoSeleccionado()) {

				listaNumero = ec.calcularNumTicketsTecnico(fechaInicio, fechaFin);

			}
		}
	}

	@Autowired
	public void setEc(EstadisticaController ec) {
		this.ec = ec;
	}

	public List<Ticket> getLista() {
		return lista;
	}

	public void setLista(List<Ticket> lista) {
		this.lista = lista;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Short getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Short idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario ticket) {
		this.tecnico = ticket;
	}

	public List<Usuario> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Usuario> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public UsuarioController getUc() {
		return uc;
	}

	@Autowired
	public void setUc(UsuarioController uc) {
		this.uc = uc;
	}

	public List<NumeroTickets> getListaNumero() {
		return listaNumero;
	}

	public void setListaNumero(List<NumeroTickets> listaNumero) {
		this.listaNumero = listaNumero;
	}

}
