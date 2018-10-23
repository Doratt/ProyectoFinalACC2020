//Esta clase servira para no tener que cargar los estados cada vez que se requieran, sino solo una vez

package dsi235.utilities;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dsi235.controllers.EstadoController;
import dsi235.entities.Estado;

@Singleton
@Component
public class EstadosLoader{

	
	private List<Estado> estados;
	
	@Autowired
	public EstadosLoader(EstadoController ec) {
		setEstados(ec.findAll());		
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
	
	
}
