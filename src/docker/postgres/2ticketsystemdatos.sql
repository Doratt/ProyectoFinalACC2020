--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.19
-- Dumped by pg_dump version 9.6.10

-- Started on 2018-10-31 13:17:14 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2158 (class 0 OID 16385)
-- Dependencies: 173
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cargo VALUES (1, 'Gerente', 'Gerente', true);
INSERT INTO public.cargo VALUES (2, 'Técnico', 'Técnico de soporte y mantenimiento', true);
INSERT INTO public.cargo VALUES (3, 'Operador', 'Operador de Call Center', true);
INSERT INTO public.cargo VALUES (4, 'Recepcionista', 'Recepcionista', true);
INSERT INTO public.cargo VALUES (5, 'Seguridad', 'Seguridad', true);


--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 174
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cargo_id_cargo_seq', 1, false);


--
-- TOC entry 2162 (class 0 OID 16402)
-- Dependencies: 177
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departamento VALUES (1, 'IT', 'Encargados de la resolución de tickets de IT', true);
INSERT INTO public.departamento VALUES (2, 'Mantenimiento', 'Encargados de la resolución de tickets de mantenimiento', true);
INSERT INTO public.departamento VALUES (3, 'Recursos Humanos', 'Departamento de Recursos Humanos', true);
INSERT INTO public.departamento VALUES (4, 'Contabilidad', 'Departamento de Contabilidad', true);
INSERT INTO public.departamento VALUES (5, 'Atención al Cliente', 'Operadores del Call Center', true);


--
-- TOC entry 2174 (class 0 OID 16446)
-- Dependencies: 189
-- Data for Name: sucursal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sucursal VALUES (1, 'Santa Ana', 'Av La Revolucion 222, San Salvador');
INSERT INTO public.sucursal VALUES (2, 'Canadá', '180 Boulevard Gagnon');


--
-- TOC entry 2180 (class 0 OID 16469)
-- Dependencies: 195
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario VALUES (1, 'Luis Doratt', 1, 1, 'd@d.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (2, 'Irvin Steven', 2, 2, 'i@i.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (3, 'Daniel Molina', 1, 2, 'm@m.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (6, 'Juan Pérez', 3, 3, 'j@j.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (7, 'Pablo Méndez', 5, 3, 'p@p.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (8, 'Teresa Bermudez', 4, 4, 't@t.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (4, 'Steven Zaldivar', 2, 1, 's@s.com', '1234', 2, true);
INSERT INTO public.usuario VALUES (9, 'Wilson Sánchez', 5, 3, 'w@w.com', '1234', 2, true);
INSERT INTO public.usuario VALUES (10, 'Rebeca Salinas', 5, 3, 'r@r.com', '1234', 2, true);
INSERT INTO public.usuario VALUES (11, 'Carlos Escobar', 5, 3, 'c@c.com', '1234', 2, true);
INSERT INTO public.usuario VALUES (5, 'Andrea Cuellar', 1, 2, 'a@a.com', '1234', 2, true);
INSERT INTO public.usuario VALUES (12, 'Ernesto Menjivar', 1, 2, 'e@e.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (13, 'Ulises Ventura', 1, 2, 'u@u.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (14, 'Brenda Herrera', 2, 2, 'b@b.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (15, 'Omar Guerra', 2, 2, 'o@o.com', '1234', 1, true);
INSERT INTO public.usuario VALUES (16, 'Nelson Torres', 1, 2, 'n@n.com', '1234', 2, true);
INSERT INTO public.usuario VALUES (17, 'Gabriela Umaña', 2, 2, 'g@g.com', '1234', 2, true);


--
-- TOC entry 2164 (class 0 OID 16410)
-- Dependencies: 179
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.estado VALUES (1, 'Creado', 'El ticket ha sido creado', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.estado VALUES (2, 'Asignado', 'El ticket ha sido asignado a uno o mas tecnicos', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.estado VALUES (3, 'En pausa', 'El tecnico encargado ha marcado el ticket como pausado', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.estado VALUES (4, 'Reabierto', 'El usuario solicitante o el tecnico asignado ha reabierto el ticket', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.estado VALUES (5, 'Completado', 'El tecnico ha marcado el ticket como completado', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);


--
-- TOC entry 2166 (class 0 OID 16416)
-- Dependencies: 181
-- Data for Name: prioridad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2176 (class 0 OID 16454)
-- Dependencies: 191
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ticket VALUES (1, 1, 'Prueba de creacion de tickets', '2018-10-31 05:36:02.908+00', NULL, NULL, 5, NULL, NULL, true);
INSERT INTO public.ticket VALUES (7, 1, 'uno mas de la pc jaja jeje', '2018-10-31 06:17:47.383+00', NULL, NULL, 1, NULL, NULL, false);
INSERT INTO public.ticket VALUES (8, 1, 'Aqui solo llenando tickets', '2018-10-31 06:17:55.745+00', NULL, NULL, 1, NULL, NULL, false);
INSERT INTO public.ticket VALUES (10, 1, 'Preparando para ver que pex', '2018-10-31 06:18:06.213+00', NULL, NULL, 1, NULL, NULL, false);
INSERT INTO public.ticket VALUES (2, 1, 'Mire no me funcion ael internet', '2018-10-31 05:01:52.577+00', NULL, NULL, 5, NULL, NULL, true);
INSERT INTO public.ticket VALUES (3, 1, 'No encienden las luces del cpu', '2018-10-31 05:03:18.035+00', NULL, NULL, 5, NULL, NULL, true);
INSERT INTO public.ticket VALUES (4, 1, 'Problema generico de la pc', '2018-10-31 06:17:14.351+00', NULL, NULL, 5, NULL, NULL, false);
INSERT INTO public.ticket VALUES (5, 1, 'Otro problema generico de la pc', '2018-10-31 06:17:24.874+00', NULL, NULL, 5, NULL, NULL, false);
INSERT INTO public.ticket VALUES (6, 1, 'OTRO PROBLEMA GENERICO DE LA PC', '2018-10-31 06:17:33.262+00', NULL, NULL, 5, NULL, NULL, false);
INSERT INTO public.ticket VALUES (9, 6, 'Mi computadora no detecta el monitor. El monitor enciende pero no da imagen.  ', '2018-10-31 06:33:21.537+00', NULL, NULL, 5, NULL, NULL, false);
INSERT INTO public.ticket VALUES (11, 6, 'Mi Monitor no enciende, solo enciende el LED, pero no da imagen.', '2018-10-31 06:37:34.835+00', NULL, NULL, 1, NULL, NULL, false);
INSERT INTO public.ticket VALUES (12, 6, 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?', '2018-10-31 06:38:29.64+00', NULL, NULL, 1, NULL, NULL, false);


--
-- TOC entry 2160 (class 0 OID 16393)
-- Dependencies: 175
-- Data for Name: comentario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 176
-- Name: comentario_id_comentario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comentario_id_comentario_seq', 1, false);


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 178
-- Name: departamento_id_departamento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.departamento_id_departamento_seq', 1, false);


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 180
-- Name: estado_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_id_estado_seq', 6, true);


--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 182
-- Name: prioridad_id_prioridad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prioridad_id_prioridad_seq', 1, false);


--
-- TOC entry 2168 (class 0 OID 16422)
-- Dependencies: 183
-- Data for Name: profesion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profesion VALUES (1, 'Ingeniero en Sistemas', 'Ing sistemas', true);
INSERT INTO public.profesion VALUES (2, 'Electricista', 'Electricista', true);
INSERT INTO public.profesion VALUES (3, 'DBA', 'Database Admin', true);
INSERT INTO public.profesion VALUES (4, 'Plomero', 'Plomero', true);
INSERT INTO public.profesion VALUES (5, 'Operador', 'Operador de Call center', true);


--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 184
-- Name: profesion_id_profesion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profesion_id_profesion_seq', 1, false);


--
-- TOC entry 2170 (class 0 OID 16430)
-- Dependencies: 185
-- Data for Name: retroalimentacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 186
-- Name: retroalimentacion_id_retroalimentacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.retroalimentacion_id_retroalimentacion_seq', 1, false);


--
-- TOC entry 2172 (class 0 OID 16440)
-- Dependencies: 187
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rol VALUES (1, 'Técnico', 'Se le asignarán ticket que deberá realizar', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.rol VALUES (2, 'Administrador', 'Podrá asignar tickets', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.rol VALUES (3, 'Gerente', 'Podrá ver las estadísticas del sistema', 1, '2018-10-10 08:23:54+00', NULL, NULL, true);


--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 188
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_id_rol_seq', 1, false);


--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 190
-- Name: sucursal_id_sucursal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sucursal_id_sucursal_seq', 1, false);


--
-- TOC entry 2177 (class 0 OID 16461)
-- Dependencies: 192
-- Data for Name: ticket_encargado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ticket_encargado VALUES (1, 9, 3, 1, '2018-10-31 06:33:21.452+00', NULL, NULL, false);
INSERT INTO public.ticket_encargado VALUES (2, 9, 12, 1, '2018-10-31 06:33:21.508+00', NULL, NULL, false);


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 193
-- Name: ticket_encargado_id_ticket_encargado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticket_encargado_id_ticket_encargado_seq', 2, true);


--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 194
-- Name: ticket_id_ticket_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticket_id_ticket_seq', 12, true);


--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 196
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, false);


--
-- TOC entry 2182 (class 0 OID 16474)
-- Dependencies: 197
-- Data for Name: usuario_profesion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario_profesion VALUES (1, 1, 1);
INSERT INTO public.usuario_profesion VALUES (2, 2, 2);
INSERT INTO public.usuario_profesion VALUES (3, 3, 3);
INSERT INTO public.usuario_profesion VALUES (4, 4, 1);
INSERT INTO public.usuario_profesion VALUES (5, 5, 1);
INSERT INTO public.usuario_profesion VALUES (6, 6, 5);
INSERT INTO public.usuario_profesion VALUES (7, 7, 5);
INSERT INTO public.usuario_profesion VALUES (8, 8, 5);
INSERT INTO public.usuario_profesion VALUES (9, 9, 5);
INSERT INTO public.usuario_profesion VALUES (10, 10, 5);
INSERT INTO public.usuario_profesion VALUES (11, 11, 5);
INSERT INTO public.usuario_profesion VALUES (12, 12, 1);
INSERT INTO public.usuario_profesion VALUES (13, 13, 3);
INSERT INTO public.usuario_profesion VALUES (14, 14, 2);
INSERT INTO public.usuario_profesion VALUES (15, 15, 4);
INSERT INTO public.usuario_profesion VALUES (16, 16, 1);
INSERT INTO public.usuario_profesion VALUES (17, 17, 4);


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 198
-- Name: usuario_profesion_id_usuario_profesion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_profesion_id_usuario_profesion_seq', 1, false);


--
-- TOC entry 2184 (class 0 OID 16479)
-- Dependencies: 199
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario_rol VALUES (1, 1, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (2, 1, 2, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (3, 1, 3, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (4, 2, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (5, 3, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (6, 4, 2, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (7, 4, 3, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (8, 5, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (9, 12, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (10, 13, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (11, 14, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (12, 15, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (13, 16, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);
INSERT INTO public.usuario_rol VALUES (14, 17, 1, 1, '2018-10-10 08:23:54+00', NULL, NULL, true);


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 200
-- Name: usuario_rol_id_usuario_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_rol_id_usuario_rol_seq', 1, false);


-- Completed on 2018-10-31 13:17:14 CST

--
-- PostgreSQL database dump complete
--

