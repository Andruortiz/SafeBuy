--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-05-28 01:07:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 27185)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 5065 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS '';


--
-- TOC entry 2 (class 3079 OID 27186)
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- TOC entry 5067 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 27223)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id uuid NOT NULL,
    categoria character varying(100),
    nombre character varying(255),
    detalle_categoria_id uuid
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 27226)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ciudad (
    id uuid NOT NULL,
    nombre character varying(255),
    departamento character varying(100),
    paisid uuid,
    pais_id character varying(255) NOT NULL
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 27231)
-- Name: compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compra (
    id uuid NOT NULL,
    compradorid uuid,
    montototal numeric(10,2),
    comprador_id uuid NOT NULL,
    precio_total_id uuid NOT NULL
);


ALTER TABLE public.compra OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 27234)
-- Name: comprador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comprador (
    id uuid NOT NULL,
    nombre character varying(100),
    dni character(15),
    dnivalidado character varying(10),
    correo_electronico character varying(100),
    correo_confirmado character varying(10),
    telefono character(15),
    telefono_confirmado character varying(10),
    verificacion character varying(10)
);


ALTER TABLE public.comprador OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 27237)
-- Name: delivery; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.delivery (
    id uuid NOT NULL,
    dni character(15),
    dnivalidado character varying(10),
    verificacion_recepcion character varying(10),
    verificacion_entrega character varying(10),
    fecha_envio date
);


ALTER TABLE public.delivery OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 27265)
-- Name: detallecompra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detallecompra (
    id uuid NOT NULL,
    compraid uuid,
    productoid uuid,
    cantidad integer,
    preciounitario numeric(10,2),
    productoscomprados text,
    fechacompra date,
    fechaentrega date
);


ALTER TABLE public.detallecompra OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 27270)
-- Name: detalledelivery; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalledelivery (
    id uuid NOT NULL,
    compra_id uuid,
    delivery_id uuid,
    estado character varying(20),
    fecha_recepcion text,
    fecha_entrega text
);


ALTER TABLE public.detalledelivery OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 27275)
-- Name: detalleentrega; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalleentrega (
    id uuid NOT NULL,
    compradorid uuid,
    ciudadid uuid,
    codigopostal character varying(15),
    direccionentregaid uuid
);


ALTER TABLE public.detalleentrega OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 27278)
-- Name: detallefactura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detallefactura (
    id uuid NOT NULL,
    facturaid uuid,
    productoid uuid,
    descripcion text,
    cantidad integer,
    preciounitario numeric(10,2),
    subtotal text
);


ALTER TABLE public.detallefactura OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 27283)
-- Name: detalleprecio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalleprecio (
    id uuid NOT NULL,
    precioid uuid,
    tipodetalle character varying(50),
    descripcion text,
    valortotal numeric(10,2)
);


ALTER TABLE public.detalleprecio OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 27293)
-- Name: direccionentrega; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direccionentrega (
    id uuid NOT NULL,
    compradorid uuid,
    codigopostal character varying(15),
    calle character varying(150),
    informacionadicional text
);


ALTER TABLE public.direccionentrega OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 27298)
-- Name: estado_reclamo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado_reclamo (
    id uuid NOT NULL,
    estado character varying(255),
    nombre character varying(255)
);


ALTER TABLE public.estado_reclamo OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 27303)
-- Name: estadoreclamo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estadoreclamo (
    id uuid NOT NULL,
    descripcionestado character varying(100),
    estado character varying(20),
    reclamo_id uuid
);


ALTER TABLE public.estadoreclamo OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 27306)
-- Name: factura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura (
    id uuid NOT NULL,
    compraid uuid,
    montototalfac numeric(10,2),
    moneda character(5),
    estado character varying(20),
    montototal numeric(10,2),
    descripcion character varying(255),
    compra_id uuid NOT NULL
);


ALTER TABLE public.factura OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 27312)
-- Name: historialreclamo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.historialreclamo (
    id uuid NOT NULL,
    reclamo_id uuid,
    fechacambio date,
    estadoanterior character varying(30),
    estadonuevo character varying(30),
    fechainicio date,
    fechafin date
);


ALTER TABLE public.historialreclamo OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 27318)
-- Name: inforeclamomotivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inforeclamomotivo (
    id uuid NOT NULL,
    motivoid uuid,
    reclamoid uuid,
    esreembolsable character varying(10),
    estado character varying(20)
);


ALTER TABLE public.inforeclamomotivo OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 27324)
-- Name: metodopago; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.metodopago (
    id uuid NOT NULL,
    compradorid uuid,
    tipometodopago character varying(30),
    numeromedio character varying(25),
    entidad character varying(50),
    moneda character(5)
);


ALTER TABLE public.metodopago OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 27327)
-- Name: moneda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.moneda (
    id uuid NOT NULL,
    codigomoneda character(5),
    pais uuid,
    codigo character varying(255),
    nombre character varying(255)
);


ALTER TABLE public.moneda OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 27332)
-- Name: motivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.motivo (
    id uuid NOT NULL,
    descripcion_dada_por_comprador text,
    categoriamotivo character varying(100),
    activo boolean NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public.motivo OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 27337)
-- Name: pago; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pago (
    id uuid NOT NULL,
    monto text,
    metodopago_id uuid,
    estadopago character varying(30),
    vendedor uuid,
    comprador uuid,
    estado character varying(255) NOT NULL,
    compra_id uuid NOT NULL,
    moneda_id uuid NOT NULL
);


ALTER TABLE public.pago OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 27342)
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pais (
    id uuid NOT NULL,
    nombrepais character varying(100),
    codigopais character(3),
    activotransaccion character varying(50),
    activo_transaccion character varying(255) NOT NULL,
    codigoiso character varying(255) NOT NULL,
    nombre_pais character varying(255) NOT NULL,
    moneda_id uuid
);


ALTER TABLE public.pais OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 27347)
-- Name: precio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.precio (
    id uuid NOT NULL,
    codigomoneda character(5),
    idproducto uuid,
    montobase numeric(10,2),
    moneda character(5),
    valor numeric(38,2),
    moneda_id uuid NOT NULL
);


ALTER TABLE public.precio OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 27350)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    id uuid NOT NULL,
    descripcion character varying(255),
    nombre character varying(255),
    categoria_id uuid,
    precio_id uuid NOT NULL,
    vendedor_id uuid
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 27355)
-- Name: reclamo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reclamo (
    id uuid NOT NULL,
    inforeclamomotivoid uuid,
    compra_id uuid,
    rol character varying(20),
    descripcion_dada_por_comprador text,
    evidencias text,
    id_reclamante uuid,
    estado character varying(255),
    motivo character varying(255),
    respuesta character varying(255),
    vendedor_id uuid NOT NULL
);


ALTER TABLE public.reclamo OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 27360)
-- Name: vendedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendedor (
    id uuid NOT NULL,
    nombre character varying(100),
    dni character(15),
    dnivalidado character varying(10),
    correo_electronico character varying(100),
    correo_confirmado character varying(10),
    telefono character(15),
    telefonoverificado text,
    verificacion character varying(10),
    detalle_id uuid
);


ALTER TABLE public.vendedor OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 27368)
-- Name: vendedorproducto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendedorproducto (
    id uuid NOT NULL,
    idvendedor uuid,
    idproducto uuid
);


ALTER TABLE public.vendedorproducto OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 27371)
-- Name: verificador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.verificador (
    id uuid NOT NULL,
    keydeliveryrecepcion character varying(100),
    keydeliveryentrega character varying(100),
    key_del_vendedor character varying(100),
    key_del_comprador character varying(100),
    idpago uuid,
    aprobacion character varying(10),
    combinacion_unica character varying(255) NOT NULL,
    estado character varying(255) NOT NULL,
    key_comprador character varying(255) NOT NULL,
    key_delivery_entrega character varying(255) NOT NULL,
    key_delivery_recepcion character varying(255) NOT NULL,
    key_vendedor character varying(255) NOT NULL,
    pago_id uuid NOT NULL
);


ALTER TABLE public.verificador OWNER TO postgres;

--
-- TOC entry 5033 (class 0 OID 27223)
-- Dependencies: 218
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id, categoria, nombre, detalle_categoria_id) FROM stdin;
\.


--
-- TOC entry 5034 (class 0 OID 27226)
-- Dependencies: 219
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ciudad (id, nombre, departamento, paisid, pais_id) FROM stdin;
\.


--
-- TOC entry 5035 (class 0 OID 27231)
-- Dependencies: 220
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.compra (id, compradorid, montototal, comprador_id, precio_total_id) FROM stdin;
\.


--
-- TOC entry 5036 (class 0 OID 27234)
-- Dependencies: 221
-- Data for Name: comprador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comprador (id, nombre, dni, dnivalidado, correo_electronico, correo_confirmado, telefono, telefono_confirmado, verificacion) FROM stdin;
\.


--
-- TOC entry 5037 (class 0 OID 27237)
-- Dependencies: 222
-- Data for Name: delivery; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.delivery (id, dni, dnivalidado, verificacion_recepcion, verificacion_entrega, fecha_envio) FROM stdin;
\.


--
-- TOC entry 5038 (class 0 OID 27265)
-- Dependencies: 223
-- Data for Name: detallecompra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detallecompra (id, compraid, productoid, cantidad, preciounitario, productoscomprados, fechacompra, fechaentrega) FROM stdin;
\.


--
-- TOC entry 5039 (class 0 OID 27270)
-- Dependencies: 224
-- Data for Name: detalledelivery; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalledelivery (id, compra_id, delivery_id, estado, fecha_recepcion, fecha_entrega) FROM stdin;
\.


--
-- TOC entry 5040 (class 0 OID 27275)
-- Dependencies: 225
-- Data for Name: detalleentrega; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalleentrega (id, compradorid, ciudadid, codigopostal, direccionentregaid) FROM stdin;
\.


--
-- TOC entry 5041 (class 0 OID 27278)
-- Dependencies: 226
-- Data for Name: detallefactura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detallefactura (id, facturaid, productoid, descripcion, cantidad, preciounitario, subtotal) FROM stdin;
\.


--
-- TOC entry 5042 (class 0 OID 27283)
-- Dependencies: 227
-- Data for Name: detalleprecio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalleprecio (id, precioid, tipodetalle, descripcion, valortotal) FROM stdin;
\.


--
-- TOC entry 5043 (class 0 OID 27293)
-- Dependencies: 228
-- Data for Name: direccionentrega; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.direccionentrega (id, compradorid, codigopostal, calle, informacionadicional) FROM stdin;
\.


--
-- TOC entry 5044 (class 0 OID 27298)
-- Dependencies: 229
-- Data for Name: estado_reclamo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado_reclamo (id, estado, nombre) FROM stdin;
\.


--
-- TOC entry 5045 (class 0 OID 27303)
-- Dependencies: 230
-- Data for Name: estadoreclamo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estadoreclamo (id, descripcionestado, estado, reclamo_id) FROM stdin;
\.


--
-- TOC entry 5046 (class 0 OID 27306)
-- Dependencies: 231
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.factura (id, compraid, montototalfac, moneda, estado, montototal, descripcion, compra_id) FROM stdin;
\.


--
-- TOC entry 5047 (class 0 OID 27312)
-- Dependencies: 232
-- Data for Name: historialreclamo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.historialreclamo (id, reclamo_id, fechacambio, estadoanterior, estadonuevo, fechainicio, fechafin) FROM stdin;
\.


--
-- TOC entry 5048 (class 0 OID 27318)
-- Dependencies: 233
-- Data for Name: inforeclamomotivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inforeclamomotivo (id, motivoid, reclamoid, esreembolsable, estado) FROM stdin;
\.


--
-- TOC entry 5049 (class 0 OID 27324)
-- Dependencies: 234
-- Data for Name: metodopago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.metodopago (id, compradorid, tipometodopago, numeromedio, entidad, moneda) FROM stdin;
\.


--
-- TOC entry 5050 (class 0 OID 27327)
-- Dependencies: 235
-- Data for Name: moneda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.moneda (id, codigomoneda, pais, codigo, nombre) FROM stdin;
\.


--
-- TOC entry 5051 (class 0 OID 27332)
-- Dependencies: 236
-- Data for Name: motivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.motivo (id, descripcion_dada_por_comprador, categoriamotivo, activo, nombre) FROM stdin;
\.


--
-- TOC entry 5052 (class 0 OID 27337)
-- Dependencies: 237
-- Data for Name: pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pago (id, monto, metodopago_id, estadopago, vendedor, comprador, estado, compra_id, moneda_id) FROM stdin;
\.


--
-- TOC entry 5053 (class 0 OID 27342)
-- Dependencies: 238
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pais (id, nombrepais, codigopais, activotransaccion, activo_transaccion, codigoiso, nombre_pais, moneda_id) FROM stdin;
\.


--
-- TOC entry 5054 (class 0 OID 27347)
-- Dependencies: 239
-- Data for Name: precio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.precio (id, codigomoneda, idproducto, montobase, moneda, valor, moneda_id) FROM stdin;
\.


--
-- TOC entry 5055 (class 0 OID 27350)
-- Dependencies: 240
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id, descripcion, nombre, categoria_id, precio_id, vendedor_id) FROM stdin;
\.


--
-- TOC entry 5056 (class 0 OID 27355)
-- Dependencies: 241
-- Data for Name: reclamo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reclamo (id, inforeclamomotivoid, compra_id, rol, descripcion_dada_por_comprador, evidencias, id_reclamante, estado, motivo, respuesta, vendedor_id) FROM stdin;
\.


--
-- TOC entry 5057 (class 0 OID 27360)
-- Dependencies: 242
-- Data for Name: vendedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendedor (id, nombre, dni, dnivalidado, correo_electronico, correo_confirmado, telefono, telefonoverificado, verificacion, detalle_id) FROM stdin;
\.


--
-- TOC entry 5058 (class 0 OID 27368)
-- Dependencies: 243
-- Data for Name: vendedorproducto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendedorproducto (id, idvendedor, idproducto) FROM stdin;
\.


--
-- TOC entry 5059 (class 0 OID 27371)
-- Dependencies: 244
-- Data for Name: verificador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.verificador (id, keydeliveryrecepcion, keydeliveryentrega, key_del_vendedor, key_del_comprador, idpago, aprobacion, combinacion_unica, estado, key_comprador, key_delivery_entrega, key_delivery_recepcion, key_vendedor, pago_id) FROM stdin;
\.


--
-- TOC entry 4836 (class 2606 OID 27415)
-- Name: ciudad ciudad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (id);


--
-- TOC entry 4838 (class 2606 OID 27411)
-- Name: compra compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_pkey PRIMARY KEY (id);


--
-- TOC entry 4840 (class 2606 OID 27419)
-- Name: comprador comprador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comprador
    ADD CONSTRAINT comprador_pkey PRIMARY KEY (id);


--
-- TOC entry 4842 (class 2606 OID 27417)
-- Name: delivery delivery_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery
    ADD CONSTRAINT delivery_pkey PRIMARY KEY (id);


--
-- TOC entry 4844 (class 2606 OID 27413)
-- Name: direccionentrega direccionentrega_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccionentrega
    ADD CONSTRAINT direccionentrega_pkey PRIMARY KEY (id);


--
-- TOC entry 4846 (class 2606 OID 27407)
-- Name: factura factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id);


--
-- TOC entry 4848 (class 2606 OID 27421)
-- Name: metodopago metodopago_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.metodopago
    ADD CONSTRAINT metodopago_pkey PRIMARY KEY (id);


--
-- TOC entry 4850 (class 2606 OID 27401)
-- Name: motivo motivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.motivo
    ADD CONSTRAINT motivo_pkey PRIMARY KEY (id);


--
-- TOC entry 4852 (class 2606 OID 27380)
-- Name: pais pais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (id);


--
-- TOC entry 4856 (class 2606 OID 27423)
-- Name: precio precio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precio
    ADD CONSTRAINT precio_pkey PRIMARY KEY (id);


--
-- TOC entry 4858 (class 2606 OID 27409)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);


--
-- TOC entry 4860 (class 2606 OID 27403)
-- Name: reclamo reclamo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reclamo
    ADD CONSTRAINT reclamo_pkey PRIMARY KEY (id);


--
-- TOC entry 4854 (class 2606 OID 27378)
-- Name: pais unique_moneda_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT unique_moneda_id UNIQUE (moneda_id);


--
-- TOC entry 4862 (class 2606 OID 27405)
-- Name: vendedor vendedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedor
    ADD CONSTRAINT vendedor_pkey PRIMARY KEY (id);


--
-- TOC entry 4863 (class 2606 OID 27424)
-- Name: ciudad fk_ciudad_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT fk_ciudad_pais FOREIGN KEY (paisid) REFERENCES public.pais(id);


--
-- TOC entry 4864 (class 2606 OID 27429)
-- Name: compra fk_compra_comprador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT fk_compra_comprador FOREIGN KEY (compradorid) REFERENCES public.comprador(id);


--
-- TOC entry 4865 (class 2606 OID 27434)
-- Name: detallecompra fk_detallecompra_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallecompra
    ADD CONSTRAINT fk_detallecompra_compra FOREIGN KEY (compraid) REFERENCES public.compra(id);


--
-- TOC entry 4866 (class 2606 OID 27439)
-- Name: detallecompra fk_detallecompra_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallecompra
    ADD CONSTRAINT fk_detallecompra_producto FOREIGN KEY (productoid) REFERENCES public.producto(id);


--
-- TOC entry 4867 (class 2606 OID 27444)
-- Name: detalledelivery fk_detalledelivery_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalledelivery
    ADD CONSTRAINT fk_detalledelivery_compra FOREIGN KEY (compra_id) REFERENCES public.compra(id);


--
-- TOC entry 4868 (class 2606 OID 27449)
-- Name: detalledelivery fk_detalledelivery_delivery; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalledelivery
    ADD CONSTRAINT fk_detalledelivery_delivery FOREIGN KEY (delivery_id) REFERENCES public.delivery(id);


--
-- TOC entry 4869 (class 2606 OID 27454)
-- Name: detalleentrega fk_detalleentrega_ciudad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalleentrega
    ADD CONSTRAINT fk_detalleentrega_ciudad FOREIGN KEY (ciudadid) REFERENCES public.ciudad(id);


--
-- TOC entry 4870 (class 2606 OID 27459)
-- Name: detalleentrega fk_detalleentrega_comprador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalleentrega
    ADD CONSTRAINT fk_detalleentrega_comprador FOREIGN KEY (compradorid) REFERENCES public.comprador(id);


--
-- TOC entry 4871 (class 2606 OID 27464)
-- Name: detalleentrega fk_detalleentrega_direccion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalleentrega
    ADD CONSTRAINT fk_detalleentrega_direccion FOREIGN KEY (direccionentregaid) REFERENCES public.direccionentrega(id);


--
-- TOC entry 4872 (class 2606 OID 27469)
-- Name: detallefactura fk_detallefactura_factura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallefactura
    ADD CONSTRAINT fk_detallefactura_factura FOREIGN KEY (facturaid) REFERENCES public.factura(id);


--
-- TOC entry 4873 (class 2606 OID 27474)
-- Name: detallefactura fk_detallefactura_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detallefactura
    ADD CONSTRAINT fk_detallefactura_producto FOREIGN KEY (productoid) REFERENCES public.producto(id);


--
-- TOC entry 4874 (class 2606 OID 27479)
-- Name: detalleprecio fk_detalleprecio_precio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalleprecio
    ADD CONSTRAINT fk_detalleprecio_precio FOREIGN KEY (precioid) REFERENCES public.precio(id);


--
-- TOC entry 4875 (class 2606 OID 27484)
-- Name: direccionentrega fk_direccionentrega_comprador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccionentrega
    ADD CONSTRAINT fk_direccionentrega_comprador FOREIGN KEY (compradorid) REFERENCES public.comprador(id);


--
-- TOC entry 4876 (class 2606 OID 27489)
-- Name: estadoreclamo fk_estadoreclamo_reclamo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estadoreclamo
    ADD CONSTRAINT fk_estadoreclamo_reclamo FOREIGN KEY (reclamo_id) REFERENCES public.reclamo(id);


--
-- TOC entry 4877 (class 2606 OID 27494)
-- Name: factura fk_factura_compra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk_factura_compra FOREIGN KEY (compraid) REFERENCES public.compra(id);


--
-- TOC entry 4878 (class 2606 OID 27499)
-- Name: historialreclamo fk_historialreclamo_reclamo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historialreclamo
    ADD CONSTRAINT fk_historialreclamo_reclamo FOREIGN KEY (reclamo_id) REFERENCES public.reclamo(id);


--
-- TOC entry 4879 (class 2606 OID 27504)
-- Name: inforeclamomotivo fk_inforeclamomotivo_motivo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inforeclamomotivo
    ADD CONSTRAINT fk_inforeclamomotivo_motivo FOREIGN KEY (motivoid) REFERENCES public.motivo(id);


--
-- TOC entry 4880 (class 2606 OID 27509)
-- Name: inforeclamomotivo fk_inforeclamomotivo_reclamo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inforeclamomotivo
    ADD CONSTRAINT fk_inforeclamomotivo_reclamo FOREIGN KEY (reclamoid) REFERENCES public.reclamo(id);


--
-- TOC entry 4881 (class 2606 OID 27514)
-- Name: metodopago fk_metodopago_comprador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.metodopago
    ADD CONSTRAINT fk_metodopago_comprador FOREIGN KEY (compradorid) REFERENCES public.comprador(id);


--
-- TOC entry 4882 (class 2606 OID 27519)
-- Name: moneda fk_moneda_pais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moneda
    ADD CONSTRAINT fk_moneda_pais FOREIGN KEY (pais) REFERENCES public.pais(id);


--
-- TOC entry 4883 (class 2606 OID 27524)
-- Name: pago fk_pago_metodopago; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pago
    ADD CONSTRAINT fk_pago_metodopago FOREIGN KEY (metodopago_id) REFERENCES public.metodopago(id);


--
-- TOC entry 4884 (class 2606 OID 27529)
-- Name: precio fk_precio_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precio
    ADD CONSTRAINT fk_precio_producto FOREIGN KEY (idproducto) REFERENCES public.producto(id);


--
-- TOC entry 4886 (class 2606 OID 27534)
-- Name: vendedorproducto fk_vendedorproducto_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedorproducto
    ADD CONSTRAINT fk_vendedorproducto_producto FOREIGN KEY (idproducto) REFERENCES public.producto(id);


--
-- TOC entry 4887 (class 2606 OID 27539)
-- Name: vendedorproducto fk_vendedorproducto_vendedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedorproducto
    ADD CONSTRAINT fk_vendedorproducto_vendedor FOREIGN KEY (idvendedor) REFERENCES public.vendedor(id);


--
-- TOC entry 4885 (class 2606 OID 27544)
-- Name: reclamo fks18l7t4p5rc9xjuj00c2up9od; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reclamo
    ADD CONSTRAINT fks18l7t4p5rc9xjuj00c2up9od FOREIGN KEY (compra_id) REFERENCES public.compra(id);


--
-- TOC entry 5066 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;


-- Completed on 2025-05-28 01:07:04

--
-- PostgreSQL database dump complete
--

