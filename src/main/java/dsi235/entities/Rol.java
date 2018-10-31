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
import javax.persistence.CascadeType;
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
@Table(name = "rol", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.idRol = :idRol")
    , @NamedQuery(name = "Rol.findByNombre", query = "SELECT r FROM Rol r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Rol.findByFechaCreacion", query = "SELECT r FROM Rol r WHERE r.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Rol.findByFechaModificacion", query = "SELECT r FROM Rol r WHERE r.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Rol.findByActivo", query = "SELECT r FROM Rol r WHERE r.activo = :activo")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Short idRol;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<UsuarioRol> usuarioRolList;
    @JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreador;
    @JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuarioModificador;

    public Rol() {
    }

    public Rol(Short idRol) {
        this.idRol = idRol;
    }

    public Rol(Short idRol, String nombre, String descripcion, Date fechaCreacion, boolean activo) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Short getIdRol() {
        return idRol;
    }

    public void setIdRol(Short idRol) {
        this.idRol = idRol;
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
    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dsi235.entities.Rol[ idRol=" + idRol + " ]";
    }
    
}
