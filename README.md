# CEKALIX-VENTAS
Sistema web académico de ventas de CEKALIX S.A.C. con Java 17, JSP, Servlets, JDBC, MySQL 8 y Tomcat 11. Arquitectura MVC + DAO.

## Requisitos
- JDK 17, Maven 3.9+, Apache Tomcat 11 y MySQL 8.

## Instalación
1. Ejecuta `database/cekalix_ventas.sql` en MySQL Workbench.
2. Configura opcionalmente `CEKALIX_DB_URL`, `CEKALIX_DB_USER` y `CEKALIX_DB_PASSWORD`. Valores por defecto: localhost:3306/cekalix_ventas, root y contraseña vacía.
3. Ejecuta `mvn clean package`.
4. Despliega `target/CEKALIX-VENTAS.war` en Tomcat 11 o importa como Existing Maven Project en Eclipse y usa Run on Server.
5. Abre http://localhost:8080/CEKALIX-VENTAS/

## Acceso inicial
Usuario `admin`, contraseña `admin123`. El hash se valida con PBKDF2-HMAC-SHA256. Cambia las credenciales de demostración antes de usar datos reales.

## Módulos
- Inicio y cierre de sesión.
- Control de acceso por sesión y roles Administrador/Vendedor.
- Panel principal.
- Gestión básica de clientes.
- Catálogo y alta de productos.
- Generación y consulta de cotizaciones (sin descuento de stock).
- Registro de ventas con varios productos, validación de existencias y transacción JDBC.
- Historial de ventas.
- Administración básica de usuarios y reporte resumido (solo administrador).

## Arquitectura
- Vista: JSP/HTML/CSS dentro de `WEB-INF/vistas`.
- Controlador: Servlets.
- Modelo: JavaBeans.
- Persistencia: DAO + JDBC.
- Seguridad: filtro de sesión/rol y contraseñas PBKDF2.

## Límites de esta versión
Los comprobantes son registros internos de control, no comprobantes electrónicos autorizados por SUNAT. Aún faltan: edición avanzada, conversión de cotización a venta, emisión/descarga PDF, reportes de flujo de caja, auditoría, paginación y pruebas automatizadas.