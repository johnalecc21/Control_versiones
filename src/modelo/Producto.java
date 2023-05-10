/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author johna
 */
public class Producto {
    
    private String idproducto;
    private String nombreProducto;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    
    public Producto(String idproducto, String descripcion, double precio, int cantidad) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    
    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
        public String toRegistro(){
        return "" + idproducto + "*" + nombreProducto + "*" + descripcion +  "*" + precio + "*" + cantidad;
    }
    
    @Override
    public String toString(){
        String nombre = null;
        return nombre;
    }
}

    
