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
import javax.persistence.OneToOne;
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
@Table(name = "ticket", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket")
    , @NamedQuery(name = "Ticket.findByDescripcion", query = "SELECT t FROM Ticket t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Ticket.findByFechaCreacion", query = "SELECT t FROM Ticket t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Ticket.findByFechaCompletado", query = "SELECT t FROM Ticket t WHERE t.fechaCompletado = :fechaCompletado")
    , @NamedQuery(name = "Ticket.findByFechaModificacion", query = "SELECT t FROM Ticket t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Ticket.findByActivo", query = "SELECT t FROM Ticket t WHERE t.activo = :activo")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Long idTicket;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_completado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompletado;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTicket")
    private List<TicketEncargado> ticketEncargadoList;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_prioridad", referencedColumnName = "id_prioridad")
    @ManyToOne
    private Prioridad idPrioridad;
    @JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioCreador;
    @JoinColumn(name = "id_usuario_modificador", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuarioModificador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTicket")
    private List<Comentario> comentarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idTicket")
    private Retroalimentacion retroalimentacion;

    public Ticket() {
    }

    public Ticket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Long idTicket, String descripcion, Date fechaCreacion, boolean activo) {
        this.idTicket = idTicket;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
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

    public Date getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
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
    public List<TicketEncargado> getTicketEncargadoList() {
        return ticketEncargadoList;
    }

    public void setTicketEncargadoList(List<TicketEncargado> ticketEncargadoList) {
        this.ticketEncargadoList = ticketEncargadoList;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
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

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Retroalimentacion getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(Retroalimentacion retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dsi235.entities.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
