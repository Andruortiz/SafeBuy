-- Tabla: DetalleEntrega
CREATE TABLE detalleentrega (
    id UUID PRIMARY KEY,
    compradorid UUID,
    ciudadid UUID,
    codigopostal VARCHAR(15),
    direccionentregaid UUID,
    combinacion_unica VARCHAR(200)
);

-- Tabla: Ciudad
CREATE TABLE ciudad (
    id UUID PRIMARY KEY,
    nombre VARCHAR(100),
    departamento VARCHAR(100),
    paisid UUID,
    combinacion_unica VARCHAR(200)
);

-- Tabla: DetallePrecio
CREATE TABLE detalleprecio (
    id UUID PRIMARY KEY,
    precioid UUID,
    tipodetalle VARCHAR(50),
    descripcion TEXT,
    valortotal DECIMAL(10,2),
    combinacion_unica VARCHAR(200)
);

-- Tabla: MetodoPago
CREATE TABLE metodopago (
    id UUID PRIMARY KEY,
    compradorid UUID,
    tipometodopago VARCHAR(30),
    numeromedio VARCHAR(25),
    entidad VARCHAR(50),
    moneda CHAR(5),
    combinacionunica VARCHAR(200)
);

-- Tabla: Factura
CREATE TABLE factura (
    id UUID PRIMARY KEY,
    compraid UUID,
    montototalfacturado DECIMAL(10,2),
    monedausada CHAR(5),
    estadofactura VARCHAR(30),
    combinacion_unica VARCHAR(200)
);

-- Tabla: DetalleFactura
CREATE TABLE detallefactura (
    id UUID PRIMARY KEY,
    facturaid UUID,
    productoid UUID,
    descripcion TEXT,
    cantidad INT,
    preciounitario DECIMAL(10,2),
    subtotal TEXT,
    combinacion_unica VARCHAR(200)
);

-- Tabla: Producto
CREATE TABLE producto (
    id UUID PRIMARY KEY,
    descripcion TEXT,
    combinacion_unica VARCHAR(200)
);

-- Tabla: Categoria
CREATE TABLE categoria (
    id UUID PRIMARY KEY,
    categoria VARCHAR(100),
    combinacion_unica VARCHAR(200)
);

-- Tabla: DetalleCategoria
CREATE TABLE detallecategoria (
    id UUID PRIMARY KEY,
    productoid UUID,
    categoriaid TEXT,
    descripcionproducto VARCHAR(300),
    subcategoria VARCHAR(100),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Verificador
CREATE TABLE verificador (
    id UUID PRIMARY KEY,
    keydeliveryrecepcion VARCHAR(100),
    keydeliveryentrega VARCHAR(100),
    key_del_vendedor VARCHAR(100),
    key_del_comprador VARCHAR(100),
    idpago UUID,
    aprobacion VARCHAR(10),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Vendedor
CREATE TABLE vendedor (
    id UUID PRIMARY KEY,
    nombre_representante TEXT,
    dni CHAR(15),
    dnivalidado VARCHAR(10),
    correo_electronico VARCHAR(100),
    correo_confirmado VARCHAR(10),
    telefono CHAR(15),
    telefonoverificado TEXT,
    verificacion_de_la_compra VARCHAR(10),
    combinacion_unica VARCHAR(200)
);

-- Tabla: VendedorProducto
CREATE TABLE vendedorproducto (
    id UUID PRIMARY KEY,
    idvendedor UUID,
    idproducto UUID,
    combinacion_unica VARCHAR(200)
);

-- Tabla: Precio
CREATE TABLE precio (
    id UUID PRIMARY KEY,
    codigomonedaventa TEXT,
    idproducto UUID,
    montobase DECIMAL(10,2),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Reclamo
CREATE TABLE reclamo (
    id UUID PRIMARY KEY,
    inforeclamomotivoid UUID,
    compra_id TEXT,
    rol VARCHAR(20),
    descripcion_dada_por_comprador TEXT,
    evidencias TEXT,
    id_reclamante UUID,
    combinacion_unica VARCHAR(200)
);

-- Tabla: InfoReclamoMotivo
CREATE TABLE inforeclamomotivo (
    id UUID PRIMARY KEY,
    motivoid UUID,
    reclamoid UUID,
    esreembolsable VARCHAR(10),
    estado VARCHAR(20),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Motivo
CREATE TABLE motivo (
    id UUID PRIMARY KEY,
    descripcion_dada_por_comprador TEXT,
    categoriamotivo TEXT,
    combinacion_unica VARCHAR(200)
);

-- Tabla: DireccionEntrega
CREATE TABLE direccionentrega (
    id UUID PRIMARY KEY,
    compradorid UUID,
    codigopostal VARCHAR(15),
    calle VARCHAR(150),
    informacionadicional TEXT,
    combinacion_unica VARCHAR(200)
);

-- Tabla: DetalleCompra
CREATE TABLE detallecompra (
    id UUID PRIMARY KEY,
    compraid UUID,
    productoid UUID,
    cantidad INT,
    preciounitario DECIMAL(10,2),
    productoscomprados TEXT,
    fechacompra DATE,
    fechaentrega DATE,
    combinacion_unica VARCHAR(200)
);

-- Tabla: Pais
CREATE TABLE pais (
    id UUID PRIMARY KEY,
    nombrepais VARCHAR(100),
    codigopais CHAR(3),
    activotransaccion VARCHAR(50),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Moneda
CREATE TABLE moneda (
    id UUID PRIMARY KEY,
    codigomoneda CHAR(5),
    pais UUID,
    combinacion_unica VARCHAR(200)
);

-- Tabla: HistorialReclamo
CREATE TABLE historialreclamo (
    id UUID PRIMARY KEY,
    reclamo_id UUID,
    fechacambio DATE,
    estadoanterior VARCHAR(30),
    estadonuevo VARCHAR(30),
    fechainicio DATE,
    fechafin DATE,
    combinacion_unica VARCHAR(200)
);

-- Tabla: DetalleDelivery
CREATE TABLE detalledelivery (
    id UUID PRIMARY KEY,
    compra_id TEXT,
    delivery_id UUID,
    estado VARCHAR(20),
    fecha_recepcion TEXT,
    fecha_entrega TEXT,
    combinacion_unica VARCHAR(200)
);

-- Tabla: Comprador
CREATE TABLE comprador (
    id UUID PRIMARY KEY,
    nombre VARCHAR(100),
    dni CHAR(15),
    dnivalidado VARCHAR(10),
    correo_electronico VARCHAR(100),
    correo_confirmado VARCHAR(10),
    telefono CHAR(15),
    telefono_confirmado VARCHAR(10),
    verificacion VARCHAR(10),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Compra
CREATE TABLE compra (
    id UUID PRIMARY KEY,
    compradorid UUID,
    montototal DECIMAL(10,2),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Delivery
CREATE TABLE delivery (
    id UUID PRIMARY KEY,
    dni CHAR(15),
    dnivalidado VARCHAR(10),
    verificacion_recepcion VARCHAR(10),
    verificacion_entrega VARCHAR(10),
    combinacion_unica VARCHAR(200)
);

-- Tabla: Pago
CREATE TABLE pago (
    id UUID PRIMARY KEY,
    monto TEXT,
    metodopago_id TEXT,
    estadopago VARCHAR(30),
    vendedor TEXT,
    comprador TEXT,
    combinacion_unica VARCHAR(200)
);

-- Tabla: EstadoReclamo
CREATE TABLE estadoreclamo (
    id UUID PRIMARY KEY,
    descripcionestado VARCHAR(20),
    estado VARCHAR(20),
    reclamo_id UUID,
    combinacion_unica VARCHAR(200)
);

-- Claves foráneas
ALTER TABLE compra ADD CONSTRAINT fk_compra_compradorid FOREIGN KEY (compradorid) REFERENCES comprador(id);
ALTER TABLE detallecompra ADD CONSTRAINT fk_detallecompra_compraid FOREIGN KEY (compraid) REFERENCES compra(id);
ALTER TABLE detallecompra ADD CONSTRAINT fk_detallecompra_productoid FOREIGN KEY (productoid) REFERENCES producto(id);
ALTER TABLE factura ADD CONSTRAINT fk_factura_compraid FOREIGN KEY (compraid) REFERENCES compra(id);
ALTER TABLE detallefactura ADD CONSTRAINT fk_detallefactura_facturaid FOREIGN KEY (facturaid) REFERENCES factura(id);
ALTER TABLE detallefactura ADD CONSTRAINT fk_detallefactura_productoid FOREIGN KEY (productoid) REFERENCES producto(id);
ALTER TABLE precio ADD CONSTRAINT fk_precio_idproducto FOREIGN KEY (idproducto) REFERENCES producto(id);
ALTER TABLE detalleprecio ADD CONSTRAINT fk_detalleprecio_precioid FOREIGN KEY (precioid) REFERENCES precio(id);
ALTER TABLE direccionentrega ADD CONSTRAINT fk_direccionentrega_compradorid FOREIGN KEY (compradorid) REFERENCES comprador(id);
ALTER TABLE detalleentrega ADD CONSTRAINT fk_detalleentrega_direccionentregaid FOREIGN KEY (direccionentregaid) REFERENCES direccionentrega(id);
ALTER TABLE detalleentrega ADD CONSTRAINT fk_detalleentrega_compradorid FOREIGN KEY (compradorid) REFERENCES comprador(id);
ALTER TABLE detalleentrega ADD CONSTRAINT fk_detalleentrega_ciudadid FOREIGN KEY (ciudadid) REFERENCES ciudad(id);
ALTER TABLE ciudad ADD CONSTRAINT fk_ciudad_paisid FOREIGN KEY (paisid) REFERENCES pais(id);
ALTER TABLE metodopago ADD CONSTRAINT fk_metodopago_compradorid FOREIGN KEY (compradorid) REFERENCES comprador(id);
ALTER TABLE pago ADD CONSTRAINT fk_pago_metodopago_id FOREIGN KEY (metodopago_id) REFERENCES metodopago(id);
ALTER TABLE pago ADD CONSTRAINT fk_pago_comprador FOREIGN KEY (comprador) REFERENCES comprador(id);
ALTER TABLE pago ADD CONSTRAINT fk_pago_vendedor FOREIGN KEY (vendedor) REFERENCES vendedor(id);
ALTER TABLE reclamo ADD CONSTRAINT fk_reclamo_compra_id FOREIGN KEY (compra_id) REFERENCES compra(id);
ALTER TABLE reclamo ADD CONSTRAINT fk_reclamo_inforeclamomotivoid FOREIGN KEY (inforeclamomotivoid) REFERENCES inforeclamomotivo(id);
ALTER TABLE inforeclamomotivo ADD CONSTRAINT fk_inforeclamomotivo_motivoid FOREIGN KEY (motivoid) REFERENCES motivo(id);
ALTER TABLE inforeclamomotivo ADD CONSTRAINT fk_inforeclamomotivo_reclamoid FOREIGN KEY (reclamoid) REFERENCES reclamo(id);
ALTER TABLE estadoreclamo ADD CONSTRAINT fk_estadoreclamo_reclamo_id FOREIGN KEY (reclamo_id) REFERENCES reclamo(id);
ALTER TABLE historialreclamo ADD CONSTRAINT fk_historialreclamo_reclamo_id FOREIGN KEY (reclamo_id) REFERENCES reclamo(id);
ALTER TABLE detalledelivery ADD CONSTRAINT fk_detalledelivery_compra_id FOREIGN KEY (compra_id) REFERENCES compra(id);
ALTER TABLE detalledelivery ADD CONSTRAINT fk_detalledelivery_delivery_id FOREIGN KEY (delivery_id) REFERENCES delivery(id);
ALTER TABLE verificador ADD CONSTRAINT fk_verificador_idpago FOREIGN KEY (idpago) REFERENCES pago(id);
ALTER TABLE detallecategoria ADD CONSTRAINT fk_detallecategoria_productoid FOREIGN KEY (productoid) REFERENCES producto(id);
ALTER TABLE detallecategoria ADD CONSTRAINT fk_detallecategoria_categoriaid FOREIGN KEY (categoriaid) REFERENCES categoria(id);
ALTER TABLE vendedorproducto ADD CONSTRAINT fk_vendedorproducto_idvendedor FOREIGN KEY (idvendedor) REFERENCES vendedor(id);
ALTER TABLE vendedorproducto ADD CONSTRAINT fk_vendedorproducto_idproducto FOREIGN KEY (idproducto) REFERENCES producto(id);