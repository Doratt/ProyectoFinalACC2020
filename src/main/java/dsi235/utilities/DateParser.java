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
public interface DateParser {
    public Long getTiempoResolucion(Date fechaInicial, Date fechaFin);
    public String getTiempoConFormato(Date fechaInicial,Date fechaFin);
}
