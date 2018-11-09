package dsi235.entities.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import dsi235.entities.Usuario;
import dsi235.entities.estadisticas.NumeroTickets;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByCorreoAndContrasena(String correo, String contrasena); 
	
	//findTecnicosBySucursal
	public List<Usuario> findByIdSucursal_IdSucursalAndIdDepartamento_IdDepartamentoAndActivo(Short idSucursal, Integer idDepartamento,boolean activo);
	public Page<Usuario> findByIdSucursal_IdSucursalAndActivo(Short idSucursal,boolean activo,Pageable pg);
	
	}
