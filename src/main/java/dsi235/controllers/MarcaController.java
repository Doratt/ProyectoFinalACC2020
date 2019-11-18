package dsi235.controllers;

import java.util.List;

import dsi235.entities.Correlativo;
import dsi235.entities.Marca;
import dsi235.entities.Parte;

public interface MarcaController extends AbstractCrudController<Marca, Integer> {

	List<Correlativo> correlativosPorMarca(Integer id); 
	
	List<Parte> partesPorMarca(Integer id); 
}
