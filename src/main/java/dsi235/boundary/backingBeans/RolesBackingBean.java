package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import dsi235.controllers.UsuarioController;
import dsi235.controllers.UsuarioRolController;
import dsi235.entities.Rol;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
import dsi235.entities.UsuarioRol;
import dsi235.utilities.PageParser;

@ManagedBean(value = "rolesBackingBean")
@ViewScoped
public class RolesBackingBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3518758767678270767L;
	private Usuario usuarioLogueado, usuarioBindeado;
	private UsuarioRolController urc;
	private UsuarioController uc;
	private LoginSessionBean loginHandler;
	private LazyDataModel<Usuario> model;
	private List<SelectItem> roles;
	private List<String> checked;

	@PostConstruct
	public void init() {
		checked = new ArrayList<>();
		roles = new ArrayList<SelectItem>();
		roles.add(new SelectItem("1", "Tecnico"));
		roles.add(new SelectItem("2", "Administrador"));
		roles.add(new SelectItem("3", "Gerente"));
		this.usuarioLogueado = loginHandler.getUsuarioLogueado();

		inicializarModelo();

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

	public void select() {
		checked.clear();
		try {
			usuarioBindeado.getUsuarioRolList().forEach(r -> {
				if(r.getActivo())
				checked.add(String.valueOf(r.getIdRol().getIdRol()));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardar() {
		System.out.println(checked);
		List<UsuarioRol> ur = usuarioBindeado.getUsuarioRolList();
		List<Short> rolesDeUser = new ArrayList<>();
		for (UsuarioRol usuarioRol : ur) {
			rolesDeUser.add(usuarioRol.getIdRol().getIdRol());
		}

		for (int i = 1; i <= 3; i++) {
			System.out.println("Estoy en for");
			// En caso de que este seleccionado el check y este en la base, sera activo si
// no es activo
			if (rolesDeUser.contains(Short.valueOf(String.valueOf(i))) && checked.contains(String.valueOf(i))) {
				System.out.println("Estoy en la base y en el check");
				for (UsuarioRol usuarioRol : ur) {
					if (usuarioRol.getIdRol().getIdRol() == i) {
						if (!usuarioRol.getActivo()) {
							usuarioRol.setActivo(true);
							urc.save(usuarioRol);
							inicializarModelo();
							
						}
					}
				}
				// En caso de que no este seleccionado el check y este en la base, sera no
				// activo si es activo
			} else if (rolesDeUser.contains(Short.valueOf(String.valueOf(i))) && !checked.contains(String.valueOf(i))) {
				System.out.println("Estoy en la base y NO en el check");
				for (UsuarioRol usuarioRol : ur) {
					if (usuarioRol.getIdRol().getIdRol() == i) {
						if (usuarioRol.getActivo()) {
							usuarioRol.setActivo(false);
							urc.save(usuarioRol);
							inicializarModelo();
						}
					}
				}
				// En caso de que este seleccionado el check y no este en la base, crea un nuevo
				// registro
			} else if (!rolesDeUser.contains(Short.valueOf(String.valueOf(i))) && checked.contains(String.valueOf(i))) {
				System.out.println("NO estoy en la base y si en el check");
				UsuarioRol nuevoRol = new UsuarioRol();
				nuevoRol.setActivo(true);
				nuevoRol.setFechaCreacion(new Date());
				nuevoRol.setIdUsuario(usuarioBindeado);
				nuevoRol.setIdRol(new Rol(Short.valueOf(String.valueOf(i))));
				nuevoRol.setIdUsuarioCreador(usuarioLogueado);
				urc.save(nuevoRol);
				inicializarModelo();
			}
		}
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('rol_dialog').hide()");
	}

	public List<Usuario> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Usuario> salida = null;
		Page<Usuario> page = null;

		try {
			short sucursal = this.usuarioLogueado.getIdSucursal().getIdSucursal();
			if (this.uc != null) {
				page = this.uc.findTecnicosBySucursal(sucursal, true,
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

	public UsuarioRolController getUrc() {
		return urc;
	}

	@Autowired
	public void setUrc(UsuarioRolController urc) {
		this.urc = urc;
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

	public List<SelectItem> getRoles() {
		return roles;
	}

	public void setRoles(List<SelectItem> roles) {
		this.roles = roles;
	}

	public Usuario getUsuarioBindeado() {
		return usuarioBindeado;
	}

	public void setUsuarioBindeado(Usuario usuarioBindeado) {
		this.usuarioBindeado = usuarioBindeado;
	}

	public List<String> getChecked() {
		return checked;
	}

	public void setChecked(List<String> checked) {
		this.checked = checked;
	}

}
