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
@Table(name = "procedimiento")
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p"),
    @NamedQuery(name = "Procedimiento.findByIdProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.idProcedimiento = :idProcedimiento"),
    @NamedQuery(name = "Procedimiento.findByNombre", query = "SELECT p FROM Procedimiento p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Procedimiento.findByPasos", query = "SELECT p FROM Procedimiento p WHERE p.pasos = :pasos"),
    @NamedQuery(name = "Procedimiento.findByCostoMaterialesConsumibles", query = "SELECT p FROM Procedimiento p WHERE p.costoMaterialesConsumibles = :costoMaterialesConsumibles"),
    @NamedQuery(name = "Procedimiento.findByCostoRrhh", query = "SELECT p FROM Procedimiento p WHERE p.costoRrhh = :costoRrhh"),
    @NamedQuery(name = "Procedimiento.findByHerramientasMateriales", query = "SELECT p FROM Procedimiento p WHERE p.herramientasMateriales = :herramientasMateriales")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedimiento")
    private Integer idProcedimiento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "pasos")
    private String pasos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_materiales_consumibles")
    private Double costoMaterialesConsumibles;
    @Column(name = "costo_rrhh")
    private Double costoRrhh;
    @Column(name = "herramientas_materiales")
    private String herramientasMateriales;
    @OneToMany(mappedBy = "idProcedimiento")
    private List<Correlativo> correlativoList;

    public Procedimiento() {
    }

    public Procedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Procedimiento(Integer idProcedimiento, String nombre, String pasos) {
        this.idProcedimiento = idProcedimiento;
        this.nombre = nombre;
        this.pasos = pasos;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public Double getCostoMaterialesConsumibles() {
        return costoMaterialesConsumibles;
    }

    public void setCostoMaterialesConsumibles(Double costoMaterialesConsumibles) {
        this.costoMaterialesConsumibles = costoMaterialesConsumibles;
    }

    public Double getCostoRrhh() {
        return costoRrhh;
    }

    public void setCostoRrhh(Double costoRrhh) {
        this.costoRrhh = costoRrhh;
    }

    public String getHerramientasMateriales() {
        return herramientasMateriales;
    }

    public void setHerramientasMateriales(String herramientasMateriales) {
        this.herramientasMateriales = herramientasMateriales;
    }

    public List<Correlativo> getCorrelativoList() {
        return correlativoList;
    }

    public void setCorrelativoList(List<Correlativo> correlativoList) {
        this.correlativoList = correlativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acc.entities.Procedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
