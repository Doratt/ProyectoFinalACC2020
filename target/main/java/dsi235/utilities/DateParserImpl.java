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
        Long diferenciaMilis;
        diferenciaMilis = fechaFin.getTime() - fechaInicial.getTime();
        return diferenciaMilis;
    }

    @Override
    public String getTiempoConFormato(Date fechaInicial, Date fechaFin) {
        return "";
    }
    
    

}
