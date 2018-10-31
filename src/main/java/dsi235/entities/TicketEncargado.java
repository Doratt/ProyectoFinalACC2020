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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author doratt
 */
@Entity
@Table(name = "ticket_encargado", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketEncargado.findAll", query = "SELECT t FROM TicketEncargado t")
    , @NamedQuery(name = "TicketEncargado.findByIdTicketEncargado", query = "SELECT t FROM TicketEncargado t WHERE t.idTicketEncargado = :idTicketEncargado")
    , @NamedQuery(name = "TicketEncargado.findByFechaCreacion", query = "SELECT t FROM TicketEncargado t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TicketEncargado.findByFechaModificacion", query = "SELECT t FROM TicketEncargado t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "TicketEncargado.findByActivo", query = "SELECT t FROM TicketEncargado t WHERE t.activo = :activo")})
public class TicketEncargado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket_encargado")
    private Long idTicketEncargado;
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
    @ManyToOne(optional = false)
    private Ticket idTicket;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreador;
    @JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuarioModificador;

    public TicketEncargado() {
    }

    public TicketEncargado(Long idTicketEncargado) {
        this.idTicketEncargado = idTicketEncargado;
    }

    public TicketEncargado(Long idTicketEncargado, Date fechaCreacion, boolean activo) {
        this.idTicketEncargado = idTicketEncargado;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Long getIdTicketEncargado() {
        return idTicketEncargado;
    }

    public void setIdTicketEncargado(Long idTicketEncargado) {
        this.idTicketEncargado = idTicketEncargado;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idTicketEncargado != null ? idTicketEncargado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketEncargado)) {
            return false;
        }
        TicketEncargado other = (TicketEncargado) object;
        if ((this.idTicketEncargado == null && other.idTicketEncargado != null) || (this.idTicketEncargado != null && !this.idTicketEncargado.equals(other.idTicketEncargado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dsi235.entities.TicketEncargado[ idTicketEncargado=" + idTicketEncargado + " ]";
    }
    
}
