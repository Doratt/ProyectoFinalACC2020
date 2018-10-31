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
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author doratt
 */
@Entity
@Table(name = "prioridad", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p")
    , @NamedQuery(name = "Prioridad.findByIdPrioridad", query = "SELECT p FROM Prioridad p WHERE p.idPrioridad = :idPrioridad")
    , @NamedQuery(name = "Prioridad.findByNombre", query = "SELECT p FROM Prioridad p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Prioridad.findByDescripcion", query = "SELECT p FROM Prioridad p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Prioridad.findByFechaCreacion", query = "SELECT p FROM Prioridad p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Prioridad.findByFechaModificacion", query = "SELECT p FROM Prioridad p WHERE p.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Prioridad.findByActivo", query = "SELECT p FROM Prioridad p WHERE p.activo = :activo")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prioridad")
    private Short idPrioridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(mappedBy = "idPrioridad")
    private List<Ticket> ticketList;
    @JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreador;
    @JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuarioModificador;

    public Prioridad() {
    }

    public Prioridad(Short idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Prioridad(Short idPrioridad, String nombre, String descripcion, Date fechaCreacion, boolean activo) {
        this.idPrioridad = idPrioridad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Short getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Short idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
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
        hash += (idPrioridad != null ? idPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.idPrioridad == null && other.idPrioridad != null) || (this.idPrioridad != null && !this.idPrioridad.equals(other.idPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dsi235.entities.Prioridad[ idPrioridad=" + idPrioridad + " ]";
    }
    
}
