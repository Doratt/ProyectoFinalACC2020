/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers;

import java.util.Date;
import java.util.List;

import dsi235.entities.Ticket;
import dsi235.entities.estadisticas.NumeroTickets;
import dsi235.entities.estadisticas.TiempoResolucion;

/**
 *
 * @author doratt
 */
public interface EstadisticaController {
    public List<TiempoResolucion> calcularTiempoResolucion(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Long idTecnico);
    
    public NumeroTickets calcularNumTicketsDepto(Date fechaInicio, Date fechaFin, Short idSucursal);
    //Ordenar por numero de tickets
    public NumeroTickets calcularNumTicketsUsuario(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento);

    public NumeroTickets calcularNumTicketsTecnico(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento);
    
    public List<Ticket> verRetroalimentacion(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Long idTecnico);
}
