--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.19
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-10-16 02:07:37 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11858)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 194 (class 1259 OID 16487)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cargo (
    id_cargo integer NOT NULL,
    nombre character varying(200) NOT NULL,
    descripcion character varying(500) NOT NULL,
    activo boolean NOT NULL
);


ALTER TABLE public.cargo OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 16485)
-- Name: cargo_id_cargo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cargo_id_cargo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cargo_id_cargo_seq OWNER TO postgres;

--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 193
-- Name: cargo_id_cargo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cargo_id_cargo_seq OWNED BY public.cargo.id_cargo;


--
-- TOC entry 180 (class 1259 OID 16414)
-- Name: comentario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comentario (
    id_comentario bigint NOT NULL,
    id_ticket bigint NOT NULL,
    id_usuario bigint NOT NULL,
    fecha timestamp with time zone NOT NULL,
    contenido character varying(2000) NOT NULL
);


ALTER TABLE public.comentario OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16412)
-- Name: comentario_id_comentario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comentario_id_comentario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comentario_id_comentario_seq OWNER TO postgres;

--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 179
-- Name: comentario_id_comentario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comentario_id_comentario_seq OWNED BY public.comentario.id_comentario;


--
-- TOC entry 192 (class 1259 OID 16476)
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departamento (
    id_departamento integer NOT NULL,
    nombre character varying(200) NOT NULL,
    descripcion character varying(500) NOT NULL,
    activo boolean NOT NULL
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16474)
-- Name: departamento_id_departamento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departamento_id_departamento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departamento_id_departamento_seq OWNER TO postgres;

--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 191
-- Name: departamento_id_departamento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.departamento_id_departamento_seq OWNED BY public.departamento.id_departamento;


--
-- TOC entry 176 (class 1259 OID 16398)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    id_estado smallint NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(300) NOT NULL
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16396)
-- Name: estado_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_id_estado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_id_estado_seq OWNER TO postgres;

--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 175
-- Name: estado_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_id_estado_seq OWNED BY public.estado.id_estado;


--
-- TOC entry 178 (class 1259 OID 16406)
-- Name: prioridad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prioridad (
    id_prioridad smallint NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(300) NOT NULL
);


ALTER TABLE public.prioridad OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16404)
-- Name: prioridad_id_prioridad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prioridad_id_prioridad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prioridad_id_prioridad_seq OWNER TO postgres;

--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 177
-- Name: prioridad_id_prioridad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prioridad_id_prioridad_seq OWNED BY public.prioridad.id_prioridad;


--
-- TOC entry 196 (class 1259 OID 16498)
-- Name: profesion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesion (
    id_profesion integer NOT NULL,
    nombre character varying(200) NOT NULL,
    descripcion character varying(500) NOT NULL,
    activo boolean NOT NULL
);


ALTER TABLE public.profesion OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 16496)
-- Name: profesion_id_profesion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profesion_id_profesion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesion_id_profesion_seq OWNER TO postgres;

--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 195
-- Name: profesion_id_profesion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profesion_id_profesion_seq OWNED BY public.profesion.id_profesion;


--
-- TOC entry 188 (class 1259 OID 16449)
-- Name: retroalimentacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.retroalimentacion (
    id_retroalimentacion bigint NOT NULL,
    calificacion smallint NOT NULL,
    comentario character varying(2000) DEFAULT NULL::character varying,
    id_ticket bigint NOT NULL
);


ALTER TABLE public.retroalimentacion OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16447)
-- Name: retroalimentacion_id_retroalimentacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.retroalimentacion_id_retroalimentacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.retroalimentacion_id_retroalimentacion_seq OWNER TO postgres;

--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 187
-- Name: retroalimentacion_id_retroalimentacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.retroalimentacion_id_retroalimentacion_seq OWNED BY public.retroalimentacion.id_retroalimentacion;


--
-- TOC entry 184 (class 1259 OID 16433)
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    id_rol smallint NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(300) NOT NULL
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16431)
-- Name: rol_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_id_rol_seq OWNER TO postgres;

--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 183
-- Name: rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rol_id_rol_seq OWNED BY public.rol.id_rol;


--
-- TOC entry 198 (class 1259 OID 16509)
-- Name: sucursal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sucursal (
    id_sucursal smallint NOT NULL,
    nombre character varying(200) NOT NULL,
    direccion character varying(300) NOT NULL
);


ALTER TABLE public.sucursal OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16507)
-- Name: sucursal_id_sucursal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sucursal_id_sucursal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sucursal_id_sucursal_seq OWNER TO postgres;

--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 197
-- Name: sucursal_id_sucursal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sucursal_id_sucursal_seq OWNED BY public.sucursal.id_sucursal;


--
-- TOC entry 174 (class 1259 OID 16387)
-- Name: ticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticket (
    id_ticket bigint NOT NULL,
    id_usuario bigint NOT NULL,
    descripcion character varying(3000) NOT NULL,
    fecha_solicitud timestamp with time zone NOT NULL,
    fecha_completado timestamp with time zone,
    id_prioridad smallint,
    id_estado smallint NOT NULL
);


ALTER TABLE public.ticket OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16425)
-- Name: ticket_encargado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticket_encargado (
    id_ticket_encargado bigint NOT NULL,
    id_ticket bigint NOT NULL,
    id_usuario bigint NOT NULL
);


ALTER TABLE public.ticket_encargado OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16423)
-- Name: ticket_encargado_id_ticket_encargado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ticket_encargado_id_ticket_encargado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ticket_encargado_id_ticket_encargado_seq OWNER TO postgres;

--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 181
-- Name: ticket_encargado_id_ticket_encargado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ticket_encargado_id_ticket_encargado_seq OWNED BY public.ticket_encargado.id_ticket_encargado;


--
-- TOC entry 173 (class 1259 OID 16385)
-- Name: ticket_id_ticket_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ticket_id_ticket_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ticket_id_ticket_seq OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 173
-- Name: ticket_id_ticket_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ticket_id_ticket_seq OWNED BY public.ticket.id_ticket;


--
-- TOC entry 190 (class 1259 OID 16468)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario bigint NOT NULL,
    nombre character varying(100) NOT NULL,
    id_departamento integer NOT NULL,
    id_cargo integer NOT NULL,
    correo character varying(100) NOT NULL,
    contrasena character varying(100) NOT NULL,
    id_sucursal smallint NOT NULL,
    activo boolean NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16466)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 189
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 200 (class 1259 OID 16520)
-- Name: usuario_profesion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_profesion (
    id_usuario_profesion bigint NOT NULL,
    id_usuario bigint NOT NULL,
    id_profesion integer NOT NULL
);


ALTER TABLE public.usuario_profesion OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16518)
-- Name: usuario_profesion_id_usuario_profesion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_profesion_id_usuario_profesion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_profesion_id_usuario_profesion_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 199
-- Name: usuario_profesion_id_usuario_profesion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_profesion_id_usuario_profesion_seq OWNED BY public.usuario_profesion.id_usuario_profesion;


--
-- TOC entry 186 (class 1259 OID 16441)
-- Name: usuario_rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_rol (
    id_usuario_rol integer NOT NULL,
    id_usuario bigint NOT NULL,
    id_rol smallint NOT NULL
);


ALTER TABLE public.usuario_rol OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16439)
-- Name: usuario_rol_id_usuario_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_rol_id_usuario_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_rol_id_usuario_rol_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_rol_id_usuario_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_rol_id_usuario_rol_seq OWNED BY public.usuario_rol.id_usuario_rol;


--
-- TOC entry 1978 (class 2604 OID 16490)
-- Name: id_cargo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo ALTER COLUMN id_cargo SET DEFAULT nextval('public.cargo_id_cargo_seq'::regclass);


--
-- TOC entry 1970 (class 2604 OID 16417)
-- Name: id_comentario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario ALTER COLUMN id_comentario SET DEFAULT nextval('public.comentario_id_comentario_seq'::regclass);


--
-- TOC entry 1977 (class 2604 OID 16479)
-- Name: id_departamento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento ALTER COLUMN id_departamento SET DEFAULT nextval('public.departamento_id_departamento_seq'::regclass);


--
-- TOC entry 1968 (class 2604 OID 16401)
-- Name: id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_id_estado_seq'::regclass);


--
-- TOC entry 1969 (class 2604 OID 16409)
-- Name: id_prioridad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prioridad ALTER COLUMN id_prioridad SET DEFAULT nextval('public.prioridad_id_prioridad_seq'::regclass);


--
-- TOC entry 1979 (class 2604 OID 16501)
-- Name: id_profesion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion ALTER COLUMN id_profesion SET DEFAULT nextval('public.profesion_id_profesion_seq'::regclass);


--
-- TOC entry 1974 (class 2604 OID 16452)
-- Name: id_retroalimentacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.retroalimentacion ALTER COLUMN id_retroalimentacion SET DEFAULT nextval('public.retroalimentacion_id_retroalimentacion_seq'::regclass);


--
-- TOC entry 1972 (class 2604 OID 16436)
-- Name: id_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN id_rol SET DEFAULT nextval('public.rol_id_rol_seq'::regclass);


--
-- TOC entry 1980 (class 2604 OID 16512)
-- Name: id_sucursal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal ALTER COLUMN id_sucursal SET DEFAULT nextval('public.sucursal_id_sucursal_seq'::regclass);


--
-- TOC entry 1967 (class 2604 OID 16390)
-- Name: id_ticket; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket ALTER COLUMN id_ticket SET DEFAULT nextval('public.ticket_id_ticket_seq'::regclass);


--
-- TOC entry 1971 (class 2604 OID 16428)
-- Name: id_ticket_encargado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_encargado ALTER COLUMN id_ticket_encargado SET DEFAULT nextval('public.ticket_encargado_id_ticket_encargado_seq'::regclass);


--
-- TOC entry 1976 (class 2604 OID 16471)
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 1981 (class 2604 OID 16523)
-- Name: id_usuario_profesion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_profesion ALTER COLUMN id_usuario_profesion SET DEFAULT nextval('public.usuario_profesion_id_usuario_profesion_seq'::regclass);


--
-- TOC entry 1973 (class 2604 OID 16444)
-- Name: id_usuario_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol ALTER COLUMN id_usuario_rol SET DEFAULT nextval('public.usuario_rol_id_usuario_rol_seq'::regclass);


--
-- TOC entry 2005 (class 2606 OID 16495)
-- Name: id_cargo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT id_cargo PRIMARY KEY (id_cargo);


--
-- TOC entry 1989 (class 2606 OID 16422)
-- Name: id_comentario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT id_comentario PRIMARY KEY (id_comentario);


--
-- TOC entry 2003 (class 2606 OID 16484)
-- Name: id_departamento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT id_departamento PRIMARY KEY (id_departamento);


--
-- TOC entry 1985 (class 2606 OID 16403)
-- Name: id_estado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT id_estado PRIMARY KEY (id_estado);


--
-- TOC entry 1987 (class 2606 OID 16411)
-- Name: id_prioridad; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prioridad
    ADD CONSTRAINT id_prioridad PRIMARY KEY (id_prioridad);


--
-- TOC entry 2007 (class 2606 OID 16506)
-- Name: id_profesion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesion
    ADD CONSTRAINT id_profesion PRIMARY KEY (id_profesion);


--
-- TOC entry 1997 (class 2606 OID 16458)
-- Name: id_retroalimentacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.retroalimentacion
    ADD CONSTRAINT id_retroalimentacion PRIMARY KEY (id_retroalimentacion);


--
-- TOC entry 1993 (class 2606 OID 16438)
-- Name: id_rol; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT id_rol PRIMARY KEY (id_rol);


--
-- TOC entry 2009 (class 2606 OID 16517)
-- Name: id_sucursal; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT id_sucursal PRIMARY KEY (id_sucursal);


--
-- TOC entry 1983 (class 2606 OID 16395)
-- Name: id_ticket; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT id_ticket PRIMARY KEY (id_ticket);


--
-- TOC entry 1991 (class 2606 OID 16430)
-- Name: id_ticket_encargado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_encargado
    ADD CONSTRAINT id_ticket_encargado PRIMARY KEY (id_ticket_encargado);


--
-- TOC entry 2001 (class 2606 OID 16473)
-- Name: id_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_usuario PRIMARY KEY (id_usuario);


--
-- TOC entry 2011 (class 2606 OID 16525)
-- Name: id_usuario_profesion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_profesion
    ADD CONSTRAINT id_usuario_profesion PRIMARY KEY (id_usuario_profesion);


--
-- TOC entry 1995 (class 2606 OID 16446)
-- Name: id_usuario_rol; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT id_usuario_rol PRIMARY KEY (id_usuario_rol);


--
-- TOC entry 1999 (class 2606 OID 16465)
-- Name: retroalimentacion_uq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.retroalimentacion
    ADD CONSTRAINT retroalimentacion_uq UNIQUE (id_ticket);


--
-- TOC entry 2022 (class 2606 OID 16571)
-- Name: id_cargo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_cargo FOREIGN KEY (id_cargo) REFERENCES public.cargo(id_cargo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2024 (class 2606 OID 16581)
-- Name: id_departamento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_departamento FOREIGN KEY (id_departamento) REFERENCES public.departamento(id_departamento) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2012 (class 2606 OID 16526)
-- Name: id_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2013 (class 2606 OID 16531)
-- Name: id_prioridad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT id_prioridad FOREIGN KEY (id_prioridad) REFERENCES public.prioridad(id_prioridad) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2026 (class 2606 OID 16591)
-- Name: id_profesion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_profesion
    ADD CONSTRAINT id_profesion FOREIGN KEY (id_profesion) REFERENCES public.profesion(id_profesion) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2019 (class 2606 OID 16561)
-- Name: id_rol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2023 (class 2606 OID 16576)
-- Name: id_sucursal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_sucursal FOREIGN KEY (id_sucursal) REFERENCES public.sucursal(id_sucursal) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2015 (class 2606 OID 16541)
-- Name: id_ticket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT id_ticket FOREIGN KEY (id_ticket) REFERENCES public.ticket(id_ticket) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2017 (class 2606 OID 16551)
-- Name: id_ticket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_encargado
    ADD CONSTRAINT id_ticket FOREIGN KEY (id_ticket) REFERENCES public.ticket(id_ticket) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2014 (class 2606 OID 16536)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2016 (class 2606 OID 16546)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2018 (class 2606 OID 16556)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_encargado
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2020 (class 2606 OID 16566)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2025 (class 2606 OID 16586)
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_profesion
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2021 (class 2606 OID 16459)
-- Name: ticket_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.retroalimentacion
    ADD CONSTRAINT ticket_fk FOREIGN KEY (id_ticket) REFERENCES public.ticket(id_ticket) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-10-16 02:07:37 CST

--
-- PostgreSQL database dump complete
--

