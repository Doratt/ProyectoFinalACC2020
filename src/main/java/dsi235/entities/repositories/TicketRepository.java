package dsi235.entities.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	// TODO
	@Query("select t from Ticket t")
	List<Ticket> findCompetadosByEncargado(Long idUsuario, Short idEstado);

	@Query("select t from Ticket t")
	List<Ticket> findNoCompletadosByEncargado(Long idUsuario, Short idEstado);

	// findCompletadosByIdUsuario
	List<Ticket> findByIdUsuario_IdUsuarioAndIdEstado_IdEstado(Long idUsuario, Short idEstado);

	// no completado por usuario
	List<Ticket> findByIdUsuario_IdUsuarioAndIdEstado_IdEstadoNot(Long idUsuario, Short idEstado);

	// no asigandos
	List<Ticket> findByIdEstado_IdEstadoInAndIdUsuario_IdSucursal_IdSucursal(Collection<Short> idsEstado,
			Short idSucursal);

}
