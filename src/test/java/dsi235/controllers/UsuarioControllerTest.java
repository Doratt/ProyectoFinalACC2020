/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dsi235.controllers;

import dsi235.entities.Usuario;
import dsi235.utilities.PageParser;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author irvin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioControllerTest {

    public UsuarioControllerTest() {
    }

    private UsuarioController usuarioController;

    /**
     * Test of autenticar method, of class UsuarioController.
     */
    @Test
    public void testAutenticar() {
        System.out.println("autenticar");
        Usuario user = usuarioController.autenticar("m@m.com", "1234");
        assertEquals(user.getIdUsuario(), Long.valueOf(3));
    }

    /**
     * Test of findTecnicosBySucursal method, of class UsuarioController.
     */
    @Test
    public void testFindTecnicosBySucursal_3args_1() {
        System.out.println("findTecnicosBySucursal");
        Short idSucursal = 1;
        Integer idDepartamento = 1;
        boolean activo = true;
        List<Usuario> usuarios = usuarioController.findTecnicosBySucursal(idSucursal, idDepartamento, activo);
        assertEquals(usuarios.size(), 4);

    }

    /**
     * Test of findTecnicosBySucursal method, of class UsuarioController.
     */
    @Test
    public void testFindTecnicosBySucursal_3args_2() {
        System.out.println("findTecnicosBySucursal");
        Short idSucursal = 1;
        boolean activo = true;
        Pageable pg = PageRequest.of(0,3);
        Page<Usuario> usuarios = usuarioController.findTecnicosBySucursal(idSucursal, activo, pg);
        assertEquals(usuarios.getSize(), 3);
        
    }

    public class UsuarioControllerImpl implements UsuarioController {

        public Usuario autenticar(String correo, String contrasena) {
            return null;
        }

        public List<Usuario> findTecnicosBySucursal(Short idSucursal, Integer idDepartamento, boolean activo) {
            return null;
        }

        public Page<Usuario> findTecnicosBySucursal(Short idSucursal, boolean activo, Pageable pg) {
            return null;
        }

		@Override
		public List<Usuario> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
    }

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    @Autowired
    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }
}
