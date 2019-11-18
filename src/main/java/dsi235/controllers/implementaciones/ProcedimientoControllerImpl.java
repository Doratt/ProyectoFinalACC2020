package dsi235.controllers.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.ProcedimientoController;
import dsi235.entities.Correlativo;
import dsi235.entities.Procedimiento;
import dsi235.entities.repositories.ProcedimientoRepository;

@Controller
public class ProcedimientoControllerImpl extends AbstractCrudControllerImpl<Procedimiento, Integer> implements ProcedimientoController {
	 
	@Autowired
	private ProcedimientoRepository repository;

	@Override
	CrudRepository<Procedimiento, Integer> getRepository() {
		return this.repository;
	}


	@Override
	public List<Correlativo> correlativosPorProcedimiento(Integer id) {
		return repository.correlativosPorProcedimiento(id);
	}
	
	
}
