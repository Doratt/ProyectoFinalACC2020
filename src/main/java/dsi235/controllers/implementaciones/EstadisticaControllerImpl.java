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
    public NumeroTickets calcularNumTicketsDepto(Date fechaInicio, Date fechaFin, Short idSucursal) {
        return null;
    }

    //Ordenar por numero de tickets
    @Override
    public NumeroTickets calcularNumTicketsUsuario(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento) {
        return null;
    }

    @Override
    public NumeroTickets calcularNumTicketsTecnico(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento) {
        return null;
    }

    @Override
    public List<Ticket> verRetroalimentacion(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Long idTecnico) {
        return null;
    }

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Short idSucursal,
			int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin, Short idSucursal,
			int idDepartamento, Long idTecnico) {
		// TODO Auto-generated method stub
		return null;
	}

}
