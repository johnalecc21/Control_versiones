/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author johna
 */
public class Usuario {

    private String id;
    private String nombre;
    private String documento;
    private String contrasena;
    private String rol;
    private String estado;

    public Usuario() {
    }

    public Usuario(String nombre, String documento, String contrasena, String rol, String estado) {
        this.nombre = nombre;
        this.documento = documento;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
    }

    public Usuario(String id, String nombre, String documento, String contrasena, String rol, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 

}
