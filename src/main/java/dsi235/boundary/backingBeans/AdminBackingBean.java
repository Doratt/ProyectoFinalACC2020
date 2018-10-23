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

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import dsi235.controllers.TicketController;
import dsi235.entities.Ticket;

@ManagedBean(value = "adminBackingBean")
@ViewScoped
public class AdminBackingBean implements Serializable{

	private LazyDataModel<Ticket> model;
	private LoginSessionBean sessionBean;
	private TicketController tc;
	private Ticket ticket;
	
	@PostConstruct
	private void init() {
	inicializarModelo();	
		
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
        try {
            if (this.tc != null) {
            	Page<Ticket> page=this.tc.findAll(PageRequest.of(first, pageSize));
                salida = page.getContent();
                if (this.model != null) {
                    this.model.setRowCount(page.getSize());
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
	
	
	
	
	
}
