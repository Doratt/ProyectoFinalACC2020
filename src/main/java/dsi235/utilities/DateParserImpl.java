/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.utilities;

import java.util.Date;

/**
 *
 * @author doratt
 */
public class DateParserImpl implements DateParser {

	@Override
	public Long getTiempoResolucion(Date fechaInicial, Date fechaFin) {
		if (fechaInicial != null && fechaFin != null) {
			Long diferenciaMilis;
			diferenciaMilis = fechaFin.getTime() - fechaInicial.getTime();
			return diferenciaMilis;
		}
		return 0L;
	}

	@Override
	public String getTiempoConFormato(Date fechaInicial, Date fechaFin) {
		Long tiempo = this.getTiempoResolucion(fechaInicial, fechaFin);
		if (tiempo != 0) {
			String tiempoFormato = "";

			if (tiempo > 86400000) {
				tiempoFormato += Math.floorDiv(tiempo, 86400000) + "d ";
				tiempo = tiempo - Math.floorDiv(tiempo, 86400000) * 86400000;
			}
			if (tiempo > 3600000) {
				tiempoFormato += Math.floorDiv(tiempo, 3600000) + "h ";
				tiempo = tiempo - Math.floorDiv(tiempo, 3600000) * 3600000;
			}
			if (tiempo > 60000) {
				tiempo = Math.floorDiv(tiempo, 60000);
				tiempoFormato += tiempo.toString() + "m";
			}

			return tiempoFormato;
		}
		return "0";
	}

}
