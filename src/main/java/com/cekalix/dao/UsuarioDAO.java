package com.cekalix.dao;

import com.cekalix.modelo.Usuario;
import com.cekalix.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioDAO {
    public Optional<Usuario> validar(String nombreUsuario, String clave) throws SQLException {
        String sql = "SELECT id_usuario, nombre, usuario, rol FROM usuario " +
                     "WHERE usuario = ? AND clave = ? AND activo = 1";
        try (Connection cn = ConexionBD.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, clave);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setIdUsuario(rs.getInt("id_usuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setRol(rs.getString("rol"));
                    return Optional.of(u);
                }
            }
        }
        return Optional.empty();
    }
}
