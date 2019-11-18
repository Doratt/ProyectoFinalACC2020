package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.MarcaController;
import dsi235.controllers.NotificationController;
import dsi235.entities.Marca;
import dsi235.entities.Usuario;

@ManagedBean(value = "marcaBackingBean")
@SessionScope
public class MarcaBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2432906255201655180L;

	@Autowired
	private NotificationController nc;
	private Marca marca;
	//private Marca marcaSeleccionada;
	private Usuario usuarioLogeado;
	@Autowired
	private MarcaController controller;
	@Autowired
	private LoginSessionBean sessionBean;
	private List<Marca> marcas;
	private boolean editando = false;

	@PostConstruct
	public void init() {
		setMarcas(controller.findAll());
		marca = new Marca();
		editando = false;
	}

	public void reload() {
		init();
	}
	
	public void setEditandoTrue() {
		setEditando(true);
	}
	
	public void setEditandoFalse() {
		setEditando(false);
		marca = new Marca();
	}

	public void crearMarca() {
		System.out.println("MARCA a crear/editar:");
		System.out.println(marca);
		System.out.println(marca.getIdMarca());
		System.out.println(marca.getNombre());
		// marca.setIdUsuarioCreador(sessionBean.getUsuarioLogueado());
		try {
			PrimeFaces current = PrimeFaces.current();
			controller.save(marca);
			current.executeScript("PF('createMarca').hide()");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Exito", "Marca creada exitosamente"));

			init();
			//this.marca = new Marca();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"Parece que hubo un problema con la creación de la marca"));
			e.printStackTrace();
		}

	}
	
	public void eliminarMarca() {
		System.out.println("MARCA a eliminar:");
		System.out.println(marca);
		System.out.println(marca.getIdMarca());
		System.out.println(marca.getNombre());

		try {
			PrimeFaces current = PrimeFaces.current();
			controller.delete(marca);
			current.executeScript("PF('createMarca').hide()");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Exito", "Marca eliminada exitosamente"));

			init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"Parece que hubo un problema con la creación de la marca"));
			e.printStackTrace();
		}

	}
	
	

	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

//	public Marca getMarcaSeleccionada() {
//		return marcaSeleccionada;
//	}
//
//	public void setMarcaSeleccionada(Marca marcaSeleccionada) {
//		this.marcaSeleccionada = marcaSeleccionada;
//	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	public MarcaController getController() {
		return controller;
	}

	public void setController(MarcaController controller) {
		this.controller = controller;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public NotificationController getNc() {
		return nc;
	}

	public LoginSessionBean getSessionBean() {
		return sessionBean;
	}

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	@Autowired
	public void setNc(NotificationController nc) {
		this.nc = nc;
	}

}
