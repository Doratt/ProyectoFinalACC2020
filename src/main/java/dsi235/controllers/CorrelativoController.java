package dsi235.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dsi235.entities.Correlativo;

public interface CorrelativoController extends AbstractCrudController<Correlativo, Long>{
	Page<Correlativo> findRange(Pageable pg);
}
