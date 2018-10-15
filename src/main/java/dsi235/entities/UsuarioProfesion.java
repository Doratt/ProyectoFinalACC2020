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
@Table(name = "usuario_profesion", catalog = "ticketsystem", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioProfesion.findAll", query = "SELECT u FROM UsuarioProfesion u")
    , @NamedQuery(name = "UsuarioProfesion.findByIdUsuarioProfesion", query = "SELECT u FROM UsuarioProfesion u WHERE u.idUsuarioProfesion = :idUsuarioProfesion")})
public class UsuarioProfesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_profesion")
    private Long idUsuarioProfesion;
    @JoinColumn(name = "id_profesion", referencedColumnName = "id_profesion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profesion idProfesion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public UsuarioProfesion() {
    }

    public UsuarioProfesion(Long idUsuarioProfesion) {
        this.idUsuarioProfesion = idUsuarioProfesion;
    }

    public Long getIdUsuarioProfesion() {
        return idUsuarioProfesion;
    }

    public void setIdUsuarioProfesion(Long idUsuarioProfesion) {
        this.idUsuarioProfesion = idUsuarioProfesion;
    }

    public Profesion getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Profesion idProfesion) {
        this.idProfesion = idProfesion;
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
        hash += (idUsuarioProfesion != null ? idUsuarioProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioProfesion)) {
            return false;
        }
        UsuarioProfesion other = (UsuarioProfesion) object;
        if ((this.idUsuarioProfesion == null && other.idUsuarioProfesion != null) || (this.idUsuarioProfesion != null && !this.idUsuarioProfesion.equals(other.idUsuarioProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ticketsystem.entities.UsuarioProfesion[ idUsuarioProfesion=" + idUsuarioProfesion + " ]";
    }
    
}
