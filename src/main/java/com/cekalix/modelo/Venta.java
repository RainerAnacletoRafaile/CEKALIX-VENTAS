package com.cekalix.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idVenta;
    private String cliente;
    private LocalDateTime fecha;
    private BigDecimal total;
    private String estado;

    public Venta() { }
    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
