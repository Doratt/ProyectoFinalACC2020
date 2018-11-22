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

import dsi235.entities.TicketEncargado;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author irvin
 */
public class TicketEncargadoControllerTest {
    
    public TicketEncargadoControllerTest() {
    }

    /**
     * Test of findByIdTicket_IdTicket method, of class TicketEncargadoController.
     */
    @Test
    public void testFindByIdTicket_IdTicket() {
        System.out.println("findByIdTicket_IdTicket");
        Long idTicket = null;
        TicketEncargadoController instance = new TicketEncargadoControllerImpl();
        List<TicketEncargado> expResult = null;
        List<TicketEncargado> result = instance.findByIdTicket_IdTicket(idTicket);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class TicketEncargadoControllerImpl implements TicketEncargadoController {

        public List<TicketEncargado> findByIdTicket_IdTicket(Long idTicket) {
            return null;
        }

        @Override
        public Optional<TicketEncargado> findById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<TicketEncargado> findAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public TicketEncargado save(TicketEncargado entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void deleteById(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(TicketEncargado entity) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
