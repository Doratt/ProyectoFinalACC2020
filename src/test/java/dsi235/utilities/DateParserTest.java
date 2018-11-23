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
package dsi235.utilities;

import java.util.Date;
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
public class DateParserTest {

    public DateParserTest() {
    }

    DateParser dateParser;

    @Before
    public void setUp() {
        dateParser = new dsi235.utilities.DateParserImpl();
    }

    /**
     * Test of getTiempoResolucion method, of class DateParser.
     */
    @Test
    public void testGetTiempoResolucion() {
        System.out.println("getTiempoResolucion");
        Date fechaInicial = new Date(2018, 11, 7, 10, 32, 45);
        Date fechaFin = new Date(2018, 11, 8, 9, 56, 23);
        Long expected = Long.valueOf("84218000");
        Long milisegundos = dateParser.getTiempoResolucion(fechaInicial, fechaFin);
        assertEquals(expected, milisegundos);
    }

    @Test
    public void testGetTiempoResolucionFechaInicialMayor() {
        System.out.println("getTiempoResolucion");
        Date fechaInicial = new Date(2018, 11, 17, 10, 32, 45);
        Date fechaFin = new Date(2018, 11, 8, 9, 56, 23);
        Long expected = Long.valueOf("-779782000");
        Long milisegundos = dateParser.getTiempoResolucion(fechaInicial, fechaFin);
        assertEquals(expected, milisegundos);
    }
    
    @Test
    public void testGetTiempoResolucionFechaIguales() {
        System.out.println("getTiempoResolucion");
        Date fechaInicial = new Date(2018, 11, 8, 9, 56, 23);
        Date fechaFin = new Date(2018, 11, 8, 9, 56, 23);
        Long expected = Long.valueOf("0");
        Long milisegundos = dateParser.getTiempoResolucion(fechaInicial, fechaFin);
        assertEquals(expected, milisegundos);
    }

    public class DateParserImpl implements DateParser {

        public Long getTiempoResolucion(Date fechaInicial, Date fechaFin) {
            return null;
        }

        public String getTiempoConFormato(Date fechaInicial, Date fechaFin) {
            return "";
        }
    }

}
