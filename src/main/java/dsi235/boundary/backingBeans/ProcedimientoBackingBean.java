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

import dsi235.controllers.NotificationController;
import dsi235.controllers.ProcedimientoController;
import dsi235.entities.Correlativo;
import dsi235.entities.Procedimiento;
import dsi235.entities.Usuario;

@ManagedBean(value = "procedimientoBackingBean")
@SessionScope
public class ProcedimientoBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2432906255201655180L;

	@Autowired
	private NotificationController nc;
	private Procedimiento procedimiento;
	private Usuario usuarioLogeado;
	@Autowired
	private ProcedimientoController controller;
	@Autowired
	private LoginSessionBean sessionBean;
	private List<Procedimiento> procedimientos;
	private boolean editando = false;

	@PostConstruct
	public void init() {
		setProcedimientos(controller.findAll());
		procedimiento = new Procedimiento();
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
		procedimiento = new Procedimiento();
	}

	public void crearProcedimiento() {
		System.out.println("PROC a crear/editar:");
		System.out.println(procedimiento);
		System.out.println(procedimiento.getIdProcedimiento());
		System.out.println(procedimiento.getNombre());

		try {
			PrimeFaces current = PrimeFaces.current();
			controller.save(procedimiento);
			current.executeScript("PF('createProcedimiento').hide()");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Exito", "Procedimiento creado exitosamente"));

			init();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"Parece que hubo un problema con la creación del procedimiento"));
			e.printStackTrace();
		}

	}

	public void eliminarProcedimiento() {
		System.out.println("PROC a eliminar:");
		System.out.println(procedimiento);
		System.out.println(procedimiento.getIdProcedimiento());
		System.out.println(procedimiento.getNombre());
		
		try {
			List<Correlativo> correlativos = controller.correlativosPorProcedimiento(procedimiento.getIdProcedimiento());
			if(correlativos.isEmpty()) {
			
			PrimeFaces current = PrimeFaces.current();
			controller.delete(procedimiento);
			current.executeScript("PF('createProcedimiento').hide()");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Exito", "Procedimiento eliminado exitosamente"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						"No se puede eliminar el procedimiento porque hay correlativos que dependen de él"));
			}
			init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"Parece que hubo un problema con la creación del procedimiento"));
			e.printStackTrace();
		}

	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	public ProcedimientoController getController() {
		return controller;
	}

	public void setController(ProcedimientoController controller) {
		this.controller = controller;
	}

	public List<Procedimiento> getProcedimientos() {
		return procedimientos;
	}

	public void setProcedimientos(List<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}

	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
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
