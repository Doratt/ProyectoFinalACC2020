/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dsi235.controllers;

import dsi235.entities.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author irvin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationControllerTest {

    public NotificationControllerTest() {
    }

    private NotificationController notificationController;

    /**
     * Test of enviarCorreo method, of class NotificationController.
     */
    @Test
    public void testEnviarCorreo() {
        System.out.println("enviarCorreo");
        Usuario usuario = new Usuario(Long.valueOf(1), "Luis Doratt", "luisdoratt@hotmail.com", "1234", true);
        String contenido = "Prueba de envio de correo.";
        boolean enviado = notificationController.enviarCorreo(usuario, contenido);
        assertEquals(true, enviado);
    }

    public class NotificationControllerImpl implements NotificationController {

        public boolean enviarCorreo(Usuario usuario, String contenido) {
            return false;
        }
    }

    public NotificationController getNotificationController() {
        return notificationController;
    }

    @Autowired
    public void setNotificationController(NotificationController notificationController) {
        this.notificationController = notificationController;
    }

}
