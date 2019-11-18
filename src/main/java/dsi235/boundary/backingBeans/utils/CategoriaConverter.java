package dsi235.boundary.backingBeans.utils;

import java.util.List;
import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dsi235.entities.Categoria;

@FacesConverter(value = "catC")
public class CategoriaConverter implements Converter<Categoria>{


	public static List<Categoria> list;
	@Override
	public Categoria getAsObject(FacesContext context, UIComponent component, String value) {
		Optional<Categoria> marcaOpt;
		if (value.isBlank()) {
			throw new RuntimeException("Value in the list is blank");
		} else {
			marcaOpt = list.stream().filter(cat -> cat.getNombre().equalsIgnoreCase(value)).findFirst();
		}
		return marcaOpt.orElseThrow(RuntimeException::new);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Categoria value) throws NullPointerException {
		if (value != null) {
			if (value.getNombre().isBlank()) {
				return "Nombre vacio";
			} else
				return value.getNombre();
		} else
			throw new NullPointerException("Marca obj not found");
	}

}
