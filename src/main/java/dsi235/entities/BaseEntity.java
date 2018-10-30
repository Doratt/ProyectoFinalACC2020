package dsi235.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BaseEntity  implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreador;
    
	@Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
	@JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuarioModificador;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;

    
	public Usuario getIdUsuarioCreador() {
		return idUsuarioCreador;
	}

	public void setIdUsuarioCreador(Usuario idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getIdUsuarioModificador() {
		return idUsuarioModificador;
	}

	public void setIdUsuarioModificador(Usuario idUsuarioModificador) {
		this.idUsuarioModificador = idUsuarioModificador;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
    
}
