/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dany2
 */
@Entity
@Table(name = "tipo_mantenimiento")
@NamedQueries({
    @NamedQuery(name = "TipoMantenimiento.findAll", query = "SELECT t FROM TipoMantenimiento t"),
    @NamedQuery(name = "TipoMantenimiento.findByIdTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.idTipoMantenimiento = :idTipoMantenimiento"),
    @NamedQuery(name = "TipoMantenimiento.findByNombre", query = "SELECT t FROM TipoMantenimiento t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoMantenimiento.findByDescripcion", query = "SELECT t FROM TipoMantenimiento t WHERE t.descripcion = :descripcion")})
public class TipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_mantenimiento")
    private Integer idTipoMantenimiento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoMantenimiento")
    private List<Ticket> ticketList;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public TipoMantenimiento(Integer idTipoMantenimiento, String nombre) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.nombre = nombre;
    }

    public Integer getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
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

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMantenimiento != null ? idTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMantenimiento)) {
            return false;
        }
        TipoMantenimiento other = (TipoMantenimiento) object;
        if ((this.idTipoMantenimiento == null && other.idTipoMantenimiento != null) || (this.idTipoMantenimiento != null && !this.idTipoMantenimiento.equals(other.idTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acc.entities.TipoMantenimiento[ idTipoMantenimiento=" + idTipoMantenimiento + " ]";
    }
    
}
