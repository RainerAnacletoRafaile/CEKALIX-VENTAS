# CEKALIX Ventas

Sistema web académico de ventas con Java, Servlets, JSP, JavaBeans, JDBC y MySQL, organizado con MVC sencillo.

## Tecnologías
- JDK 17
- Apache Tomcat 11 (Jakarta Servlet 6)
- JSP / JSTL
- JDBC
- MySQL 8
- MySQL Connector/J agregado manualmente (sin dependencia Maven)

## Estructura
- Modelo: JavaBeans y DAO.
- Vista: JSP en `src/main/webapp/WEB-INF/vistas`.
- Controlador: Servlets anotados con `@WebServlet`.
- Utilidades: conexión JDBC centralizada en `ConexionBD.java`.
- Driver JDBC: `src/main/webapp/WEB-INF/lib/mysql-connector-j-9.5.0.jar`.

## Preparación

1. Ejecuta `database/cekalix_ventas.sql` en MySQL.
2. Descarga MySQL Connector/J desde la página oficial: https://dev.mysql.com/downloads/connector/j/
3. Extrae el ZIP descargado y copia el archivo `mysql-connector-j-9.5.0.jar` en:
   `src/main/webapp/WEB-INF/lib/`
4. En Eclipse, agrega el JAR al Build Path:
   **clic derecho al proyecto > Build Path > Configure Build Path > Libraries > Add JARs...**
   y selecciona el JAR dentro de `WEB-INF/lib`.
5. Ajusta las credenciales de MySQL en `src/main/java/com/cekalix/util/ConexionBD.java`.
6. Configura Tomcat 11 y ejecuta **Run As > Run on Server**.
7. Abre `http://localhost:8080/CEKALIX-VENTAS/`.

**Importante:** el proyecto conserva su estructura de carpetas Maven para compilar y empaquetar el WAR, pero MySQL Connector/J ya no se declara como dependencia Maven. El archivo JAR se incorpora manualmente y debe quedar dentro de `WEB-INF/lib` para que Tomcat pueda cargarlo.

## Usuario de demostración
- Usuario: `admin`
- Contraseña: `admin123`

La clave en texto plano se usa únicamente para este prototipo académico local. No usar así en producción.

## Alcance inicial
Incluye login, panel principal y consulta de productos. El módulo de registro de ventas se implementará después. No se han ejecutado pruebas contra tu instalación local de MySQL/Tomcat.
