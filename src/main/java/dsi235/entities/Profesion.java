/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dm
 */
@Entity
@Table(name = "profesion", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p")
    , @NamedQuery(name = "Profesion.findByIdProfesion", query = "SELECT p FROM Profesion p WHERE p.idProfesion = :idProfesion")
    , @NamedQuery(name = "Profesion.findByNombre", query = "SELECT p FROM Profesion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesion.findByDescripcion", query = "SELECT p FROM Profesion p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Profesion.findByActivo", query = "SELECT p FROM Profesion p WHERE p.activo = :activo")})
public class Profesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesion")
    private Integer idProfesion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesion", fetch = FetchType.LAZY)
    private List<UsuarioProfesion> usuarioProfesionList;

    public Profesion() {
    }

    public Profesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Profesion(Integer idProfesion, String nombre, String descripcion, boolean activo) {
        this.idProfesion = idProfesion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<UsuarioProfesion> getUsuarioProfesionList() {
        return usuarioProfesionList;
    }

    public void setUsuarioProfesionList(List<UsuarioProfesion> usuarioProfesionList) {
        this.usuarioProfesionList = usuarioProfesionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesion != null ? idProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.idProfesion == null && other.idProfesion != null) || (this.idProfesion != null && !this.idProfesion.equals(other.idProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ticketsystem.entities.Profesion[ idProfesion=" + idProfesion + " ]";
    }
    
}
