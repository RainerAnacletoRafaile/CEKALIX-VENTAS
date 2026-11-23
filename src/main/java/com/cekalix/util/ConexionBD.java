package com.cekalix.util;
import java.sql.*;
public final class ConexionBD {
 private ConexionBD(){}
 public static Connection obtenerConexion() throws SQLException {
  String url=System.getenv().getOrDefault("CEKALIX_DB_URL","jdbc:mysql://localhost:3306/cekalix_ventas_mvc?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Lima&characterEncoding=UTF-8");
  return DriverManager.getConnection(url,System.getenv().getOrDefault("CEKALIX_DB_USER","root"),System.getenv().getOrDefault("CEKALIX_DB_PASSWORD",""));
 }
}