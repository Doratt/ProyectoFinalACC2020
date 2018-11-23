package dsi235.boundary.backingBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(value = "loginBackingBean")
@ViewScoped
public class LoginBackingBean implements Serializable {

	private static final long serialVersionUID = 6524787123398319687L;
	private String correo;
	private String contrasena;
	private final static String MAIN_URL = "dashboard.jsf?faces-redirect=true";
	// Autowired
	private LoginSessionBean sessionBean;

	public String login() {

		sessionBean.login(correo, contrasena);

		if (sessionBean.getUsuarioLogueado() == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application app = context.getApplication();
			ResourceBundle trad = app.getResourceBundle(context, "trad");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, trad.getString("login.credencialesinvalidas"), ""));
			return null;
		} else {
			return MAIN_URL;
		}
	}

	@PostConstruct
	public void redireccionarSiEstaLogueado() {
		if (sessionBean.isLoggedIn()) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(MAIN_URL);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public String redirect() {
		if (sessionBean.isLoggedIn()) {
			return null;
		}
		return MAIN_URL;
	}

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
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
