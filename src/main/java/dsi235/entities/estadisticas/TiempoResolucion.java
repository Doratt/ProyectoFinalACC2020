package dsi235.entities.estadisticas;

import dsi235.entities.Ticket;

public class TiempoResolucion extends Ticket {

    private String tiempo;

    private Long tiempoResolucion;

    public Long getTiempoResolucion() {
        return tiempoResolucion;
    }

    public void setTiempoResolucion(Long tiempoResolucion) {
        this.tiempoResolucion = tiempoResolucion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

}
