-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: new_database | type: DATABASE --
-- -- DROP DATABASE IF EXISTS new_database;
-- CREATE DATABASE new_database
-- ;
-- -- ddl-end --
-- 

-- object: public.ticket | type: TABLE --
-- DROP TABLE IF EXISTS public.ticket CASCADE;
CREATE TABLE public.ticket(
	id_ticket bigserial NOT NULL,
	id_usuario bigint NOT NULL,
	descripcion varchar(3000) NOT NULL,
	fecha_solicitud timestamp with time zone NOT NULL,
	fecha_completado timestamp with time zone,
	id_prioridad smallint,
	id_estado smallint NOT NULL,
	CONSTRAINT id_ticket PRIMARY KEY (id_ticket)

);
-- ddl-end --
ALTER TABLE public.ticket OWNER TO postgres;
-- ddl-end --

-- object: public.estado | type: TABLE --
-- DROP TABLE IF EXISTS public.estado CASCADE;
CREATE TABLE public.estado(
	id_estado smallserial NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(300) NOT NULL,
	CONSTRAINT id_estado PRIMARY KEY (id_estado)

);
-- ddl-end --
ALTER TABLE public.estado OWNER TO postgres;
-- ddl-end --

-- object: public.prioridad | type: TABLE --
-- DROP TABLE IF EXISTS public.prioridad CASCADE;
CREATE TABLE public.prioridad(
	id_prioridad smallserial NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(300) NOT NULL,
	CONSTRAINT id_prioridad PRIMARY KEY (id_prioridad)

);
-- ddl-end --
ALTER TABLE public.prioridad OWNER TO postgres;
-- ddl-end --

-- object: public.comentario | type: TABLE --
-- DROP TABLE IF EXISTS public.comentario CASCADE;
CREATE TABLE public.comentario(
	id_comentario bigserial NOT NULL,
	id_ticket bigint NOT NULL,
	id_usuario bigint NOT NULL,
	fecha timestamp with time zone NOT NULL,
	contenido varchar(2000) NOT NULL,
	CONSTRAINT id_comentario PRIMARY KEY (id_comentario)

);
-- ddl-end --
ALTER TABLE public.comentario OWNER TO postgres;
-- ddl-end --

-- object: public.ticket_encargado | type: TABLE --
-- DROP TABLE IF EXISTS public.ticket_encargado CASCADE;
CREATE TABLE public.ticket_encargado(
	id_ticket_encargado bigserial NOT NULL,
	id_ticket bigint NOT NULL,
	id_usuario bigint NOT NULL,
	CONSTRAINT id_ticket_encargado PRIMARY KEY (id_ticket_encargado)

);
-- ddl-end --
ALTER TABLE public.ticket_encargado OWNER TO postgres;
-- ddl-end --

-- object: public.rol | type: TABLE --
-- DROP TABLE IF EXISTS public.rol CASCADE;
CREATE TABLE public.rol(
	id_rol smallserial NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(300) NOT NULL,
	CONSTRAINT id_rol PRIMARY KEY (id_rol)

);
-- ddl-end --
ALTER TABLE public.rol OWNER TO postgres;
-- ddl-end --

-- object: public.usuario_rol | type: TABLE --
-- DROP TABLE IF EXISTS public.usuario_rol CASCADE;
CREATE TABLE public.usuario_rol(
	id_usuario_rol serial NOT NULL,
	id_usuario bigint NOT NULL,
	id_rol smallint NOT NULL,
	CONSTRAINT id_usuario_rol PRIMARY KEY (id_usuario_rol)

);
-- ddl-end --
ALTER TABLE public.usuario_rol OWNER TO postgres;
-- ddl-end --

-- object: public.retroalimentacion | type: TABLE --
-- DROP TABLE IF EXISTS public.retroalimentacion CASCADE;
CREATE TABLE public.retroalimentacion(
	id_retroalimentacion bigserial NOT NULL,
	calificacion smallint NOT NULL,
	comentario varchar(2000) DEFAULT NULL,
	id_ticket bigint NOT NULL,
	CONSTRAINT id_retroalimentacion PRIMARY KEY (id_retroalimentacion)

);
-- ddl-end --
ALTER TABLE public.retroalimentacion OWNER TO postgres;
-- ddl-end --

-- object: ticket_fk | type: CONSTRAINT --
-- ALTER TABLE public.retroalimentacion DROP CONSTRAINT IF EXISTS ticket_fk CASCADE;
ALTER TABLE public.retroalimentacion ADD CONSTRAINT ticket_fk FOREIGN KEY (id_ticket)
REFERENCES public.ticket (id_ticket) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: retroalimentacion_uq | type: CONSTRAINT --
-- ALTER TABLE public.retroalimentacion DROP CONSTRAINT IF EXISTS retroalimentacion_uq CASCADE;
ALTER TABLE public.retroalimentacion ADD CONSTRAINT retroalimentacion_uq UNIQUE (id_ticket);
-- ddl-end --

-- object: public.usuario | type: TABLE --
-- DROP TABLE IF EXISTS public.usuario CASCADE;
CREATE TABLE public.usuario(
	id_usuario bigserial NOT NULL,
	nombre varchar(100) NOT NULL,
	id_departamento integer NOT NULL,
	id_cargo integer NOT NULL,
	id_profesion integer NOT NULL,
	correo varchar(100) NOT NULL,
	contrasena varchar(100) NOT NULL,
	id_sucursal smallint NOT NULL,
	activo boolean NOT NULL,
	CONSTRAINT id_usuario PRIMARY KEY (id_usuario)

);
-- ddl-end --
ALTER TABLE public.usuario OWNER TO postgres;
-- ddl-end --

-- object: public.departamento | type: TABLE --
-- DROP TABLE IF EXISTS public.departamento CASCADE;
CREATE TABLE public.departamento(
	id_departamento serial NOT NULL,
	nombre varchar(200) NOT NULL,
	descripcion varchar(500) NOT NULL,
	activo boolean NOT NULL,
	CONSTRAINT id_departamento PRIMARY KEY (id_departamento)

);
-- ddl-end --
ALTER TABLE public.departamento OWNER TO postgres;
-- ddl-end --

-- object: public.cargo | type: TABLE --
-- DROP TABLE IF EXISTS public.cargo CASCADE;
CREATE TABLE public.cargo(
	id_cargo serial NOT NULL,
	nombre varchar(200) NOT NULL,
	descripcion varchar(500) NOT NULL,
	activo boolean NOT NULL,
	CONSTRAINT id_cargo PRIMARY KEY (id_cargo)

);
-- ddl-end --
ALTER TABLE public.cargo OWNER TO postgres;
-- ddl-end --

-- object: public.profesion | type: TABLE --
-- DROP TABLE IF EXISTS public.profesion CASCADE;
CREATE TABLE public.profesion(
	id_profesion serial NOT NULL,
	nombre varchar(200) NOT NULL,
	descripcion varchar(500) NOT NULL,
	activo boolean NOT NULL,
	CONSTRAINT id_profesion PRIMARY KEY (id_profesion)

);
-- ddl-end --
ALTER TABLE public.profesion OWNER TO postgres;
-- ddl-end --

-- object: public.sucursal | type: TABLE --
-- DROP TABLE IF EXISTS public.sucursal CASCADE;
CREATE TABLE public.sucursal(
	id_sucursal smallserial NOT NULL,
	nombre varchar(200) NOT NULL,
	direccion varchar(300) NOT NULL,
	CONSTRAINT id_sucursal PRIMARY KEY (id_sucursal)

);
-- ddl-end --
ALTER TABLE public.sucursal OWNER TO postgres;
-- ddl-end --

-- object: public.usuario_profesion | type: TABLE --
-- DROP TABLE IF EXISTS public.usuario_profesion CASCADE;
CREATE TABLE public.usuario_profesion(
	id_usuario_profesion bigserial NOT NULL,
	id_usuario bigint NOT NULL,
	id_profesion integer NOT NULL,
	CONSTRAINT id_usuario_profesion PRIMARY KEY (id_usuario_profesion)

);
-- ddl-end --
ALTER TABLE public.usuario_profesion OWNER TO postgres;
-- ddl-end --

-- object: id_estado | type: CONSTRAINT --
-- ALTER TABLE public.ticket DROP CONSTRAINT IF EXISTS id_estado CASCADE;
ALTER TABLE public.ticket ADD CONSTRAINT id_estado FOREIGN KEY (id_estado)
REFERENCES public.estado (id_estado) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_prioridad | type: CONSTRAINT --
-- ALTER TABLE public.ticket DROP CONSTRAINT IF EXISTS id_prioridad CASCADE;
ALTER TABLE public.ticket ADD CONSTRAINT id_prioridad FOREIGN KEY (id_prioridad)
REFERENCES public.prioridad (id_prioridad) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_usuario | type: CONSTRAINT --
-- ALTER TABLE public.ticket DROP CONSTRAINT IF EXISTS id_usuario CASCADE;
ALTER TABLE public.ticket ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_ticket | type: CONSTRAINT --
-- ALTER TABLE public.comentario DROP CONSTRAINT IF EXISTS id_ticket CASCADE;
ALTER TABLE public.comentario ADD CONSTRAINT id_ticket FOREIGN KEY (id_ticket)
REFERENCES public.ticket (id_ticket) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_usuario | type: CONSTRAINT --
-- ALTER TABLE public.comentario DROP CONSTRAINT IF EXISTS id_usuario CASCADE;
ALTER TABLE public.comentario ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_ticket | type: CONSTRAINT --
-- ALTER TABLE public.ticket_encargado DROP CONSTRAINT IF EXISTS id_ticket CASCADE;
ALTER TABLE public.ticket_encargado ADD CONSTRAINT id_ticket FOREIGN KEY (id_ticket)
REFERENCES public.ticket (id_ticket) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_usuario | type: CONSTRAINT --
-- ALTER TABLE public.ticket_encargado DROP CONSTRAINT IF EXISTS id_usuario CASCADE;
ALTER TABLE public.ticket_encargado ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_rol | type: CONSTRAINT --
-- ALTER TABLE public.usuario_rol DROP CONSTRAINT IF EXISTS id_rol CASCADE;
ALTER TABLE public.usuario_rol ADD CONSTRAINT id_rol FOREIGN KEY (id_rol)
REFERENCES public.rol (id_rol) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_usuario | type: CONSTRAINT --
-- ALTER TABLE public.usuario_rol DROP CONSTRAINT IF EXISTS id_usuario CASCADE;
ALTER TABLE public.usuario_rol ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_cargo | type: CONSTRAINT --
-- ALTER TABLE public.usuario DROP CONSTRAINT IF EXISTS id_cargo CASCADE;
ALTER TABLE public.usuario ADD CONSTRAINT id_cargo FOREIGN KEY (id_cargo)
REFERENCES public.cargo (id_cargo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_sucursal | type: CONSTRAINT --
-- ALTER TABLE public.usuario DROP CONSTRAINT IF EXISTS id_sucursal CASCADE;
ALTER TABLE public.usuario ADD CONSTRAINT id_sucursal FOREIGN KEY (id_sucursal)
REFERENCES public.sucursal (id_sucursal) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_departamento | type: CONSTRAINT --
-- ALTER TABLE public.usuario DROP CONSTRAINT IF EXISTS id_departamento CASCADE;
ALTER TABLE public.usuario ADD CONSTRAINT id_departamento FOREIGN KEY (id_departamento)
REFERENCES public.departamento (id_departamento) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_usuario | type: CONSTRAINT --
-- ALTER TABLE public.usuario_profesion DROP CONSTRAINT IF EXISTS id_usuario CASCADE;
ALTER TABLE public.usuario_profesion ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_profesion | type: CONSTRAINT --
-- ALTER TABLE public.usuario_profesion DROP CONSTRAINT IF EXISTS id_profesion CASCADE;
ALTER TABLE public.usuario_profesion ADD CONSTRAINT id_profesion FOREIGN KEY (id_profesion)
REFERENCES public.profesion (id_profesion) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --


