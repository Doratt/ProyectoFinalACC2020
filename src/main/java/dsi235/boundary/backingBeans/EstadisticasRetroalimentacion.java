package dsi235.boundary.backingBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.EstadisticaController;
import dsi235.entities.Retroalimentacion;
import dsi235.entities.Sucursal;
import dsi235.entities.Ticket;

@ManagedBean(value = "estadisticasBackingBean")
@ViewScoped
public class EstadisticasRetroalimentacion {
	
	private String parametro = "Sucursal";
	private Date fechaInicio;
	private Date fechaFin;
	private Short idSucursal = Short.valueOf("1");
	private Integer idDepartamento = 1;
	private Long idTecnico;
	private List<Ticket> lista;
	private EstadisticaController ec;
	
	
	
	public boolean isSucursalSeleccionado() {
		return parametro.equals("Sucursal");
	}
	public boolean isDepartamentoSeleccionado() {
		return parametro.equals("Departamento");
	}
	public boolean isTecnicoSeleccionado() {
		return parametro.equals("Tecnico");
	}
	
	
	public void buscar() {
		
		if(isSucursalSeleccionado()) {
			System.out.println(idSucursal);
			lista = ec.verRetroalimentacion(fechaInicio, fechaFin, idSucursal, null, null);
		}else if(isDepartamentoSeleccionado()) {
			lista = ec.verRetroalimentacion(fechaInicio, fechaFin, null, idDepartamento, null);
		}else if(isTecnicoSeleccionado()) {
			lista = ec.verRetroalimentacion(fechaInicio, fechaFin, null, null, idTecnico);
		}
		
		System.out.println("lista:");
		lista.forEach( (t)->{
			System.out.println(t.getIdTicket());
		} );
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
	public Long getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(Long idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	
}
