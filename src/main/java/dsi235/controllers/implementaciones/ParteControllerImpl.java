package dsi235.controllers.implementaciones;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.ParteController;
import dsi235.entities.Parte;
import dsi235.entities.repositories.ParteRepository;

@Controller
public class ParteControllerImpl extends AbstractCrudControllerImpl<Parte, Long> implements ParteController {

	private ParteRepository repository;

	public ParteControllerImpl(ParteRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Page<Parte> findRange(Pageable pg) {
		return this.repository.findAll(pg);
	}
	
	@Override
	CrudRepository<Parte, Long> getRepository() {
		return this.repository;
	}

}
