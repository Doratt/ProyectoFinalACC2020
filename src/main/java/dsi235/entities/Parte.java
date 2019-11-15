/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dany2
 */
@Entity
@Table(name = "parte")
@NamedQueries({
    @NamedQuery(name = "Parte.findAll", query = "SELECT p FROM Parte p"),
    @NamedQuery(name = "Parte.findByNumeroSerie", query = "SELECT p FROM Parte p WHERE p.numeroSerie = :numeroSerie"),
    @NamedQuery(name = "Parte.findByActivo", query = "SELECT p FROM Parte p WHERE p.activo = :activo"),
    @NamedQuery(name = "Parte.findByGarantia", query = "SELECT p FROM Parte p WHERE p.garantia = :garantia"),
    @NamedQuery(name = "Parte.findByDescripcionGarantia", query = "SELECT p FROM Parte p WHERE p.descripcionGarantia = :descripcionGarantia"),
    @NamedQuery(name = "Parte.findByPrecioCompra", query = "SELECT p FROM Parte p WHERE p.precioCompra = :precioCompra"),
    @NamedQuery(name = "Parte.findByFechaIngreso", query = "SELECT p FROM Parte p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Parte.findByModelo", query = "SELECT p FROM Parte p WHERE p.modelo = :modelo")})
public class Parte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero_serie")
    private Long numeroSerie;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "garantia")
    private boolean garantia;
    @Basic(optional = false)
    @Column(name = "descripcion_garantia")
    private String descripcionGarantia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_compra")
    private Double precioCompra;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "correlativo", referencedColumnName = "correlativo")
    @ManyToOne
    private Correlativo correlativo;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca idMarca;

    public Parte() {
    }

    public Parte(Long numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Parte(Long numeroSerie, boolean activo, boolean garantia, String descripcionGarantia, Date fechaIngreso) {
        this.numeroSerie = numeroSerie;
        this.activo = activo;
        this.garantia = garantia;
        this.descripcionGarantia = descripcionGarantia;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Long numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    public String getDescripcionGarantia() {
        return descripcionGarantia;
    }

    public void setDescripcionGarantia(String descripcionGarantia) {
        this.descripcionGarantia = descripcionGarantia;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Correlativo getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Correlativo correlativo) {
        this.correlativo = correlativo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSerie != null ? numeroSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parte)) {
            return false;
        }
        Parte other = (Parte) object;
        if ((this.numeroSerie == null && other.numeroSerie != null) || (this.numeroSerie != null && !this.numeroSerie.equals(other.numeroSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acc.entities.Parte[ numeroSerie=" + numeroSerie + " ]";
    }
    
}
