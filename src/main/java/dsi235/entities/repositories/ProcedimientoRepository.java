package dsi235.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Correlativo;
import dsi235.entities.Procedimiento;

public interface ProcedimientoRepository extends CrudRepository<Procedimiento, Integer>  {

	@Query("SELECT c FROM Correlativo c WHERE c.idProcedimiento.idProcedimiento = ?1")
	List<Correlativo> correlativosPorProcedimiento(Integer id);
	
}
