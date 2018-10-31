/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dsi235.entities.Usuario;

/**
 *
 * @author doratt
 */
public interface UsuarioController {
    
    public Usuario autenticar(String correo, String contrasena);
    
    // idDepto IT o Mantenimiento
    public List<Usuario> findTecnicosBySucursal(Short idSucursal, Integer idDepartamento,boolean activo);

    public Page<Usuario> findTecnicosBySucursal(Short idSucursal, Integer idDepartamento,boolean activo,Pageable pg);
    
}
