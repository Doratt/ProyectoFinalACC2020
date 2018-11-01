package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;
import dsi235.entities.UsuarioRol;

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

	public boolean isTecnico() {
		List<UsuarioRol> urList = this.usuarioLogueado.getUsuarioRolList();
		for(UsuarioRol ur : urList) {
			if(ur.getIdRol().getIdRol().equals(Short.valueOf("1"))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAdministrador() {
		List<UsuarioRol> urList = this.usuarioLogueado.getUsuarioRolList();
		for(UsuarioRol ur : urList) {
			if(ur.getIdRol().getIdRol().equals(Short.valueOf("2"))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isGerente() {
		List<UsuarioRol> urList = this.usuarioLogueado.getUsuarioRolList();
		for(UsuarioRol ur : urList) {
			if(ur.getIdRol().getIdRol().equals(Short.valueOf("3"))) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	@Autowired
	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

}
