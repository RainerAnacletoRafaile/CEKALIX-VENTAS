# CEKALIX-VENTAS

Aplicación web académica para CEKALIX S.A.C. Desarrollada con **Java 17, Servlets Jakarta, JSP, JavaBeans, JDBC, MySQL 8 y Apache Tomcat 11**, bajo arquitectura MVC + DAO.

> **Este proyecto NO utiliza Maven ni Gradle.** Se importa como proyecto Java Web tradicional de Eclipse (Dynamic Web Project).

## Requisitos

- JDK 17 (configurado como JRE del proyecto en Eclipse).
- Eclipse IDE for Enterprise Java and Web Developers (WTP).
- Apache Tomcat 11.
- MySQL Server 8 y MySQL Workbench.
- MySQL Connector/J 9.5.0 (archivo JAR).

## 1. Preparar MySQL

1. Inicia el servicio MySQL.
2. Abre MySQL Workbench y ejecuta el script `database/cekalix_ventas.sql`.
3. El script crea la base independiente `cekalix_ventas_mvc`; no elimina ni modifica la base anterior `cekalix_ventas`.

## 2. Instalar MySQL Connector/J (sin Maven)

1. Descarga el ZIP oficial desde https://dev.mysql.com/downloads/connector/j/
2. Selecciona la plataforma **Platform Independent** y descarga MySQL Connector/J 9.5.0.
3. Descomprime el ZIP.
4. Copia `mysql-connector-j-9.5.0.jar` dentro de:
   `src/main/webapp/WEB-INF/lib/`
5. En Eclipse, actualiza el proyecto con **Project > Clean**. Si Eclipse no detecta el JAR automáticamente: clic derecho al proyecto > **Build Path > Configure Build Path > Libraries > Add JARs...** y selecciona el JAR de `WEB-INF/lib`.

No se necesita Maven, Gradle ni descargar dependencias con un gestor de paquetes.

## 3. Configurar la conexión MySQL

La clase `com.cekalix.util.ConexionBD` usa estos valores predeterminados:

| Parámetro | Valor |
|---|---|
| URL | `jdbc:mysql://localhost:3306/cekalix_ventas_mvc` |
| Usuario | `root` |
| Contraseña | Vacía |

Si tu usuario root tiene contraseña, configúrala en Eclipse sin escribirla en el repositorio:

1. Abre **Run > Run Configurations...**
2. Selecciona **Apache Tomcat > Tomcat v11.0 Server at localhost**.
3. Abre la pestaña **Environment** (está en la fila superior, junto a Source y Common).
4. Pulsa **New...** y crea `CEKALIX_DB_PASSWORD` con tu contraseña real de MySQL.
5. Pulsa **Apply**, detén Tomcat y vuelve a iniciarlo.

También se pueden definir opcionalmente `CEKALIX_DB_URL` y `CEKALIX_DB_USER`. No son obligatorias si utilizas los valores predeterminados.

## 4. Importar en Eclipse

1. Descarga esta rama como ZIP desde GitHub y descomprímela.
2. En Eclipse selecciona **File > Import > General > Existing Projects into Workspace**.
3. En **Select root directory**, selecciona la carpeta `CEKALIX-VENTAS` descomprimida.
4. Marca el proyecto detectado y pulsa **Finish**.
5. Si Eclipse pregunta por el runtime, selecciona **Apache Tomcat v11.0**.
6. Clic derecho al proyecto > **Properties > Project Facets**: verifica **Java 17** y **Dynamic Web Module 6.0**; en **Runtimes**, marca Apache Tomcat v11.0.
7. En la pestaña **Servers**, clic derecho en Tomcat 11 > **Add and Remove...** y agrega CEKALIX-VENTAS.
8. Inicia Tomcat.

## 5. Ejecutar

Abre:

`http://localhost:8080/CEKALIX-VENTAS/`

La página inicial redirige a `/login`. Las JSP están dentro de `WEB-INF/vistas` y se muestran mediante Servlets; no deben abrirse directamente por URL.

### Acceso de demostración

- Usuario: `admin`
- Contraseña: `admin123`

Cambia las credenciales de demostración antes de usar datos reales.

## Compilar un WAR manualmente (opcional)

Con JDK 17 y Tomcat 11 instalados, puedes usar el script `build-war.bat`. Si Tomcat no está en `C:\dev\servers\apache-tomcat-11.0.29`, define la variable `TOMCAT_HOME` antes de ejecutarlo. El JAR de MySQL debe estar en `WEB-INF/lib`.

El resultado se genera en `build/CEKALIX-VENTAS.war`. Este proceso usa `javac` y `jar` del JDK; **no usa Maven**.

## Arquitectura

- **Vista:** JSP, HTML y CSS en `src/main/webapp/WEB-INF/vistas`.
- **Controlador:** Servlets en `com.cekalix.controlador`.
- **Modelo:** JavaBeans en `com.cekalix.modelo`.
- **Persistencia:** DAO + JDBC en `com.cekalix.dao`.
- **Utilidades:** conexión y hash de contraseñas en `com.cekalix.util`.
- **Seguridad:** filtro de sesión y roles en `com.cekalix.filtro`.

## Módulos incluidos

- Inicio de sesión y cierre de sesión.
- Roles Administrador y Vendedor.
- Panel principal.
- Clientes.
- Productos.
- Cotizaciones.
- Ventas e historial.
- Usuarios.
- Reportes básicos.

## Alcance y pendientes

Los comprobantes son registros internos de control; no son comprobantes electrónicos autorizados por SUNAT. La versión aún requiere pruebas funcionales locales con MySQL/Tomcat y mejoras como edición avanzada, conversión de cotizaciones a ventas, PDF, reportes de caja, auditoría y pruebas automatizadas.
