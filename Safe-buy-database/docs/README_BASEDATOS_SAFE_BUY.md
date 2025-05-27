# 📘 Guía para Implementar la Base de Datos de SafeBuy

Este proyecto contiene los scripts necesarios para configurar completamente la base de datos de **SafeBuy** en PostgreSQL.

---

## 📁 Archivos incluidos

1. **safebuy_estructura_base_FINAL_COMPLETA.sql**
   - Contiene la creación de todas las tablas con parámetros de longitud definidos.
   - Incluye las claves foráneas (FOREIGN KEY) al final del archivo.

2. **update_longitudes_only.sql**
   - Script opcional para actualizar una base de datos existente con las nuevas longitudes de columnas.

---

## ✅ Requisitos Previos

- PostgreSQL instalado.
- Acceso a pgAdmin, DBeaver o terminal de comandos con psql.
- Una base de datos creada, por ejemplo: `safebuy_db`.

---

## ⚙️ Opción 1: Ejecutar desde pgAdmin

1. Abre pgAdmin
2. Conéctate a tu servidor PostgreSQL.
3. Crea una nueva base de datos si no existe:
   ```sql
   CREATE DATABASE safebuy_db;
   ```
4. Haz clic derecho sobre la base de datos → `Query Tool`.
5. Abre el archivo `safebuy_estructura_base_FINAL_COMPLETA.sql`.
6. Ejecuta el script con la tecla F5.


## ⚙️ Opción 2: Usar línea de comandos (psql)

```bash
psql -U tu_usuario -d safebuy_db -f safebuy_estructura_base_FINAL_COMPLETA.sql
```

Ejemplo:

```bash
psql -U postgres -d safebuy_db -f safebuy_estructura_base_FINAL_COMPLETA.sql
```

---

## 🛠️ Actualización de longitud de columnas (opcional)

Si ya tienes la base de datos con las tablas creadas y solo quieres actualizar las longitudes:

```bash
psql -U postgres -d safebuy_db -f update_longitudes_only.sql
```

---

## 🧩 Notas

- Las claves foráneas están implementadas como `ALTER TABLE` al final del script principal.
- El tipo de dato `UUID` es utilizado para los identificadores primarios.
- Las longitudes fueron definidas según el tipo y uso lógico de cada campo.

---

## 🤝 Autor

SafeBuy - Proyecto Universitario  
Universidad Católica de Oriente  
Contacto: safebuy2005@gmail.com