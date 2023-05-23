/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;

/**
 *
 * @author johna
 */public class DetalleVenta {
    private int idDetalle;
    private int numeroFactura;
    private int productoId;
    private int cantidadProducto;
    private double precio;
    private double total;
    private Producto producto; // Agregamos el objeto Producto

    // Constructor
    public DetalleVenta(int idDetalle, int numeroFactura, int productoId, int cantidadProducto, double precio, Producto producto) {
        this.idDetalle = idDetalle;
        this.numeroFactura = numeroFactura;
        this.productoId = productoId;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.total = total;
        this.producto = producto;
    }

    // Getters y setters

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

