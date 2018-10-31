package dsi235.boundary.backingBeans;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.context.annotation.SessionScope;

import dsi235.controllers.TicketController;
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
import dsi235.utilities.PageParser;

@ManagedBean(value="historialUsuarioBackingBean")
@SessionScope
public class historialUsuarioBackingBean implements Serializable{
	
	private static final long serialVersionUID = 2432906255201655180L;
	
	private LazyDataModel<Ticket> model;
	private Ticket ticket;
	private Usuario usuarioLogeado;
	private TicketController tc;
	private LoginSessionBean sessionBean;
	private Page<Ticket> historialTicketUsuario;

	
	
	@PostConstruct
    public void init() {
		usuarioLogeado = sessionBean.getUsuarioLogueado();
		inicializarModelo();
		//historialTicketUsuario= this.tc.findCompletadosByUsuario(sessionBean.getUsuarioLogueado().getIdUsuario(), 0, 5);
		//System.out.println(historialTicketUsuario);
		//historialTicketTecnico= tc.findCompletadosByEncargado(sessionBean.getUsuarioLogueado().getIdUsuario(), 1, 5);
	}
	
	public void inicializarModelo() {
		System.out.println("Me estoy inicializando");
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
		   System.out.println("Obteniendo row data");
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
            	System.out.println("El first es: "+first);
            	System.out.println("El pagesize es: "+pageSize);
            	System.out.println("El page parser devuelve: "+PageParser.parsePage(first, pageSize));
            	page=tc.findCompletadosByUsuario(usuarioLogeado.getIdUsuario(), PageRequest.of(PageParser.parsePage(first, pageSize), pageSize));
                System.out.println(page);
            	salida = page.getContent();
            	System.out.println(salida);
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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	public TicketController getTc() {
		return tc;
	}

	@Autowired
	public void setTc(TicketController tc) {
		this.tc = tc;
	}

	@Autowired
	public void setSessionBean(LoginSessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public Page<Ticket> getHistorialTicketUsuario() {
		return historialTicketUsuario;
	}

	public void setHistorialTicketUsuario(Page<Ticket> historialTicket) {
		this.historialTicketUsuario = historialTicket;
	}

}
