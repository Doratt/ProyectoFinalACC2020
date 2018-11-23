package dsi235.entities.estadisticas;

import dsi235.entities.Usuario;

public class NumeroTickets {

	private Usuario usuario;
	private long numerotickets;

	
	
	
	public NumeroTickets(Usuario usuario, long numerotickets) {
		super();
		this.usuario = usuario;
		this.numerotickets = numerotickets;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getNumerotickets() {
		return numerotickets;
	}

	public void setNumerotickets(long numerotickets) {
		this.numerotickets = numerotickets;
	}

}
