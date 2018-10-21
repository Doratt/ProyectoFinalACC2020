package dsi235.boundary.backingBeans;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;

@ManagedBean(value="loginbb")
@SessionScope
public class LoginBackingBean implements Serializable {

	private static final long serialVersionUID = 6524787123398319687L;

	private String correo;
	private String contrasena;
	private Usuario usuarioLogueado;

	private UsuarioController usuarioController;

	public String login() {
		usuarioLogueado = usuarioController.autenticar(correo, contrasena);

		if (usuarioLogueado == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Credenciales inválidas"));
			return null;
		} else {
			return "helloworld.jsf";
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired
	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
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
