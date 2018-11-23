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

	public List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal);

	public List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Integer idDepartamento);

	public List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin, Long idTecnico);

	public List<NumeroTickets> calcularNumTicketsDepto(Date fechaInicio, Date fechaFin, Integer idDepartamento);

	// Ordenar por numero de tickets
	public List<NumeroTickets> calcularNumTicketsSucursal(Date fechaInicio, Date fechaFin, Short idSucursal);

	public List<NumeroTickets> calcularNumTicketsTecnico(Date fechaInicio, Date fechaFin);

	public List<Ticket> verRetroalimentacion(Date fechaInicio, Date fechaFin, Short idSucursal, Integer idDepartamento,
			Long idTecnico);
}
