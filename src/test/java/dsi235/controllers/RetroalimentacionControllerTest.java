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

import dsi235.entities.Comentario;
import dsi235.entities.Retroalimentacion;
import dsi235.entities.Ticket;
import java.util.List;
import java.util.Optional;
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
public class RetroalimentacionControllerTest {

    public RetroalimentacionControllerTest() {
    }

    private RetroalimentacionController retroalimentacionController;
    private TicketController ticketController;

    /**
     * Test of calificarTicket method, of class RetroalimentacionController.
     */
    @Test
    public void testCalificarTicket() {
        System.out.println("calificarTicket");
        int calificacion = 7;
        Optional<Ticket> ticket= ticketController.findById(Long.valueOf(6));
        String comentario = "Comentario realizado por prueba";
        retroalimentacionController.calificarTicket(calificacion, ticket.get(), comentario);
        
        assertEquals(ticket.get().getRetroalimentacion().getCalificacion(), calificacion);
        assertEquals(ticket.get().getRetroalimentacion().getComentario(), comentario);
       
    }

    public class RetroalimentacionControllerImpl implements RetroalimentacionController {

        public void calificarTicket(int calificacion, Ticket ticket, String comentario) {
        }

        @Override
        public Optional<Retroalimentacion> findById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Retroalimentacion> findAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Retroalimentacion save(Retroalimentacion entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void deleteById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Retroalimentacion entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public RetroalimentacionController getRetroalimentacionController() {
        return retroalimentacionController;
    }

    @Autowired
    public void setRetroalimentacionController(RetroalimentacionController retroalimentacionController) {
        this.retroalimentacionController = retroalimentacionController;
    }

    public TicketController getTicketController() {
        return ticketController;
    }

    @Autowired
    public void setTicketController(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    
}
