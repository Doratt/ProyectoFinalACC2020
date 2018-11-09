package dsi235.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dsi235.entities.TicketEncargado;

public interface TicketEncargadoRepository extends CrudRepository<TicketEncargado, Long>{

	List<TicketEncargado> findByIdTicket_IdTicket(Long idTicket);
	
}
