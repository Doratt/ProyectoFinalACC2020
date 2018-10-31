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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author doratt
 */
@Entity
@Table(name = "usuario", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByActivo", query = "SELECT u FROM Usuario u WHERE u.activo = :activo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<Estado> estadoList;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<Estado> estadoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TicketEncargado> ticketEncargadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<TicketEncargado> ticketEncargadoList1;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<TicketEncargado> ticketEncargadoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<Ticket> ticketList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch=FetchType.EAGER)
    private List<UsuarioRol> usuarioRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<UsuarioRol> usuarioRolList1;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<UsuarioRol> usuarioRolList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<UsuarioProfesion> usuarioProfesionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<Comentario> comentarioList;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<Comentario> comentarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<Prioridad> prioridadList;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<Prioridad> prioridadList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<Rol> rolList;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<Rol> rolList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreador")
    private List<Retroalimentacion> retroalimentacionList;
    @OneToMany(mappedBy = "idUsuarioModificador")
    private List<Retroalimentacion> retroalimentacionList1;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne(optional = false)
    private Cargo idCargo;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String nombre, String correo, String contrasena, boolean activo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.activo = activo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    @XmlTransient
    public List<Estado> getEstadoList1() {
        return estadoList1;
    }

    public void setEstadoList1(List<Estado> estadoList1) {
        this.estadoList1 = estadoList1;
    }

    @XmlTransient
    public List<TicketEncargado> getTicketEncargadoList() {
        return ticketEncargadoList;
    }

    public void setTicketEncargadoList(List<TicketEncargado> ticketEncargadoList) {
        this.ticketEncargadoList = ticketEncargadoList;
    }

    @XmlTransient
    public List<TicketEncargado> getTicketEncargadoList1() {
        return ticketEncargadoList1;
    }

    public void setTicketEncargadoList1(List<TicketEncargado> ticketEncargadoList1) {
        this.ticketEncargadoList1 = ticketEncargadoList1;
    }

    @XmlTransient
    public List<TicketEncargado> getTicketEncargadoList2() {
        return ticketEncargadoList2;
    }

    public void setTicketEncargadoList2(List<TicketEncargado> ticketEncargadoList2) {
        this.ticketEncargadoList2 = ticketEncargadoList2;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<Ticket> getTicketList1() {
        return ticketList1;
    }

    public void setTicketList1(List<Ticket> ticketList1) {
        this.ticketList1 = ticketList1;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList1() {
        return usuarioRolList1;
    }

    public void setUsuarioRolList1(List<UsuarioRol> usuarioRolList1) {
        this.usuarioRolList1 = usuarioRolList1;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList2() {
        return usuarioRolList2;
    }

    public void setUsuarioRolList2(List<UsuarioRol> usuarioRolList2) {
        this.usuarioRolList2 = usuarioRolList2;
    }

    @XmlTransient
    public List<UsuarioProfesion> getUsuarioProfesionList() {
        return usuarioProfesionList;
    }

    public void setUsuarioProfesionList(List<UsuarioProfesion> usuarioProfesionList) {
        this.usuarioProfesionList = usuarioProfesionList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList1() {
        return comentarioList1;
    }

    public void setComentarioList1(List<Comentario> comentarioList1) {
        this.comentarioList1 = comentarioList1;
    }

    @XmlTransient
    public List<Prioridad> getPrioridadList() {
        return prioridadList;
    }

    public void setPrioridadList(List<Prioridad> prioridadList) {
        this.prioridadList = prioridadList;
    }

    @XmlTransient
    public List<Prioridad> getPrioridadList1() {
        return prioridadList1;
    }

    public void setPrioridadList1(List<Prioridad> prioridadList1) {
        this.prioridadList1 = prioridadList1;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Rol> getRolList1() {
        return rolList1;
    }

    public void setRolList1(List<Rol> rolList1) {
        this.rolList1 = rolList1;
    }

    @XmlTransient
    public List<Retroalimentacion> getRetroalimentacionList() {
        return retroalimentacionList;
    }

    public void setRetroalimentacionList(List<Retroalimentacion> retroalimentacionList) {
        this.retroalimentacionList = retroalimentacionList;
    }

    @XmlTransient
    public List<Retroalimentacion> getRetroalimentacionList1() {
        return retroalimentacionList1;
    }

    public void setRetroalimentacionList1(List<Retroalimentacion> retroalimentacionList1) {
        this.retroalimentacionList1 = retroalimentacionList1;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dsi235.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
