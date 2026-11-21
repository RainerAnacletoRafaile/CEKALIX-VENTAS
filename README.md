# CEKALIX Ventas

Sistema web académico de ventas con Java, Servlets, JSP, JavaBeans, JDBC y MySQL, organizado con MVC sencillo.

## Tecnologías
- JDK 17
- Apache Tomcat 11 (Jakarta Servlet 6)
- JSP / JSTL
- Maven
- MySQL 8

## Estructura
- Modelo: JavaBeans y DAO.
- Vista: JSP en `src/main/webapp/WEB-INF/vistas`.
- Controlador: Servlets anotados con `@WebServlet`.
- Utilidades: conexión JDBC centralizada.

## Preparación
1. Ejecuta `database/cekalix_ventas.sql` en MySQL.
2. Ajusta las credenciales en `src/main/java/com/cekalix/util/ConexionBD.java`.
3. Importa el proyecto en Eclipse mediante **File > Import > Existing Maven Projects**.
4. Configura Tomcat 11 y ejecuta **Run As > Run on Server**.
5. Abre `http://localhost:8080/CEKALIX-VENTAS/`.

Para generar el WAR: `mvn clean package`.

## Usuario de demostración
- Usuario: `admin`
- Contraseña: `admin123`

La clave en texto plano se usa únicamente para este prototipo académico local. No usar así en producción.

## Alcance inicial
Incluye login, panel principal y consulta de productos. El módulo de registro de ventas se implementará después. No se han ejecutado pruebas contra tu instalación local de MySQL/Tomcat.
