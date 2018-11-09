package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

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
	private Usuario usuarioLogueado, usuarioBindeado;
	private UsuarioRolController urc;
	private UsuarioController uc;
	private LoginSessionBean loginHandler;
	private LazyDataModel<Usuario> model;
	private List<SelectItem> roles;
	private List<String> checked;

	@PostConstruct
	public void init(){
		checked=new ArrayList<>();
		roles=new ArrayList<SelectItem>();
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
		usuarioBindeado.getUsuarioRolList().forEach(r->{
			checked.add(String.valueOf(r.getIdRol().getIdRol()));
		});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardar() {
		List<Rol> roles = usuarioBindeado.getRolList();
		List<Short> idRoles = new ArrayList<Short>();
		for (Rol rol : roles) {
			idRoles.add(rol.getIdRol());
		}
		/*checked.forEach(rol->{
			UsuarioRol urRol = new UsuarioRol();
			urRol.setIdUsuario(usuarioBindeado);
			urRol.setIdUsuarioModificador(usuarioLogueado);
			urRol.setIdRol(new Rol(Short.valueOf(rol)));
			urRol.setFechaCreacion(new Date());
			urRol.setIdUsuarioCreador(usuarioLogueado);
			urc.save(urRol);
		});*/
		for(int i=1; i<=3; i++) {
			if(checked.contains(i) && idRoles.contains(i)) {
				roles.get(i).setActivo(true);
			}else if(checked.contains(i) && !idRoles.contains(i)) {
				UsuarioRol urRol = new UsuarioRol();
				urRol.setIdUsuario(usuarioBindeado);
				urRol.setIdUsuarioModificador(usuarioLogueado);
				urRol.setIdRol(new Rol(Short.valueOf(checked.get(i))));
				urRol.setFechaCreacion(new Date());
				urRol.setIdUsuarioCreador(usuarioLogueado);
				urc.save(urRol);
			}else if(!checked.contains(i) && idRoles.contains(i)) {
				roles.get(i).setActivo(false);
			}
		}
		
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
