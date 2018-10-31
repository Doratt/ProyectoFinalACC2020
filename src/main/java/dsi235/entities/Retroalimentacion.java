/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dsi235.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author doratt
 */
@Entity
@Table(name = "retroalimentacion", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retroalimentacion.findAll", query = "SELECT r FROM Retroalimentacion r")
    , @NamedQuery(name = "Retroalimentacion.findByIdRetroalimentacion", query = "SELECT r FROM Retroalimentacion r WHERE r.idRetroalimentacion = :idRetroalimentacion")
    , @NamedQuery(name = "Retroalimentacion.findByCalificacion", query = "SELECT r FROM Retroalimentacion r WHERE r.calificacion = :calificacion")
    , @NamedQuery(name = "Retroalimentacion.findByComentario", query = "SELECT r FROM Retroalimentacion r WHERE r.comentario = :comentario")
    , @NamedQuery(name = "Retroalimentacion.findByFechaCreacion", query = "SELECT r FROM Retroalimentacion r WHERE r.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Retroalimentacion.findByFechaModificacion", query = "SELECT r FROM Retroalimentacion r WHERE r.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Retroalimentacion.findByActivo", query = "SELECT r FROM Retroalimentacion r WHERE r.activo = :activo")})
public class Retroalimentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_retroalimentacion")
    private Long idRetroalimentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private short calificacion;
    @Size(max = 2000)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")
    @OneToOne(optional = false)
    private Ticket idTicket;
    @JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreador;
    @JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuarioModificador;

    public Retroalimentacion() {
    }

    public Retroalimentacion(Long idRetroalimentacion) {
        this.idRetroalimentacion = idRetroalimentacion;
    }

    public Retroalimentacion(Long idRetroalimentacion, short calificacion, Date fechaCreacion, boolean activo) {
        this.idRetroalimentacion = idRetroalimentacion;
        this.calificacion = calificacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Long getIdRetroalimentacion() {
        return idRetroalimentacion;
    }

    public void setIdRetroalimentacion(Long idRetroalimentacion) {
        this.idRetroalimentacion = idRetroalimentacion;
    }

    public short getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(short calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Ticket getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Ticket idTicket) {
        this.idTicket = idTicket;
    }

    public Usuario getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public void setIdUsuarioCreador(Usuario idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public Usuario getIdUsuarioModificador() {
        return idUsuarioModificador;
    }

    public void setIdUsuarioModificador(Usuario idUsuarioModificador) {
        this.idUsuarioModificador = idUsuarioModificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetroalimentacion != null ? idRetroalimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retroalimentacion)) {
            return false;
        }
        Retroalimentacion other = (Retroalimentacion) object;
        if ((this.idRetroalimentacion == null && other.idRetroalimentacion != null) || (this.idRetroalimentacion != null && !this.idRetroalimentacion.equals(other.idRetroalimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dsi235.entities.Retroalimentacion[ idRetroalimentacion=" + idRetroalimentacion + " ]";
    }
    
}
