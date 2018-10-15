package dsi235.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Comentario;
import dsi235.entities.Ticket;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>{
	List<Comentario> findByIdTicket(Ticket idTicket);
}
