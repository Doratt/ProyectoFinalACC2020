package dsi235.entities.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Parte;

public interface ParteRepository extends CrudRepository<Parte, Long>{
	Page<Parte> findAll(Pageable pg);
}
