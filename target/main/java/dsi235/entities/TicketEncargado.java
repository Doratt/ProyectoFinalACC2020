/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dm
 */
@Entity
@Table(name = "ticket_encargado", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketEncargado.findAll", query = "SELECT t FROM TicketEncargado t")
    , @NamedQuery(name = "TicketEncargado.findByIdTicketEncargado", query = "SELECT t FROM TicketEncargado t WHERE t.idTicketEncargado = :idTicketEncargado")})
public class TicketEncargado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket_encargado")
    private Long idTicketEncargado;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket idTicket;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public TicketEncargado() {
    }

    public TicketEncargado(Long idTicketEncargado) {
        this.idTicketEncargado = idTicketEncargado;
    }

    public Long getIdTicketEncargado() {
        return idTicketEncargado;
    }

    public void setIdTicketEncargado(Long idTicketEncargado) {
        this.idTicketEncargado = idTicketEncargado;
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
        return "ticketsystem.entities.TicketEncargado[ idTicketEncargado=" + idTicketEncargado + " ]";
    }
    
}
