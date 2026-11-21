package com.cekalix.dao;

import com.cekalix.modelo.Producto;
import com.cekalix.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public List<Producto> listar() throws SQLException {
        String sql = "SELECT id_producto, sku, nombre, descripcion, precio, stock " +
                     "FROM producto WHERE activo = 1 ORDER BY nombre";
        List<Producto> productos = new ArrayList<>();
        try (Connection cn = ConexionBD.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setSku(rs.getString("sku"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getBigDecimal("precio"));
                p.setStock(rs.getInt("stock"));
                productos.add(p);
            }
        }
        return productos;
    }
}
