package dsi235.boundary.backingBeans;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;

@ManagedBean(value = "loginSessionBean")
@SessionScoped
public class LoginSessionBean implements Serializable {

	public static final long serialVersionUID = 6524787123398319687L;

	private Usuario usuarioLogueado;

	private UsuarioController usuarioController;

	public void login(String correo, String contrasena) {
		usuarioLogueado = usuarioController.autenticar(correo, contrasena);
	}

	public boolean isLoggedIn() {
		return usuarioLogueado != null;
	}

	
	
	
	
	@Autowired
	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

}
