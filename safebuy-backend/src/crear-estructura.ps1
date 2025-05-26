# Ruta base donde se van a crear los DTOs
$basePath = "src\main\java\com\safebuye\safebuy_backend\dto"

# Crear la carpeta si no existe
if (-not (Test-Path -Path $basePath)) {
    New-Item -ItemType Directory -Path $basePath -Force
}

# Lista de clases
$classes = @(
  "Pais", "Moneda", "Precio", "Producto", "DetalleCompra", "Compra", "Comprador",
  "VendedorProducto", "Vendedor", "Categoria", "DetalleCategoria", "Pago", "Verificador",
  "DetalleDelivery", "Delivery", "DireccionEntrega", "Reclamo", "EstadoReclamo",
  "HistorialReclamo", "Motivo", "InfoReclamoMotivo", "Ciudad", "DetalleEntrega",
  "DetalleFactura", "DetallePrecio", "MetodoPago", "Factura"
)

# Crear archivos DTO
foreach ($class in $classes) {
    $fileName = "$class" + "DTO.java"
    $filePath = Join-Path -Path $basePath -ChildPath $fileName

    $content = @"
package com.safebuye.safebuy_backend.dto;

public class ${class}DTO {
    // TODO: Agregar los campos necesarios para ${class}DTO
}
"@

    Set-Content -Path $filePath -Value $content -Encoding UTF8
    Write-Host "DTO creado: $filePath"
}

Write-Host ""
Write-Host "Todos los archivos DTO fueron generados correctamente en: $basePath"
