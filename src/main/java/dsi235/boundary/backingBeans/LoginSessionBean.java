package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import dsi235.controllers.UsuarioController;
import dsi235.entities.Usuario;
import dsi235.entities.UsuarioRol;

@ManagedBean(value = "loginSessionBean")
@SessionScoped
public class LoginSessionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuarioLogueado;

	private UsuarioController usuarioController;

	private Locale locale;

	@PostConstruct
	public void init() {
		//locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		locale = new Locale("spa");
	}

	public void login(String correo, String contrasena) {
		usuarioLogueado = usuarioController.autenticar(correo, contrasena);
	}

	public void changeLanguageUS() {
		try {
			locale = new Locale("eng");
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeLanguageES() {
		try {
			locale = new Locale("spa");
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isLoggedIn() {
		return usuarioLogueado != null;
	}

	public boolean isTecnico() {
		List<UsuarioRol> urList = this.usuarioLogueado.getUsuarioRolList();
		for (UsuarioRol ur : urList) {
			if (ur.getIdRol().getIdRol().equals(Short.valueOf("1"))) {
				return true;
			}
		}
		return false;
	}

	public boolean isAdministrador() {
		List<UsuarioRol> urList = this.usuarioLogueado.getUsuarioRolList();
		for (UsuarioRol ur : urList) {
			if (ur.getIdRol().getIdRol().equals(Short.valueOf("2"))) {
				return true;
			}
		}
		return false;
	}

	public boolean isGerente() {
		List<UsuarioRol> urList = this.usuarioLogueado.getUsuarioRolList();
		for (UsuarioRol ur : urList) {
			if (ur.getIdRol().getIdRol().equals(Short.valueOf("3"))) {
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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
