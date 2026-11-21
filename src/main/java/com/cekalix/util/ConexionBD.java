package com.cekalix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestiona la conexión JDBC con MySQL.
 *
 * El driver MySQL Connector/J se agrega manualmente en:
 * src/main/webapp/WEB-INF/lib/mysql-connector-j-9.5.0.jar
 */
public final class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cekalix_ventas?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    private ConexionBD() {
        // Evita crear instancias de esta clase utilitaria.
    }

    public static Connection obtenerConexion() throws SQLException {
        try {
            // Carga explícita del driver incluido manualmente en WEB-INF/lib.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(
                    "No se encontró MySQL Connector/J. Coloca mysql-connector-j-9.5.0.jar "
                    + "dentro de WEB-INF/lib y vuelve a desplegar la aplicación.",
                    e
            );
        }

        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
