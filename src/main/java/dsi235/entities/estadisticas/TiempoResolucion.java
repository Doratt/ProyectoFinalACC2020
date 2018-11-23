package dsi235.entities.estadisticas;

import dsi235.entities.Ticket;

public class TiempoResolucion {

    private Ticket ticket;
    private double tiempo;
    private String tiempoFormato;
    
    
    
	public TiempoResolucion(Ticket ticket) {
		super();
		this.ticket = ticket;
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}


	public String getTiempoFormato() {
		return tiempoFormato;
	}


	public void setTiempoFormato(String tiempoFormato) {
		this.tiempoFormato = tiempoFormato;
	}
    
	
    
    
}
