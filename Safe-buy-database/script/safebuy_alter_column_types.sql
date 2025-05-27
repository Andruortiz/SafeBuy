-- Table: public.ciudad

-- DROP TABLE IF EXISTS public.ciudad;

CREATE TABLE IF NOT EXISTS public.ciudad
(
    id uuid NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    departamento character varying(100) COLLATE pg_catalog."default",
    paisid uuid,
    CONSTRAINT ciudad_pkey PRIMARY KEY (id),
    CONSTRAINT fk_ciudad_pais FOREIGN KEY (paisid)
        REFERENCES public.pais (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.ciudad
    OWNER to postgres;


    -- Table: public.compra

-- DROP TABLE IF EXISTS public.compra;

CREATE TABLE IF NOT EXISTS public.compra
(
    id uuid NOT NULL,
    compradorid uuid,
    montototal numeric(10,2),
    CONSTRAINT compra_pkey PRIMARY KEY (id),
    CONSTRAINT fk_compra_comprador FOREIGN KEY (compradorid)
        REFERENCES public.comprador (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.compra
    OWNER to postgres;



    -- Table: public.comprador

-- DROP TABLE IF EXISTS public.comprador;

CREATE TABLE IF NOT EXISTS public.comprador
(
    id uuid NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    dni character(15) COLLATE pg_catalog."default",
    dnivalidado character varying(10) COLLATE pg_catalog."default",
    correo_electronico character varying(100) COLLATE pg_catalog."default",
    correo_confirmado character varying(10) COLLATE pg_catalog."default",
    telefono character(15) COLLATE pg_catalog."default",
    telefono_confirmado character varying(10) COLLATE pg_catalog."default",
    verificacion character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT comprador_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.comprador
    OWNER to postgres;


    -- Table: public.delivery

-- DROP TABLE IF EXISTS public.delivery;

CREATE TABLE IF NOT EXISTS public.delivery
(
    id uuid NOT NULL,
    dni character(15) COLLATE pg_catalog."default",
    dnivalidado character varying(10) COLLATE pg_catalog."default",
    verificacion_recepcion character varying(10) COLLATE pg_catalog."default",
    verificacion_entrega character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT delivery_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.delivery
    OWNER to postgres;


    -- Table: public.detallecategoria

-- DROP TABLE IF EXISTS public.detallecategoria;

CREATE TABLE IF NOT EXISTS public.detallecategoria
(
    id uuid NOT NULL,
    productoid uuid,
    categoriaid uuid,
    descripcionproducto character varying(300) COLLATE pg_catalog."default",
    subcategoria character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT detallecategoria_pkey PRIMARY KEY (id),
    CONSTRAINT fk_detallecategoria_categoria FOREIGN KEY (categoriaid)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_detallecategoria_producto FOREIGN KEY (productoid)
        REFERENCES public.producto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detallecategoria
    OWNER to postgres;


    -- Table: public.detallecompra

-- DROP TABLE IF EXISTS public.detallecompra;

CREATE TABLE IF NOT EXISTS public.detallecompra
(
    id uuid NOT NULL,
    compraid uuid,
    productoid uuid,
    cantidad integer,
    preciounitario numeric(10,2),
    productoscomprados text COLLATE pg_catalog."default",
    fechacompra date,
    fechaentrega date,
    CONSTRAINT detallecompra_pkey PRIMARY KEY (id),
    CONSTRAINT fk_detallecompra_compra FOREIGN KEY (compraid)
        REFERENCES public.compra (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_detallecompra_producto FOREIGN KEY (productoid)
        REFERENCES public.producto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detallecompra
    OWNER to postgres;





    -- Table: public.detalledelivery

-- DROP TABLE IF EXISTS public.detalledelivery;

CREATE TABLE IF NOT EXISTS public.detalledelivery
(
    id uuid NOT NULL,
    compra_id uuid,
    delivery_id uuid,
    estado character varying(20) COLLATE pg_catalog."default",
    fecha_recepcion text COLLATE pg_catalog."default",
    fecha_entrega text COLLATE pg_catalog."default",
    CONSTRAINT detalledelivery_pkey PRIMARY KEY (id),
    CONSTRAINT fk_detalledelivery_compra FOREIGN KEY (compra_id)
        REFERENCES public.compra (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_detalledelivery_delivery FOREIGN KEY (delivery_id)
        REFERENCES public.delivery (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detalledelivery
    OWNER to postgres;




    -- Table: public.detalleentrega

-- DROP TABLE IF EXISTS public.detalleentrega;

CREATE TABLE IF NOT EXISTS public.detalleentrega
(
    id uuid NOT NULL,
    compradorid uuid,
    ciudadid uuid,
    codigopostal character varying(15) COLLATE pg_catalog."default",
    direccionentregaid uuid,
    CONSTRAINT detalleentrega_pkey PRIMARY KEY (id),
    CONSTRAINT fk_detalleentrega_ciudad FOREIGN KEY (ciudadid)
        REFERENCES public.ciudad (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_detalleentrega_comprador FOREIGN KEY (compradorid)
        REFERENCES public.comprador (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_detalleentrega_direccion FOREIGN KEY (direccionentregaid)
        REFERENCES public.direccionentrega (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detalleentrega
    OWNER to postgres;





    -- Table: public.detallefactura

-- DROP TABLE IF EXISTS public.detallefactura;

CREATE TABLE IF NOT EXISTS public.detallefactura
(
    id uuid NOT NULL,
    facturaid uuid,
    productoid uuid,
    descripcion text COLLATE pg_catalog."default",
    cantidad integer,
    preciounitario numeric(10,2),
    subtotal text COLLATE pg_catalog."default",
    CONSTRAINT detallefactura_pkey PRIMARY KEY (id),
    CONSTRAINT fk_detallefactura_factura FOREIGN KEY (facturaid)
        REFERENCES public.factura (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_detallefactura_producto FOREIGN KEY (productoid)
        REFERENCES public.producto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detallefactura
    OWNER to postgres;




    -- Table: public.direccionentrega

-- DROP TABLE IF EXISTS public.direccionentrega;

CREATE TABLE IF NOT EXISTS public.direccionentrega
(
    id uuid NOT NULL,
    compradorid uuid,
    codigopostal character varying(15) COLLATE pg_catalog."default",
    calle character varying(150) COLLATE pg_catalog."default",
    informacionadicional text COLLATE pg_catalog."default",
    CONSTRAINT direccionentrega_pkey PRIMARY KEY (id),
    CONSTRAINT fk_direccionentrega_comprador FOREIGN KEY (compradorid)
        REFERENCES public.comprador (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.direccionentrega
    OWNER to postgres;


    -- Table: public.estadoreclamo

-- DROP TABLE IF EXISTS public.estadoreclamo;

CREATE TABLE IF NOT EXISTS public.estadoreclamo
(
    id uuid NOT NULL,
    descripcionestado character varying(100) COLLATE pg_catalog."default",
    estado character varying(20) COLLATE pg_catalog."default",
    reclamo_id uuid,
    CONSTRAINT estadoreclamo_pkey PRIMARY KEY (id),
    CONSTRAINT fk_estadoreclamo_reclamo FOREIGN KEY (reclamo_id)
        REFERENCES public.reclamo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.estadoreclamo
    OWNER to postgres;



    -- Table: public.factura

-- DROP TABLE IF EXISTS public.factura;

CREATE TABLE IF NOT EXISTS public.factura
(
    id uuid NOT NULL,
    compraid uuid,
    montototalfac numeric(10,2),
    moneda character(5) COLLATE pg_catalog."default",
    estado character varying(20) COLLATE pg_catalog."default",
    montototal numeric(10,2),
    CONSTRAINT factura_pkey PRIMARY KEY (id),
    CONSTRAINT fk_factura_compra FOREIGN KEY (compraid)
        REFERENCES public.compra (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.factura
    OWNER to postgres;




    -- Table: public.historialreclamo

-- DROP TABLE IF EXISTS public.historialreclamo;

CREATE TABLE IF NOT EXISTS public.historialreclamo
(
    id uuid NOT NULL,
    reclamo_id uuid,
    fechacambio date,
    estadoanterior character varying(30) COLLATE pg_catalog."default",
    estadonuevo character varying(30) COLLATE pg_catalog."default",
    fechainicio date,
    fechafin date,
    CONSTRAINT historialreclamo_pkey PRIMARY KEY (id),
    CONSTRAINT fk_historialreclamo_reclamo FOREIGN KEY (reclamo_id)
        REFERENCES public.reclamo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.historialreclamo
    OWNER to postgres;



    -- Table: public.inforeclamomotivo

-- DROP TABLE IF EXISTS public.inforeclamomotivo;

CREATE TABLE IF NOT EXISTS public.inforeclamomotivo
(
    id uuid NOT NULL,
    motivoid uuid,
    reclamoid uuid,
    esreembolsable character varying(10) COLLATE pg_catalog."default",
    estado character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT inforeclamomotivo_pkey PRIMARY KEY (id),
    CONSTRAINT fk_inforeclamomotivo_motivo FOREIGN KEY (motivoid)
        REFERENCES public.motivo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_inforeclamomotivo_reclamo FOREIGN KEY (reclamoid)
        REFERENCES public.reclamo (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.inforeclamomotivo
    OWNER to postgres;



    -- Table: public.metodopago

-- DROP TABLE IF EXISTS public.metodopago;

CREATE TABLE IF NOT EXISTS public.metodopago
(
    id uuid NOT NULL,
    compradorid uuid,
    tipometodopago character varying(30) COLLATE pg_catalog."default",
    numeromedio character varying(25) COLLATE pg_catalog."default",
    entidad character varying(50) COLLATE pg_catalog."default",
    moneda character(5) COLLATE pg_catalog."default",
    CONSTRAINT metodopago_pkey PRIMARY KEY (id),
    CONSTRAINT fk_metodopago_comprador FOREIGN KEY (compradorid)
        REFERENCES public.comprador (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.metodopago
    OWNER to postgres;




    -- Table: public.moneda

-- DROP TABLE IF EXISTS public.moneda;

CREATE TABLE IF NOT EXISTS public.moneda
(
    id uuid NOT NULL,
    codigomoneda character(5) COLLATE pg_catalog."default",
    pais uuid,
    CONSTRAINT moneda_pkey PRIMARY KEY (id),
    CONSTRAINT fk_moneda_pais FOREIGN KEY (pais)
        REFERENCES public.pais (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.moneda
    OWNER to postgres;




    -- Table: public.motivo

-- DROP TABLE IF EXISTS public.motivo;

CREATE TABLE IF NOT EXISTS public.motivo
(
    id uuid NOT NULL,
    descripcion_dada_por_comprador text COLLATE pg_catalog."default",
    categoriamotivo character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT motivo_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.motivo
    OWNER to postgres;





    -- Table: public.pago

-- DROP TABLE IF EXISTS public.pago;

CREATE TABLE IF NOT EXISTS public.pago
(
    id uuid NOT NULL,
    monto text COLLATE pg_catalog."default",
    metodopago_id uuid,
    estadopago character varying(30) COLLATE pg_catalog."default",
    vendedor uuid,
    comprador uuid,
    CONSTRAINT pago_pkey PRIMARY KEY (id),
    CONSTRAINT fk_pago_metodopago FOREIGN KEY (metodopago_id)
        REFERENCES public.metodopago (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pago
    OWNER to postgres;




    -- Table: public.pais

-- DROP TABLE IF EXISTS public.pais;

CREATE TABLE IF NOT EXISTS public.pais
(
    id uuid NOT NULL,
    nombrepais character varying(100) COLLATE pg_catalog."default",
    codigopais character(3) COLLATE pg_catalog."default",
    activotransaccion character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT pais_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pais
    OWNER to postgres;




    -- Table: public.precio

-- DROP TABLE IF EXISTS public.precio;

CREATE TABLE IF NOT EXISTS public.precio
(
    id uuid NOT NULL,
    codigomoneda character(5) COLLATE pg_catalog."default",
    idproducto uuid,
    montobase numeric(10,2),
    moneda character(5) COLLATE pg_catalog."default",
    CONSTRAINT precio_pkey PRIMARY KEY (id),
    CONSTRAINT fk_precio_producto FOREIGN KEY (idproducto)
        REFERENCES public.producto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.precio
    OWNER to postgres;






    -- Table: public.producto

-- DROP TABLE IF EXISTS public.producto;

CREATE TABLE IF NOT EXISTS public.producto
(
    id uuid NOT NULL,
    descripcion text COLLATE pg_catalog."default",
    CONSTRAINT producto_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.producto
    OWNER to postgres;








    -- Table: public.reclamo

-- DROP TABLE IF EXISTS public.reclamo;

CREATE TABLE IF NOT EXISTS public.reclamo
(
    id uuid NOT NULL,
    inforeclamomotivoid uuid,
    compra_id uuid,
    rol character varying(20) COLLATE pg_catalog."default",
    descripcion_dada_por_comprador text COLLATE pg_catalog."default",
    evidencias text COLLATE pg_catalog."default",
    id_reclamante uuid,
    CONSTRAINT reclamo_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.reclamo
    OWNER to postgres;






    -- Table: public.vendedor

-- DROP TABLE IF EXISTS public.vendedor;

CREATE TABLE IF NOT EXISTS public.vendedor
(
    id uuid NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    dni character(15) COLLATE pg_catalog."default",
    dnivalidado character varying(10) COLLATE pg_catalog."default",
    correo_electronico character varying(100) COLLATE pg_catalog."default",
    correo_confirmado character varying(10) COLLATE pg_catalog."default",
    telefono character(15) COLLATE pg_catalog."default",
    telefonoverificado text COLLATE pg_catalog."default",
    verificacion character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT vendedor_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vendedor
    OWNER to postgres;





    -- Table: public.vendedorproducto

-- DROP TABLE IF EXISTS public.vendedorproducto;

CREATE TABLE IF NOT EXISTS public.vendedorproducto
(
    id uuid NOT NULL,
    idvendedor uuid,
    idproducto uuid,
    CONSTRAINT vendedorproducto_pkey PRIMARY KEY (id),
    CONSTRAINT fk_vendedorproducto_producto FOREIGN KEY (idproducto)
        REFERENCES public.producto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_vendedorproducto_vendedor FOREIGN KEY (idvendedor)
        REFERENCES public.vendedor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vendedorproducto
    OWNER to postgres;





    -- Table: public.verificador

-- DROP TABLE IF EXISTS public.verificador;

CREATE TABLE IF NOT EXISTS public.verificador
(
    id uuid NOT NULL,
    keydeliveryrecepcion character varying(100) COLLATE pg_catalog."default",
    keydeliveryentrega character varying(100) COLLATE pg_catalog."default",
    key_del_vendedor character varying(100) COLLATE pg_catalog."default",
    key_del_comprador character varying(100) COLLATE pg_catalog."default",
    idpago uuid,
    aprobacion character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT verificador_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.verificador
    OWNER to postgres;