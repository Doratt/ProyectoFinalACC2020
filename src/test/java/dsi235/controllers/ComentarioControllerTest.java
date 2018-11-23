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
import dsi235.entities.Ticket;
import dsi235.entities.Usuario;
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
public class ComentarioControllerTest {

    public ComentarioControllerTest() {
    }

    private ComentarioController comentarioController;

    /**
     * Test of findByIdTicket method, of class ComentarioController.
     */
    @Test
    public void testFindByIdTicket() {
        System.out.println("findByIdTicket");
        Ticket idTicket = new Ticket(Long.valueOf(8));
        List<Comentario> comentarios = comentarioController.findByIdTicket(idTicket);
        assertEquals(comentarios.size(), 3);
    }

    public class ComentarioControllerImpl implements ComentarioController {

        public List<Comentario> findByIdTicket(Ticket idTicket) {
            return null;
        }

        @Override
        public Optional<Comentario> findById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Comentario> findAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comentario save(Comentario entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void deleteById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Comentario entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public ComentarioController getComentarioController() {
        return comentarioController;
    }

    @Autowired
    public void setComentarioController(ComentarioController comentarioController) {
        this.comentarioController = comentarioController;
    }

}
