# 🛡️ SafeBuy - Base de Datos

Este repositorio contiene toda la estructura necesaria para implementar la base de datos del proyecto **SafeBuy**.

---

## 📂 Contenido principal

- `scripts/safebuy_estructura_base_FINAL_COMPLETA.sql`  
  Script completo para crear todas las tablas del sistema SafeBuy con longitudes de campos y claves foráneas.

- `scripts/update_longitudes_only.sql`  
  Script adicional para actualizar longitudes de campos en una base de datos ya existente.

- `docs/README_BASEDATOS_SAFE_BUY.md`  
  Instrucciones detalladas paso a paso para ejecutar los scripts usando pgAdmin o línea de comandos.

---

## 📦 Estructura sugerida

Consulta el archivo [`ESTRUCTURA_REPO_BASEDATOS_SAFE_BUY.txt`](./ESTRUCTURA_REPO_BASEDATOS_SAFE_BUY.txt) para organizar los archivos en carpetas `scripts/` y `docs/`.

---

## 🚀 Inicio rápido

```bash
psql -U postgres -d safebuy_db -f scripts/safebuy_estructura_base_FINAL_COMPLETA.sql
```

---

## 🔐 Requisitos

- PostgreSQL
- pgAdmin (opcional)
- Git y acceso al repositorio

---

## 👥 Autoría

Desarrollado por el equipo SafeBuy  
Universidad Católica de Oriente