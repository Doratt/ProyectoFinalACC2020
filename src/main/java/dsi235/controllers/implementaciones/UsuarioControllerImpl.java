package dsi235.controllers.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;
import dsi235.repositories.UsuarioRepository;

@Controller
public class UsuarioControllerImpl extends AbstractCrudControllerImpl<Usuario, Long> implements UsuarioController {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioControllerImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario autenticar(String correo, String contrasena) {
		return null;
	}

	@Override
	public List<Usuario> findTecnicosBySucursal(Short idSucursal, Integer idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	CrudRepository<Usuario, Long> getRepository() {
		return this.usuarioRepository;
	}

}
