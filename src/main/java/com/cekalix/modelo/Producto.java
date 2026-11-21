package com.cekalix.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    public Producto() { }
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
