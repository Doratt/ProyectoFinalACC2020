package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(value = "costosBackingBean")
@ViewScoped
public class CostosBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date fechaInicio;
	private Date fechaFin;
	
	
	
	
	
	
	
	
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

}
