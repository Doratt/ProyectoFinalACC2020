package dsi235.entities.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Ticket;
import dsi235.entities.estadisticas.NumeroTickets;
import dsi235.entities.estadisticas.TiempoResolucion;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	// TODO

	// completado por encargado para parametros = ?1 donde 1 es el primer parametro
	@Query(value = "SELECT * FROM ticket_encargado te JOIN ticket as t ON te.id_ticket = t.id_ticket WHERE te.id_usuario = ?1 AND t.id_estado = ?2", countQuery = "SELECT count(*) FROM ticket_encargado te JOIN ticket as t ON te.id_ticket = t.id_ticket WHERE te.id_usuario = 3 AND t.id_estado = 5", nativeQuery = true)
	Page<Ticket> findCompletadosByEncargado(Long idUsuario, Short idEstado, Pageable pageable);

	// No completado por encargado
	@Query("select t from TicketEncargado te JOIN te.idTicket t WHERE te.idUsuario.idUsuario = ?1 AND t.idEstado.idEstado != ?2 AND te.activo = true")
	List<Ticket> findNoCompletadosByEncargado(Long idUsuario, Short idEstado);

	// completado por usuario creador
	// @Query("select t from Ticket t WHERE t.idUsuarioCreador.idUsuario = ?1 AND
	// t.idEstado.idEstado = ?2 ORDER BY t.fechaCompletado DESC")
	@Query(value = "SELECT * FROM ticket t WHERE t.id_usuario_creador = ?1 AND t.id_estado = ?2 ORDER BY t.fecha_completado DESC", countQuery = "SELECT count(*) FROM ticket t WHERE t.id_usuario_creador = ?1 AND t.id_estado = ?2", nativeQuery = true)
	Page<Ticket> findByIdUsuario_IdUsuarioAndIdEstado_IdEstado(Long idUsuario, Short idEstado, Pageable pageable);

	// no completado por usuario
	List<Ticket> findByIdUsuarioCreador_IdUsuarioAndIdEstado_IdEstadoNot(Long idUsuario, Short idEstado);

	// no asignados
	Page<Ticket> findByIdEstado_IdEstadoInAndIdUsuarioCreador_IdSucursal_IdSucursal(Short idSucursal, Short idEstado,
			Pageable pg);

	// nuevo
	// Page<Ticket> findAll(Pageable pageable);

	
	// ESTADISTICAS RETROALIMENTACION
	@Query(value = "SELECT t FROM Ticket t JOIN FETCH t.retroalimentacion r WHERE t.idUsuarioCreador.idSucursal.idSucursal = ?1 AND (t.fechaCompletado BETWEEN ?2 AND ?3) AND t.idEstado.idEstado = 5")
	List<Ticket> retroalimentarionBySucursal(Short idSucursal, Date fecha1, Date fecha2);

	@Query(value = "SELECT t FROM Ticket t JOIN FETCH t.retroalimentacion r JOIN t.ticketEncargadoList te WHERE te.idUsuario.idUsuario = ?1 AND (t.fechaCompletado BETWEEN ?2 AND ?3) AND t.idEstado.idEstado = 5")
	List<Ticket> retroalimentarionByTecnico(Long idUsuario, Date fecha1, Date fecha2);

	@Query(value = "SELECT t FROM Ticket t JOIN FETCH t.retroalimentacion r WHERE t.idUsuarioCreador.idDepartamento.idDepartamento= ?1 AND (t.fechaCompletado BETWEEN ?2 AND ?3) AND t.idEstado.idEstado = 5")
	List<Ticket> retroalimentarionByDepartamento(Integer idDepartamento, Date fecha1, Date fecha2);

	// NUMERO DE TICKETS
	@Query(value = "SELECT new dsi235.entities.estadisticas.NumeroTickets(u,COUNT(t) ) FROM Ticket t JOIN t.idUsuarioCreador u WHERE u.idSucursal.idSucursal = ?1 AND (t.fechaCompletado BETWEEN ?2 AND ?3) AND t.idEstado.idEstado = 5 GROUP BY u")
	List<NumeroTickets> numeroTicketsBySucursal(Short idSucursal, Date fecha1, Date fecha2);

	@Query(value = "SELECT new dsi235.entities.estadisticas.NumeroTickets(u,COUNT(t) ) FROM Ticket t JOIN t.idUsuarioCreador u WHERE u.idDepartamento.idDepartamento = ?1 AND (t.fechaCompletado BETWEEN ?2 AND ?3) AND t.idEstado.idEstado = 5 GROUP BY u")
	List<NumeroTickets> numeroTicketsByDepartamento(Integer idDepartamento, Date fecha1, Date fecha2);

	@Query(value = "SELECT new dsi235.entities.estadisticas.NumeroTickets(u,COUNT(t) ) FROM Ticket t JOIN t.ticketEncargadoList te JOIN te.idUsuario u WHERE (t.fechaCompletado BETWEEN ?1 AND ?2) AND t.idEstado.idEstado = 5 GROUP BY u")
	List<NumeroTickets> numeroTicketsByTecnico(Date fecha1, Date fecha2);

	
	// TIEMPOS DE RESOLUCION
	// Calcular tiempo de resolucion por sucursal
	@Query(value = "SELECT new dsi235.entities.estadisticas.TiempoResolucion( t) FROM Ticket t WHERE (t.fechaCompletado BETWEEN ?1 AND ?2) AND t.idUsuarioCreador.idSucursal.idSucursal = ?3")
	List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal);

	// Calcular tiempo de resolucion por Departamento
	@Query(value = "SELECT new dsi235.entities.estadisticas.TiempoResolucion( t) FROM Ticket t WHERE (t.fechaCompletado BETWEEN ?1 AND ?2) AND t.idUsuarioCreador.idDepartamento.idDepartamento = ?3")
	List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Integer idDepartamento);

	// Calcular tiempo de resolucion por Tecnico
	@Query(value = "SELECT new dsi235.entities.estadisticas.TiempoResolucion( t) FROM Ticket t JOIN t.ticketEncargadoList te WHERE (t.fechaCompletado BETWEEN ?1 AND ?2) AND te.idUsuario.idUsuario = ?3")
	List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin, Long idTecnico);

}
