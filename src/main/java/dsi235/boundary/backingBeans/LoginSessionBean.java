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

	private String correo;
	private String contrasena;
	private Usuario usuarioLogueado;
	private final static String MAIN_URL = "paginaprincipal.jsf?faces-redirect=true";

	private UsuarioController usuarioController;

	public String login() {
		usuarioLogueado = usuarioController.autenticar(correo, contrasena);

		if (usuarioLogueado == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales inválidas", ""));
			return null;
		} else {
			return MAIN_URL;
		}
	}

	public boolean isLoggedIn() {
		return usuarioLogueado != null;
	}

	public String redirect() {
		if(isLoggedIn()) {
			return null;
		}
		return MAIN_URL;
	}
	
	
	
	
	
	@Autowired
	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
