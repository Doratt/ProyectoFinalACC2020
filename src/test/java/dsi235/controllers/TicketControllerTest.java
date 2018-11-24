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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author irvin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketControllerTest {
    
    public TicketControllerTest() {
    }
    
    private TicketController ticketController;

    public TicketController getTicketController() {
        return ticketController;
    }

    @Autowired
    public void setTicketController(TicketController ticketController) {
        this.ticketController = ticketController;
    }
        

    /**
     * Test of findCompletadosByEncargado method, of class TicketController.
     */
    @Test
    public void testFindCompletadosByEncargado() {
        System.out.println("findCompletadosByEncargado");
        Long idEncargado = Long.valueOf(1);
        Pageable pg = PageRequest.of(0, 1000);
        Page<Ticket> tickets = ticketController.findCompletadosByEncargado(idEncargado, pg);
        assertEquals(1, tickets.getTotalElements());
    }

    /**
     * Test of findNoCompletadosByEncargado method, of class TicketController.
     */
    @Test
    public void testFindNoCompletadosByEncargado() {
        System.out.println("findNoCompletadosByEncargado");
        Long idEncargado = Long.valueOf("1");
        List<Ticket> tickets;
        tickets = ticketController.findNoCompletadosByEncargado(idEncargado);
        assertEquals(2, tickets.size());
    }

//    /**
//     * Test of findCompletadosByUsuario method, of class TicketController.
//     */
//    @Test
//    public void testFindCompletadosByUsuario() {
//        System.out.println("findCompletadosByUsuario");
//        Long idUsuario = null;
//        Pageable pg = null;
//        TicketController instance = new TicketControllerImpl();
//        Page<Ticket> expResult = null;
//        Page<Ticket> result = instance.findCompletadosByUsuario(idUsuario, pg);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findNoCompletadosByUsuario method, of class TicketController.
//     */
//    @Test
//    public void testFindNoCompletadosByUsuario() {
//        System.out.println("findNoCompletadosByUsuario");
//        Long idUsuario = null;
//        TicketController instance = new TicketControllerImpl();
//        List<Ticket> expResult = null;
//        List<Ticket> result = instance.findNoCompletadosByUsuario(idUsuario);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findNoAsignados method, of class TicketController.
//     */
//    @Test
//    public void testFindNoAsignados() {
//        System.out.println("findNoAsignados");
//        Short idSucursal = null;
//        int first = 0;
//        int pageSize = 0;
//        TicketController instance = new TicketControllerImpl();
//        List<Ticket> expResult = null;
//        List<Ticket> result = instance.findNoAsignados(idSucursal, first, pageSize);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of reabrirTicket method, of class TicketController.
//     */
//    @Test
//    public void testReabrirTicket() {
//        System.out.println("reabrirTicket");
//        int idTicket = 0;
//        TicketController instance = new TicketControllerImpl();
//        Ticket expResult = null;
//        Ticket result = instance.reabrirTicket(idTicket);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of marcarMalAsignado method, of class TicketController.
//     */
//    @Test
//    public void testMarcarMalAsignado() {
//        System.out.println("marcarMalAsignado");
//        int idTicket = 0;
//        TicketController instance = new TicketControllerImpl();
//        Ticket expResult = null;
//        Ticket result = instance.marcarMalAsignado(idTicket);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of gestionarEstadoTicket method, of class TicketController.
//     */
//    @Test
//    public void testGestionarEstadoTicket() {
//        System.out.println("gestionarEstadoTicket");
//        int idTicket = 0;
//        int idEstado = 0;
//        TicketController instance = new TicketControllerImpl();
//        Ticket expResult = null;
//        Ticket result = instance.gestionarEstadoTicket(idTicket, idEstado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findNoasignadosBySucursal method, of class TicketController.
//     */
//    @Test
//    public void testFindNoasignadosBySucursal() {
//        System.out.println("findNoasignadosBySucursal");
//        Short idSucursal = null;
//        Short idEstado = null;
//        Pageable pg = null;
//        TicketController instance = new TicketControllerImpl();
//        Page<Ticket> expResult = null;
//        Page<Ticket> result = instance.findNoasignadosBySucursal(idSucursal, idEstado, pg);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    public class TicketControllerImpl implements TicketController {

        public Page<Ticket> findCompletadosByEncargado(Long idEncargado, Pageable pg) {
            return null;
        }

        public List<Ticket> findNoCompletadosByEncargado(Long idEncargado) {
            return null;
        }

        public Page<Ticket> findCompletadosByUsuario(Long idUsuario, Pageable pg) {
            return null;
        }

        public List<Ticket> findNoCompletadosByUsuario(Long idUsuario) {
            return null;
        }

        public List<Ticket> findNoAsignados(Short idSucursal, int first, int pageSize) {
            return null;
        }

        public Ticket reabrirTicket(int idTicket) {
            return null;
        }

        public Ticket marcarMalAsignado(int idTicket) {
            return null;
        }

        public Ticket gestionarEstadoTicket(int idTicket, int idEstado) {
            return null;
        }

        public Page<Ticket> findNoasignadosBySucursal(Short idSucursal, Short idEstado, Pageable pg) {
            return null;
        }

        @Override
        public Optional<Ticket> findById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Ticket> findAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Ticket save(Ticket entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void deleteById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Ticket entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
