package dsi235.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByCorreoAndContrasena(String correo, String contrasena); 
	
	//findTecnicosBySucursal
	public List<Usuario> findByIdSucursal_IdSucursalAndIdDepartamento_IdDepartamento(Short idSucursal, Integer idDepartamento);
	
}
