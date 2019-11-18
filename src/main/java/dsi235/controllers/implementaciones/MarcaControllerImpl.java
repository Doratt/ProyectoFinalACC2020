package dsi235.controllers.implementaciones;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.MarcaController;
import dsi235.entities.Marca;
import dsi235.entities.repositories.MarcaRepository;

@Controller
public class MarcaControllerImpl extends AbstractCrudControllerImpl<Marca, Integer> implements MarcaController{

	private MarcaRepository repository;
	
	public MarcaControllerImpl(MarcaRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	CrudRepository<Marca, Integer> getRepository() {
		return this.repository;
	}

}
