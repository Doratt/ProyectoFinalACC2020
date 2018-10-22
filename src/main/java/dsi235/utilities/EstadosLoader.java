//Esta clase servira para no tener que cargar los estados cada vez que se requieran, sino solo una vez

package dsi235.utilities;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.EstadoController;
import dsi235.entities.Estado;

@Singleton
public class EstadosLoader{

	private EstadoController ec;
	private List<Estado> estados;
	private EstadosLoader() {
		setEstados(ec.findAll());		
	}

	@Autowired
	public void setEc(EstadoController ec) {
		this.ec = ec;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
	
	
}
