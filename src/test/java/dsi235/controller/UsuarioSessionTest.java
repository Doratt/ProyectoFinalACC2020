package dsi235.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import dsi235.boundary.backingBeans.LoginSessionBean;
import dsi235.controllers.TicketController;
import dsi235.controllers.UsuarioController;
import dsi235.entities.Estado;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;

import static org.junit.Assert.*;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioSessionTest {
	
	
	private UsuarioController usuarioController;
	private LoginSessionBean sessionBean;
	private TicketController ticketController;
	
	@Test
	public void iniciarSesionCorrecto() {
		Usuario user = usuarioController.autenticar("daniel97molin@gmail.com", "dmdm");
		assertEquals(user.getIdUsuario(), Long.valueOf(4));
	}
	
	@Test
	public void crearTicket() {
		Ticket ticket = new Ticket(null, "Prueba de ticket (Prueba de integracion)", new Date());
		ticket.setIdEstado(new Estado(Short.valueOf("1")));
		ticket.setIdUsuario(new Usuario(Long.valueOf(4)));
		ticket = ticketController.save(ticket);
		assertNotNull(ticket.getIdTicket());
	}
	


	
	public LoginSessionBean getSessionBean() {
		return sessionBean;
	}
	
	public TicketController getTicketController() {
		return ticketController;
	}
	@Autowired
	public void setTicketController(TicketController ticketController) {
		this.ticketController = ticketController;
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
