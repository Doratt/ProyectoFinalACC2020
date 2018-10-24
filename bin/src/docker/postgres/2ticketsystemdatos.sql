--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.19
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-10-16 01:38:41 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2157 (class 0 OID 16487)
-- Dependencies: 194
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cargo VALUES (1, 'Gerente', 'Gerente', true);
INSERT INTO public.cargo VALUES (2, 'Técnico', 'Técnico de soporte y mantenimiento', true);
INSERT INTO public.cargo VALUES (3, 'Operador', 'Operador de Call Center', true);
INSERT INTO public.cargo VALUES (4, 'Recepcionista', 'Recepcionista', true);
INSERT INTO public.cargo VALUES (5, 'Seguridad', 'Seguridad', true);


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 193
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cargo_id_cargo_seq', 1, false);


--
-- TOC entry 2155 (class 0 OID 16476)
-- Dependencies: 192
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departamento VALUES (1, 'IT', 'Encargados de la resolución de tickets de IT', true);
INSERT INTO public.departamento VALUES (2, 'Mantenimiento', 'Encargados de la resolución de tickets de mantenimiento', true);
INSERT INTO public.departamento VALUES (3, 'Recursos Humanos', 'Departamento de Recursos Humanos', true);
INSERT INTO public.departamento VALUES (4, 'Contabilidad', 'Departamento de Contabilidad', true);
INSERT INTO public.departamento VALUES (5, 'Atención al Cliente', 'Operadores del Call Center', true);


--
-- TOC entry 2139 (class 0 OID 16398)
-- Dependencies: 176
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.estado VALUES (1, 'Creado', 'Ticket ha sido creado');
INSERT INTO public.estado VALUES (2, 'Asignado', 'El ticket ha sido asignado a uno o más técnicos');
INSERT INTO public.estado VALUES (3, 'En pausa', 'El técnico encargado ha marcado el ticket como pausado');
INSERT INTO public.estado VALUES (4, 'Reabierto', 'El usuario solicitante o el técnico asignado ha reabierto un ticket que había sido marcado como completado');
INSERT INTO public.estado VALUES (5, 'Completado', 'El técnico ha marcado el ticket como completado');


--
-- TOC entry 2141 (class 0 OID 16406)
-- Dependencies: 178
-- Data for Name: prioridad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.prioridad VALUES (1, 'Baja', 'Prioridad baja');
INSERT INTO public.prioridad VALUES (2, 'Media', 'Prioridad media');
INSERT INTO public.prioridad VALUES (3, 'Alta', 'Prioridad Alta');


--
-- TOC entry 2161 (class 0 OID 16509)
-- Dependencies: 198
-- Data for Name: sucursal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sucursal VALUES (1, 'El Salvador', 'Boulevard Los Proceres #1016');
INSERT INTO public.sucursal VALUES (2, 'Canadá', '1250 Brown Road');


--
-- TOC entry 2153 (class 0 OID 16468)
-- Dependencies: 190
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario VALUES (1, 'Luis Doratt', 1, 2, 'luisdoratt@hotmail.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (2, 'Irvin Ayala', 2, 1, 'irvin_ayala1995@hotmail.com', '1995', 1, true);
INSERT INTO public.usuario VALUES (3, 'Andrea Cuellar', 1, 2, 'cuellarandrea10@gmail.com', 'tom', 1, true);
INSERT INTO public.usuario VALUES (4, 'Daniel Molina', 1, 2, 'daniel97molin@gmail.com', 'dmdm', 1, true);
INSERT INTO public.usuario VALUES (5, 'Steven Zaldivar', 2, 2, 'herrerachristian1897@gmail.com', '12345', 1, true);
INSERT INTO public.usuario VALUES (6, 'Juan Pérez', 5, 3, 'kevinramirez9797@gmail.cm', '1234', 1, true);
INSERT INTO public.usuario VALUES (7, 'Carlos Martínez', 3, 3, 'ticketsystem@gmail.com', '1234', 1, true);


--
-- TOC entry 2137 (class 0 OID 16387)
-- Dependencies: 174
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2143 (class 0 OID 16414)
-- Dependencies: 180
-- Data for Name: comentario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 179
-- Name: comentario_id_comentario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comentario_id_comentario_seq', 1, false);


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 191
-- Name: departamento_id_departamento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.departamento_id_departamento_seq', 1, false);


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 175
-- Name: estado_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_id_estado_seq', 1, true);


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 177
-- Name: prioridad_id_prioridad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prioridad_id_prioridad_seq', 1, false);


--
-- TOC entry 2159 (class 0 OID 16498)
-- Dependencies: 196
-- Data for Name: profesion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profesion VALUES (1, 'Técnico en computación', 'Técnico en computación', true);
INSERT INTO public.profesion VALUES (2, 'Electricista', 'Electricista', true);
INSERT INTO public.profesion VALUES (3, 'Licenciado en Administración de Empresas', 'Administración de empresas', true);
INSERT INTO public.profesion VALUES (4, 'Ingeniero en Sistemas', 'Ingeniero de Sistemas Informáticos', true);
INSERT INTO public.profesion VALUES (5, 'Ingeniero Industrial', 'Ing Industrial', true);
INSERT INTO public.profesion VALUES (6, 'Ingeniero en Telecomunicaciones', 'Redes y telecomunicaciones', true);
INSERT INTO public.profesion VALUES (7, 'Ingeniero en mecatrónica', 'Mecatrónica', true);
INSERT INTO public.profesion VALUES (8, 'Licenciado en idiomas', 'Lic en idiomas', true);


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 195
-- Name: profesion_id_profesion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesion_id_profesion_seq', 1, false);


--
-- TOC entry 2151 (class 0 OID 16449)
-- Dependencies: 188
-- Data for Name: retroalimentacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 187
-- Name: retroalimentacion_id_retroalimentacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.retroalimentacion_id_retroalimentacion_seq', 1, false);


--
-- TOC entry 2147 (class 0 OID 16433)
-- Dependencies: 184
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rol VALUES (1, 'Técnico', 'Se le asignarán tickets');
INSERT INTO public.rol VALUES (2, 'Administrador', 'Podrá asignar tickets');
INSERT INTO public.rol VALUES (3, 'Gerente', 'Podrá ver las estadísticas del ticket system');


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 183
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_id_rol_seq', 1, true);


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 197
-- Name: sucursal_id_sucursal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sucursal_id_sucursal_seq', 1, true);


--
-- TOC entry 2145 (class 0 OID 16425)
-- Dependencies: 182
-- Data for Name: ticket_encargado; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 181
-- Name: ticket_encargado_id_ticket_encargado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticket_encargado_id_ticket_encargado_seq', 1, false);


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 173
-- Name: ticket_id_ticket_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticket_id_ticket_seq', 1, false);


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 189
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, false);


--
-- TOC entry 2163 (class 0 OID 16520)
-- Dependencies: 200
-- Data for Name: usuario_profesion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario_profesion VALUES (1, 1, 1);
INSERT INTO public.usuario_profesion VALUES (3, 3, 7);
INSERT INTO public.usuario_profesion VALUES (2, 2, 4);
INSERT INTO public.usuario_profesion VALUES (4, 4, 6);
INSERT INTO public.usuario_profesion VALUES (5, 5, 4);
INSERT INTO public.usuario_profesion VALUES (6, 5, 2);
INSERT INTO public.usuario_profesion VALUES (7, 1, 2);
INSERT INTO public.usuario_profesion VALUES (8, 6, 8);
INSERT INTO public.usuario_profesion VALUES (9, 7, 8);


--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 199
-- Name: usuario_profesion_id_usuario_profesion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_profesion_id_usuario_profesion_seq', 1, false);


--
-- TOC entry 2149 (class 0 OID 16441)
-- Dependencies: 186
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario_rol VALUES (1, 1, 1);
INSERT INTO public.usuario_rol VALUES (2, 2, 1);
INSERT INTO public.usuario_rol VALUES (3, 2, 2);
INSERT INTO public.usuario_rol VALUES (4, 2, 3);
INSERT INTO public.usuario_rol VALUES (5, 3, 1);
INSERT INTO public.usuario_rol VALUES (6, 3, 2);
INSERT INTO public.usuario_rol VALUES (7, 4, 1);
INSERT INTO public.usuario_rol VALUES (8, 4, 2);
INSERT INTO public.usuario_rol VALUES (9, 5, 1);
INSERT INTO public.usuario_rol VALUES (10, 5, 2);
INSERT INTO public.usuario_rol VALUES (11, 5, 3);


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_rol_id_usuario_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_rol_id_usuario_rol_seq', 2, true);


-- Completed on 2018-10-16 01:38:41 CST

--
-- PostgreSQL database dump complete
--

