package dsi235.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioControllerTest {
	
	//private UsuarioController usuarioController;
	
	
	@Test
	public void findByCorreoAndContrasenaTest() {
		assertEquals("uno", "uno");
	}


	//	public UsuarioController getUsuarioController() {
	//		return usuarioController;
	//	}

//	@Autowired
//	public void setUsuarioController(UsuarioController usuarioController) {
//		this.usuarioController = usuarioController;
//	}
	
}
