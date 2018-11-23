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
import dsi235.utilities.DateParser;
import dsi235.utilities.DateParserImpl;

@Controller
public class EstadisticaControllerImpl implements EstadisticaController{

	private TicketRepository ticketRepository;
	
	private DateParser parser = new DateParserImpl();
		
	
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


	
	
	
	
	
	
	
	@Override
	public List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal) {
		List<TiempoResolucion> lista = this.ticketRepository.calcularTiempoResolucionSucursal(fechaInicio, fechaFin, idSucursal);
		
		lista.forEach( (t)->{
			
			System.out.println("t:");
			System.out.println(t.getTicket().getIdTicket());
			System.out.println(t.getTiempo());
			
			t.setTiempo( this.parser.getTiempoResolucion(t.getTicket().getFechaCreacion(), t.getTicket().getFechaCompletado()) );
			t.setTiempoFormato( parser.getTiempoConFormato(t.getTicket().getFechaCreacion(), t.getTicket().getFechaCompletado()) );
		});
		
		return lista;
	}

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Integer idDepartamento) {
		List<TiempoResolucion> lista =  this.ticketRepository.calcularTiempoResolucionDepto(fechaInicio, fechaFin, idDepartamento);
		lista.forEach( (t)->{
			System.out.println("parser es: "+parser.toString());
			t.setTiempo( parser.getTiempoResolucion(t.getTicket().getFechaCreacion(), t.getTicket().getFechaCompletado()) );
			t.setTiempoFormato( parser.getTiempoConFormato(t.getTicket().getFechaCreacion(), t.getTicket().getFechaCompletado()) );
		});
		return lista;
	}

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin,Long idTecnico) {
		List<TiempoResolucion> lista = this.ticketRepository.calcularTiempoResolucionTecnico(fechaInicio, fechaFin, idTecnico);
		
		lista.forEach( (t)->{
			t.setTiempo( parser.getTiempoResolucion(t.getTicket().getFechaCreacion(), t.getTicket().getFechaCompletado()) );
			t.setTiempoFormato( parser.getTiempoConFormato(t.getTicket().getFechaCreacion(), t.getTicket().getFechaCompletado()) );
		});
		
		return lista;
	}
	
	

}
