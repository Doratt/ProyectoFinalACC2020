package dsi235.controllers.implementaciones;

import org.springframework.stereotype.Controller;

import dsi235.controllers.NotificationController;
import dsi235.entities.Usuario;

@Controller
public class NotificacionControllerImpl implements NotificationController {
    
    //TODO
    @Override
    public boolean enviarCorreo(Usuario usuario, String contenido) {
        return false;
    }
}
