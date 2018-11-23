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
import dsi235.entities.estadisticas.NumeroTickets;
import dsi235.entities.estadisticas.TiempoResolucion;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author irvin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadisticaControllerTest {
    
    public EstadisticaControllerTest() {
    }
    
    

    /**
     * Test of calcularTiempoResolucionSucursal method, of class EstadisticaController.
     */
    @Test
    public void testCalcularTiempoResolucionSucursal() {
        System.out.println("calcularTiempoResolucionSucursal");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        EstadisticaController instance = new EstadisticaControllerImpl();
        List<TiempoResolucion> expResult = null;
        List<TiempoResolucion> result = instance.calcularTiempoResolucionSucursal(fechaInicio, fechaFin, idSucursal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTiempoResolucionDepto method, of class EstadisticaController.
     */
    @Test
    public void testCalcularTiempoResolucionDepto() {
        System.out.println("calcularTiempoResolucionDepto");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        int idDepartamento = 0;
        EstadisticaController instance = new EstadisticaControllerImpl();
        List<TiempoResolucion> expResult = null;
        List<TiempoResolucion> result = instance.calcularTiempoResolucionDepto(fechaInicio, fechaFin, idSucursal, idDepartamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTiempoResolucionTecnico method, of class EstadisticaController.
     */
    @Test
    public void testCalcularTiempoResolucionTecnico() {
        System.out.println("calcularTiempoResolucionTecnico");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        int idDepartamento = 0;
        Long idTecnico = null;
        EstadisticaController instance = new EstadisticaControllerImpl();
        List<TiempoResolucion> expResult = null;
        List<TiempoResolucion> result = instance.calcularTiempoResolucionTecnico(fechaInicio, fechaFin, idSucursal, idDepartamento, idTecnico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularNumTicketsDepto method, of class EstadisticaController.
     */
    @Test
    public void testCalcularNumTicketsDepto() {
        System.out.println("calcularNumTicketsDepto");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        EstadisticaController instance = new EstadisticaControllerImpl();
        NumeroTickets expResult = null;
        NumeroTickets result = instance.calcularNumTicketsDepto(fechaInicio, fechaFin, idSucursal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularNumTicketsUsuario method, of class EstadisticaController.
     */
    @Test
    public void testCalcularNumTicketsUsuario() {
        System.out.println("calcularNumTicketsUsuario");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        int idDepartamento = 0;
        EstadisticaController instance = new EstadisticaControllerImpl();
        NumeroTickets expResult = null;
        NumeroTickets result = instance.calcularNumTicketsUsuario(fechaInicio, fechaFin, idSucursal, idDepartamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularNumTicketsTecnico method, of class EstadisticaController.
     */
    @Test
    public void testCalcularNumTicketsTecnico() {
        System.out.println("calcularNumTicketsTecnico");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        int idDepartamento = 0;
        EstadisticaController instance = new EstadisticaControllerImpl();
        NumeroTickets expResult = null;
        NumeroTickets result = instance.calcularNumTicketsTecnico(fechaInicio, fechaFin, idSucursal, idDepartamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verRetroalimentacion method, of class EstadisticaController.
     */
    @Test
    public void testVerRetroalimentacion() {
        System.out.println("verRetroalimentacion");
        Date fechaInicio = null;
        Date fechaFin = null;
        Short idSucursal = null;
        int idDepartamento = 0;
        Long idTecnico = null;
        EstadisticaController instance = new EstadisticaControllerImpl();
        List<Ticket> expResult = null;
        List<Ticket> result = instance.verRetroalimentacion(fechaInicio, fechaFin, idSucursal, idDepartamento, idTecnico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EstadisticaControllerImpl implements EstadisticaController {

        public List<TiempoResolucion> calcularTiempoResolucionSucursal(Date fechaInicio, Date fechaFin, Short idSucursal) {
            return null;
        }

        public List<TiempoResolucion> calcularTiempoResolucionDepto(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento) {
            return null;
        }

        public List<TiempoResolucion> calcularTiempoResolucionTecnico(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Long idTecnico) {
            return null;
        }

        public NumeroTickets calcularNumTicketsDepto(Date fechaInicio, Date fechaFin, Short idSucursal) {
            return null;
        }

        public NumeroTickets calcularNumTicketsUsuario(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento) {
            return null;
        }

        public NumeroTickets calcularNumTicketsTecnico(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento) {
            return null;
        }

        public List<Ticket> verRetroalimentacion(Date fechaInicio, Date fechaFin, Short idSucursal, int idDepartamento, Long idTecnico) {
            return null;
        }
    }
    
}
