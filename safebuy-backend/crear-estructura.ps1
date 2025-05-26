# Ruta base donde está tu backend
$basePath = "src\main\java\com\safebuye\safebuy_backend"

# Lista de clases
$clases = @(
    "Pais", "Moneda", "Precio", "Producto", "DetalleCompra", "Compra", "Comprador", "VendedorProducto", "Vendedor",
    "DetalleCategoria", "Categoria", "Pago", "Verificador", "DetalleDelivery", "Delivery", "DireccionEntrega",
    "Reclamo", "EstadoReclamo", "HistorialReclamo", "Motivo", "InfoReclamoMotivo", "Ciudad",
    "DetalleEntrega", "DetalleFactura", "DetallePrecio", "MetodoPago", "Factura"
)

# Crear archivos para cada clase
foreach ($clase in $clases) {
    New-Item -ItemType File -Path "$basePath\entity\$clase.java" -Force
    New-Item -ItemType File -Path "$basePath\repository\$clase`Repository.java" -Force
    New-Item -ItemType File -Path "$basePath\service\$clase`Service.java" -Force
    New-Item -ItemType File -Path "$basePath\service\impl\$clase`ServiceImpl.java" -Force
    New-Item -ItemType File -Path "$basePath\controller\$clase`Controller.java" -Force
}
