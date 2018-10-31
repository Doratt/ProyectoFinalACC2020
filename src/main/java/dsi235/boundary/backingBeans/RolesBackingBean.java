package dsi235.boundary.backingBeans;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import dsi235.controllers.UsuarioController;
import dsi235.controllers.UsuarioRolController;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
import dsi235.utilities.PageParser;

@ManagedBean(value = "rolesBackingBean")
@ViewScoped
public class RolesBackingBean {
	private Usuario usuarioLogueado;
	private UsuarioRolController usr;
	private UsuarioController uc;
	private LoginSessionBean loginHandler;
	private LazyDataModel<Usuario> model;

	@PostConstruct
	public void init() {
		this.usuarioLogueado = loginHandler.getUsuarioLogueado();
	}

	public void inicializarModelo() {
		try {
			model = new LazyDataModel<Usuario>() {
				@Override
				public Usuario getRowData(String rowKey) {
					return obtenerRowData(rowKey);
				}

				@Override
				public Object getRowKey(Usuario object) {
					return obtenerRowKey(object);
				}

				@Override
				public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					return cargarDatos(first, pageSize, sortField, sortOrder, filters);
				}
			};
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	public Object obtenerRowKey(Usuario object) {
		if (object != null) {
			return object.getIdUsuario();
		}
		return null;
	}

	public Usuario obtenerRowData(String rowKey) {
		try {
			List<Usuario> registros = (List<Usuario>) this.model.getWrappedData();
			if (registros != null && !registros.isEmpty()) {
				Long buscado = Long.parseLong(rowKey);
				for (Usuario r : registros) {
					if (r.getIdUsuario().compareTo(buscado) == 0) {
						return r;
					}
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	public List<Usuario> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Usuario> salida = null;
		Page<Usuario> page = null;

		try {
			short sucursal = this.usuarioLogueado.getIdSucursal().getIdSucursal();
			Integer idDepartamento = this.usuarioLogueado.getIdDepartamento().getIdDepartamento();
			if (this.uc != null) {
				page = this.uc.findTecnicosBySucursal(sucursal, idDepartamento, true,
						PageRequest.of(PageParser.parsePage(first, pageSize), pageSize));
				salida = page.getContent();
				if (this.model != null) {
					this.model.setRowCount((Integer.valueOf(String.valueOf(page.getTotalElements()))));

				}
			}
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			if (salida == null) {
				salida = Collections.emptyList();
			}
		}
		return salida;
	}

	
	public Usuario getUser() {
		return usuarioLogueado;
	}

	public void setUser(Usuario user) {
		this.usuarioLogueado = user;
	}

	public UsuarioRolController getUsr() {
		return usr;
	}

	@Autowired
	public void setUsr(UsuarioRolController usr) {
		this.usr = usr;
	}

	public UsuarioController getUc() {
		return uc;
	}

	@Autowired
	public void setUc(UsuarioController uc) {
		this.uc = uc;
	}

	public LoginSessionBean getLoginUser() {
		return loginHandler;
	}

	@Autowired
	public void setLoginUser(LoginSessionBean loginHandler) {
		this.loginHandler = loginHandler;
	}

	public LazyDataModel<Usuario> getModel() {
		return model;
	}

	public void setModel(LazyDataModel<Usuario> model) {
		this.model = model;
	}

}
