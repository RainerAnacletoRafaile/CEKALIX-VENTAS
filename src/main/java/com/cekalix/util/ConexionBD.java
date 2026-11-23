package com.cekalix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Centraliza la conexión JDBC de CEKALIX-VENTAS.
 *
 * Configuración local predeterminada para MySQL Workbench / MySQL80:
 * host=localhost, puerto=3306, base=cekalix_ventas_mvc, usuario=root.
 *
 * Para no publicar contraseñas en GitHub, la clave se lee desde
 * CEKALIX_DB_PASSWORD. Si no existe, se usa la clave de desarrollo vacía.
 * También se pueden sobrescribir URL y usuario con variables de entorno.
 */
public final class ConexionBD {

    private static final String URL_PREDETERMINADA =
        "jdbc:mysql://localhost:3306/cekalix_ventas_mvc"
        + "?useSSL=false"
        + "&allowPublicKeyRetrieval=true"
        + "&serverTimezone=America/Lima"
        + "&characterEncoding=UTF-8";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        String url = System.getenv().getOrDefault("CEKALIX_DB_URL", URL_PREDETERMINADA);
        String usuario = System.getenv().getOrDefault("CEKALIX_DB_USER", "root");
        String clave = System.getenv().getOrDefault("CEKALIX_DB_PASSWORD", "");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                "No se encontró MySQL Connector/J. Verifica que Maven haya descargado "
                + "la dependencia mysql-connector-j y que esté incluida en WEB-INF/lib.",
                e
            );
        }

        try {
            return DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            throw new SQLException(
                "No se pudo conectar a MySQL en localhost:3306/cekalix_ventas_mvc. "
                + "Verifica que el servicio MySQL80 esté iniciado y configura "
                + "CEKALIX_DB_PASSWORD con la contraseña del usuario root en Eclipse "
                + "o en las variables de entorno del sistema.",
                e
            );
        }
    }
}
