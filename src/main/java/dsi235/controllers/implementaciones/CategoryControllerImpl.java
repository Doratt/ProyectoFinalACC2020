package dsi235.controllers.implementaciones;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.CategoryController;
import dsi235.entities.Categoria;
import dsi235.entities.repositories.CategoryRepository;

@Controller
public class CategoryControllerImpl extends AbstractCrudControllerImpl<Categoria, Integer> implements CategoryController{

	private CategoryRepository repository;
	
	
	
	public CategoryControllerImpl(CategoryRepository repository) {
		super();
		this.repository = repository;
	}



	@Override
	CrudRepository<Categoria, Integer> getRepository() {
		return this.repository;
	}

}
