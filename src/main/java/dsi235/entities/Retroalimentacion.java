/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dm
 */
@Entity
@Table(name = "retroalimentacion", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retroalimentacion.findAll", query = "SELECT r FROM Retroalimentacion r")
    , @NamedQuery(name = "Retroalimentacion.findByIdRetroalimentacion", query = "SELECT r FROM Retroalimentacion r WHERE r.idRetroalimentacion = :idRetroalimentacion")
    , @NamedQuery(name = "Retroalimentacion.findByCalificacion", query = "SELECT r FROM Retroalimentacion r WHERE r.calificacion = :calificacion")
    , @NamedQuery(name = "Retroalimentacion.findByComentario", query = "SELECT r FROM Retroalimentacion r WHERE r.comentario = :comentario")})
public class Retroalimentacion extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_retroalimentacion")
    private Long idRetroalimentacion;
    @Basic(optional = false)
    @Column(name = "calificacion")
    private short calificacion;
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket idTicket;

    public Retroalimentacion() {
    }

    public Retroalimentacion(Long idRetroalimentacion) {
        this.idRetroalimentacion = idRetroalimentacion;
    }

    public Retroalimentacion(Long idRetroalimentacion, short calificacion) {
        this.idRetroalimentacion = idRetroalimentacion;
        this.calificacion = calificacion;
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

    public Ticket getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Ticket idTicket) {
        this.idTicket = idTicket;
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
        return "ticketsystem.entities.Retroalimentacion[ idRetroalimentacion=" + idRetroalimentacion + " ]";
    }
    
}
