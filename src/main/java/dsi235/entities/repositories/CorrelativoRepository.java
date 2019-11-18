package dsi235.entities.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Correlativo;

public interface CorrelativoRepository extends CrudRepository<Correlativo, Long>{
	
	Page<Correlativo> findAll(Pageable pg);
	
}
