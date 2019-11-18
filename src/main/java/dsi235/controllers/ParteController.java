package dsi235.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dsi235.entities.Parte;

public interface ParteController extends AbstractCrudController<Parte, Long>{
	Page<Parte> findRange(Pageable pg);

}
