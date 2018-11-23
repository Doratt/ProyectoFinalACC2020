package dsi235.controllers.implementaciones;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dsi235.controllers.EstadisticaController;
import dsi235.entities.Ticket;
import dsi235.entities.estadisticas.NumeroTickets;
import dsi235.entities.estadisticas.TiempoResolucion;
import dsi235.entities.repositories.TicketRepository;

@Controller
public class EstadisticaControllerImpl implements EstadisticaController{

	private TicketRepository ticketRepository;
	
	@Autowired
    public EstadisticaControllerImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}



    @Override
    public List<Ticket> verRetroalimentacion(Date fechaInicio, Date fechaFin, Short idSucursal, Integer idDepartamento, Long idTecnico) {
        
    	if(idSucursal != null) {
    		return ticketRepository.retroalimentarionBySucursal(idSucursal, fechaInicio, fechaFin);
    	}else if(idDepartamento != null) {
    		return ticketRepository.retroalimentarionByDepartamento(idDepartamento, fechaInicio, fechaFin);
    	}else if(idTecnico != null) {
    		return ticketRepository.retroalimentarionByTecnico(idTecnico, fechaInicio, fechaFin);
    	}
    	
    	return null;
    }

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Short idSucursal,
			Integer idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin, Short idSucursal,
			Integer idDepartamento, Long idTecnico) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<NumeroTickets> calcularNumTicketsDepto(Date fechaInicio, Date fechaFin, Integer idDepartamento) {
		return this.ticketRepository.numeroTicketsByDepartamento(idDepartamento, fechaInicio, fechaFin);
	}



	@Override
	public List<NumeroTickets> calcularNumTicketsSucursal(Date fechaInicio, Date fechaFin, Short idSucursal) {
		return this.ticketRepository.numeroTicketsBySucursal(idSucursal, fechaInicio, fechaFin);
	}



	@Override
	public List<NumeroTickets> calcularNumTicketsTecnico(Date fechaInicio, Date fechaFin) {
		return this.ticketRepository.numeroTicketsByTecnico(fechaInicio, fechaFin);
	}

}
