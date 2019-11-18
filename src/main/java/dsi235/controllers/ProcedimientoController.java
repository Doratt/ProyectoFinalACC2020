package dsi235.controllers;

import java.util.List;

import dsi235.entities.Correlativo;
import dsi235.entities.Procedimiento;

public interface ProcedimientoController extends AbstractCrudController<Procedimiento, Integer> {
	List<Correlativo> correlativosPorProcedimiento(Integer id); 
}
