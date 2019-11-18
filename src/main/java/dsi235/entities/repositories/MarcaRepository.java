package dsi235.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Correlativo;
import dsi235.entities.Marca;
import dsi235.entities.Parte;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
	
	@Query("SELECT c FROM Correlativo c WHERE c.idMarca.idMarca = ?1")
	List<Correlativo> correlativosPorMarca(Integer id);
	
	@Query("SELECT p FROM Parte p WHERE p.idMarca.idMarca = ?1")
	List<Parte> partesPorMarca(Integer id);
	
}
