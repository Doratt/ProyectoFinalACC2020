package dsi235.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import dsi235.boundary.backingBeans.LoginSessionBean;
import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioSessionTest {
	
	
	private UsuarioController usuarioController;
	private LoginSessionBean sessionBean;
	
	@Test
	public void iniciarSesionCorrecto() {
		Usuario user = usuarioController.autenticar("daniel97molin@gmail.com", "dmdm");
		assertEquals(user.getIdUsuario(), Long.valueOf(4));
	}
	


	
	public LoginSessionBean getSessionBean() {
		return sessionBean;
	}
	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	@Autowired
	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	
}
