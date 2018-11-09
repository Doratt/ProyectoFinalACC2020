package dsi235.entities.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Ticket;
import dsi235.entities.estadisticas.TiempoResolucion;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	// TODO
	
	// Calcular tiempo de resolucion por sucursal
	//@Query(value = "SELECT * FROM ticket t JOIN usuario as te ON t.id_usuario WHERE te.id_sucursal = ?3 AND t.id_estado = ?4 AND (t.fecha_completado BETWEEN ?1 AND ?2)", nativeQuery = true)
	//List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal, Short idEstado);

	// Calcular tiempo de resolucion por Departamento
	//List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Short idEstado);
	
	// Calcular tiempo de resolucion por Tecnico
	//List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Long idTecnico, Short idEstado);
	
	// completado por encargado para parametros = ?1 donde 1 es el primer parametro
	@Query(value = "SELECT * FROM ticket_encargado te JOIN ticket as t ON te.id_ticket = t.id_ticket WHERE te.id_usuario = ?1 AND t.id_estado = ?2", countQuery = "SELECT count(*) FROM ticket_encargado te JOIN ticket as t ON te.id_ticket = t.id_ticket WHERE te.id_usuario = 3 AND t.id_estado = 5", nativeQuery = true)
	Page<Ticket> findCompletadosByEncargado(Long idUsuario, Short idEstado, Pageable pageable);

	// No completado por encargado
	@Query("select t from TicketEncargado te JOIN te.idTicket t WHERE te.idUsuario.idUsuario = ?1 AND t.idEstado.idEstado != ?2")
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

}
