package dsi235.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	Usuario findByidUsuario(Long idUsuario); 
	
	//findTecnicosBySucursal
	List<Usuario> findByIdSucursal_IdSucursalAndIdDepartamento_IdDepartamento(Short idSucursal, Integer idDepartamento);
}
