package dsi235.entities.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	// TODO
	
	//completado por encargado para parametros = ?1 donde 1 es el primer parametro
	@Query("select t from Ticket t WHERE t.idUsuarioCreador.idUsuario = ?1 AND t.idEstado.idEstado = ?2 ORDER BY t.fechaCompletado DESC")
	Page<Ticket> findCompletadosByEncargado(Long idUsuario, Short idEstado, Pageable pageable);

	//No completado por encargado
	@Query("select t from TicketEncargado te JOIN te.idTicket t WHERE te.idUsuario.idUsuario = ?1 AND t.idEstado.idEstado != ?2")   
	List<Ticket> findNoCompletadosByEncargado(Long idUsuario, Short idEstado);
	
	

	//completado por usuario creador
	//@Query("select t from Ticket t WHERE t.idUsuarioCreador.idUsuario = ?1 AND t.idEstado.idEstado = ?2 ORDER BY t.fechaCompletado DESC")
	@Query(value="SELECT * FROM ticket t WHERE t.id_usuario_creador = ?1 AND t.id_estado = ?2",
			countQuery = "SELECT count(*) FROM ticket t WHERE t.id_usuario_creador = ?1 AND t.id_estado = ?2",
		    nativeQuery = true)
	Page<Ticket> findByIdUsuario_IdUsuarioAndIdEstado_IdEstado(Long idUsuario, Short idEstado, Pageable pageable);
	
	
	// no completado por usuario
	List<Ticket> findByIdUsuarioCreador_IdUsuarioAndIdEstado_IdEstadoNot(Long idUsuario, Short idEstado);

	// no asignados
	Page<Ticket> findByIdEstado_IdEstadoInAndIdUsuarioCreador_IdSucursal_IdSucursal(Short idSucursal,
			Short idEstado, Pageable pg);
	
	//nuevo
	//Page<Ticket> findAll(Pageable pageable);

}
