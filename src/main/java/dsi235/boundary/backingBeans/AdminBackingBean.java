package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import dsi235.controllers.TicketController;
import dsi235.controllers.TicketEncargadoController;
import dsi235.controllers.UsuarioController;
import dsi235.entities.Estado;
import dsi235.entities.Ticket;
import dsi235.entities.TicketEncargado;
import dsi235.entities.Usuario;
import dsi235.utilities.ESTADO;
import dsi235.utilities.EstadosLoader;
import dsi235.utilities.PageParser;

@ManagedBean(value = "adminBackingBean")
@ViewScoped
public class AdminBackingBean implements Serializable{

	private LazyDataModel<Ticket> model;
	private LoginSessionBean sessionBean;
	private TicketController tc;
	private TicketEncargadoController tec;
	private Ticket ticket;
	private Integer idDepartamento;
	private LoginSessionBean loginObj;
	private Usuario usuarioLogueado;
	private EstadosLoader el;
	private Estado estado;
	private List<Usuario> users,selectedPersons;
	private Usuario usuario;
	private UsuarioController uc;

	
	@PostConstruct
	private void init() {
	this.usuarioLogueado=loginObj.getUsuarioLogueado();
	this.estado=el.get(ESTADO.creado.value);
	inicializarModelo();		
	this.idDepartamento=1;
	}
	
	public void select(SelectEvent ev) {
		this.users = this.uc.findTecnicosBySucursal(usuarioLogueado.getIdSucursal().getIdSucursal(), idDepartamento,true);
	}
	
	public void actualizarTabla() {
		this.users = this.uc.findTecnicosBySucursal(usuarioLogueado.getIdSucursal().getIdSucursal(), idDepartamento,true);
	}
	
public void asignacion() {
	try {
		if(!selectedPersons.isEmpty()) {
		
			selectedPersons.forEach(item-> {
				TicketEncargado ticketasignado=new TicketEncargado(); 
				ticketasignado.setIdTicket(ticket);
				ticketasignado.setIdUsuario(item);	
				tec.save(ticketasignado);
			});
			
			ticket.setIdEstado(el.get(ESTADO.asignado.value));
			tc.save(ticket);
		}
	} catch (Exception e) {
		

	}
}
	
	
	public void inicializarModelo() {
		try {
		model=new LazyDataModel<Ticket>() {
			 @Override
             public Ticket getRowData(String rowKey) {
                 return obtenerRowData(rowKey);
             }

             @Override
             public Object getRowKey(Ticket object) {
                 return obtenerRowKey(object);
             }
             @Override
             public List<Ticket> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters){
                 return cargarDatos(first,pageSize, sortField, sortOrder, filters);
             }
		};
		}catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	   public Object obtenerRowKey(Ticket object) {
	        if (object != null) {
	            return object.getIdTicket();
	        }
	        return null;
	    }
	
	   public Ticket obtenerRowData(String rowKey) {
	        try {
	            List<Ticket> registros = (List<Ticket>) this.model.getWrappedData();
	            if (registros != null && !registros.isEmpty()) {
	                Long buscado = Long.parseLong(rowKey);
	                for (Ticket r : registros) {
	                    if (r.getIdTicket().compareTo(buscado) == 0) {
	                        return r;
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
	        }
	        return null;
	    }

	   
	public List<Ticket> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<Ticket> salida = null;
        Page<Ticket> page=null;
        try {
            if (this.tc != null) {
            	System.out.println(first);
            	page=this.tc.findNoasignadosBySucursal(usuarioLogueado.getIdSucursal().getIdSucursal(),this.estado.getIdEstado(),PageRequest.of(PageParser.parsePage(first, pageSize), pageSize));
                salida = page.getContent();
                if (this.model != null) {
                    System.out.println(page.getTotalElements());
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
	

    public LazyDataModel<Ticket> getModel() {
		return model;
	}


	public void setModel(LazyDataModel<Ticket> model) {
		this.model = model;
	}


	public LoginSessionBean getSessionBean() {
		return sessionBean;
	}

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public TicketController getTc() {
		return tc;
	}


	@Autowired
	public void setTc(TicketController tc) {
		this.tc = tc;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public LoginSessionBean getLoginObj() {
		return loginObj;
	}

	@Autowired
	public void setLoginObj(LoginSessionBean loginObj) {
		this.loginObj = loginObj;
	}

	public EstadosLoader getEl() {
		return el;
	}

	@Autowired
	public void setEl(EstadosLoader el) {
		this.el = el;
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}

	public UsuarioController getUc() {
		return uc;
	}

	@Autowired
	public void setUc(UsuarioController uc) {
		this.uc = uc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getSelectedPersons() {
		return selectedPersons;
	}

	public void setSelectedPersons(List<Usuario> selectedPersons) {
		this.selectedPersons = selectedPersons;
	}

	public TicketEncargadoController getTec() {
		return tec;
	}

	@Autowired
	public void setTec(TicketEncargadoController tec) {
		this.tec = tec;
	}
	
	
	
	
	
	
	
}
