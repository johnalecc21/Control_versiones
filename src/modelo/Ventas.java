/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author johna
 */
public class Ventas {
    private int idproductos;
    private String nombre;
    private double precio;
    private int cantidad;
    private double total;

    
    private int numeroFactura;
    private String fecha;
    private double totalVentas;

    public Ventas(int numeroFactura, String fecha, double totalVentas) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.totalVentas = totalVentas;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotalVentas() {
        return totalVentas;
    }



    
    public Ventas(int idproductos, String nombre,int cantidad, double precio , double total) {
        this.idproductos = idproductos;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = precio * cantidad;
    }




    public int getIdProductos() {
        return idproductos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }
    
    public Ventas() {
      
    }



}


