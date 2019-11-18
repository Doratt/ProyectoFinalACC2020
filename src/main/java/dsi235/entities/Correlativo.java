/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dany2
 */
@Entity
@Table(name = "correlativo")
@NamedQueries({
    @NamedQuery(name = "Correlativo.findAll", query = "SELECT c FROM Correlativo c"),
    @NamedQuery(name = "Correlativo.findByCorrelativo", query = "SELECT c FROM Correlativo c WHERE c.correlativo = :correlativo"),
    @NamedQuery(name = "Correlativo.findByGarantia", query = "SELECT c FROM Correlativo c WHERE c.garantia = :garantia"),
    @NamedQuery(name = "Correlativo.findByDescripcionGarantia", query = "SELECT c FROM Correlativo c WHERE c.descripcionGarantia = :descripcionGarantia"),
    @NamedQuery(name = "Correlativo.findByPrecioCompra", query = "SELECT c FROM Correlativo c WHERE c.precioCompra = :precioCompra"),
    @NamedQuery(name = "Correlativo.findByFechaIngreso", query = "SELECT c FROM Correlativo c WHERE c.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Correlativo.findByActivo", query = "SELECT c FROM Correlativo c WHERE c.activo = :activo"),
    @NamedQuery(name = "Correlativo.findByFechaUltimoMtoAsignado", query = "SELECT c FROM Correlativo c WHERE c.fechaUltimoMtoAsignado = :fechaUltimoMtoAsignado"),
    @NamedQuery(name = "Correlativo.findByCadaCuanto", query = "SELECT c FROM Correlativo c WHERE c.cadaCuanto = :cadaCuanto"),
    @NamedQuery(name = "Correlativo.findByModelo", query = "SELECT c FROM Correlativo c WHERE c.modelo = :modelo")})
public class Correlativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "correlativo")
    private Long correlativo;
    @Basic(optional = false)
    @Column(name = "garantia")
    private boolean garantia;
    @Column(name = "descripcion_garantia")
    private String descripcionGarantia;
    @Basic(optional = false)
    @Column(name = "precio_compra")
    private double precioCompra;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "fecha_ultimo_mto_asignado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoMtoAsignado;////////
    @Column(name = "cada_cuanto")
    private Integer cadaCuanto;///////////
    @Column(name = "modelo")
    private String modelo;
    @OneToMany(mappedBy = "correlativo")
    private List<Ticket> ticketList;/////////
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca idMarca;
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento")
    @ManyToOne
    private Procedimiento idProcedimiento;
    @OneToMany(mappedBy = "correlativo")
    private List<Parte> parteList;

    public Correlativo() {
    }

    public Correlativo(Long correlativo) {
        this.correlativo = correlativo;
    }

    public Correlativo(Long correlativo, boolean garantia, double precioCompra, Date fechaIngreso, boolean activo) {
        this.correlativo = correlativo;
        this.garantia = garantia;
        this.precioCompra = precioCompra;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }

    public Long getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Long correlativo) {
        this.correlativo = correlativo;
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

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaUltimoMtoAsignado() {
        return fechaUltimoMtoAsignado;
    }

    public void setFechaUltimoMtoAsignado(Date fechaUltimoMtoAsignado) {
        this.fechaUltimoMtoAsignado = fechaUltimoMtoAsignado;
    }

    public Integer getCadaCuanto() {
        return cadaCuanto;
    }

    public void setCadaCuanto(Integer cadaCuanto) {
        this.cadaCuanto = cadaCuanto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Procedimiento getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Procedimiento idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public List<Parte> getParteList() {
        return parteList;
    }

    public void setParteList(List<Parte> parteList) {
        this.parteList = parteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativo != null ? correlativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correlativo)) {
            return false;
        }
        Correlativo other = (Correlativo) object;
        if ((this.correlativo == null && other.correlativo != null) || (this.correlativo != null && !this.correlativo.equals(other.correlativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acc.entities.Correlativo[ correlativo=" + correlativo + " ]";
    }
    
}
