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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author doratt
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
    @ManyToOne(optional = false)
    private Profesion idProfesion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
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
        return "dsi235.entities.UsuarioProfesion[ idUsuarioProfesion=" + idUsuarioProfesion + " ]";
    }
    
}
