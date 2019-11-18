package dsi235.controllers.implementaciones;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.CorrelativoController;
import dsi235.entities.Correlativo;
import dsi235.entities.repositories.CorrelativoRepository;

@Controller
public class CorrelativoControllerImpl extends AbstractCrudControllerImpl<Correlativo, Long> implements CorrelativoController{

	private CorrelativoRepository correlativoRepository;
	
	public CorrelativoControllerImpl(CorrelativoRepository correlatvoRepository) {
		super();
		this.correlativoRepository = correlatvoRepository;
	}

	@Override
	CrudRepository<Correlativo, Long> getRepository() {
		return this.correlativoRepository;
	}

	@Override
	public Page<Correlativo> findRange(Pageable pg) {
		return this.correlativoRepository.findAll(pg);
	}

	

}
