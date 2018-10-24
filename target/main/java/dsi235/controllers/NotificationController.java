/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.controllers;

import dsi235.entities.Usuario;

/**
 *
 * @author doratt
 */
public interface NotificationController {
    public boolean enviarCorreo(Usuario usuario, String contenido);
}
