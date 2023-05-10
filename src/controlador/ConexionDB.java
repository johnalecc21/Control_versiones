
package controlador;

import modelo.Usuario;
import modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;



public class ConexionDB {
    Connection conn;
  
    //documentacion
    public ConexionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmaciabd", "root", "2002");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Error al conectar");
        }
    }
     
      public boolean authenticate(String documento, String contrasena) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM Usuarios WHERE documento = ? AND contrasena = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, documento);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            result = rs.next();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int Reusuario(String documento, String nombre, String contrasena, String rol, String estado){
        int res=0;
        try {
            PreparedStatement stmt;
            stmt=conn.prepareStatement("insert into Usuarios(documento,nombre,contrasena,rol,estado)values(?,?,?,?,?)");
           
            stmt.setString(1, documento);
            stmt.setString(2, nombre);
            stmt.setString(3, contrasena);
            stmt.setString(4, rol); 
            stmt.setString(5, estado); 
            res=stmt.executeUpdate();
            System.out.println("Usuario registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar");
            System.out.println(e);
        }
        
        return res;
    }
    
        public ArrayList<Usuario> ListarUsuario(){
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Usuario> res = new ArrayList<>();
        try {
            ps=conn.prepareStatement(" select * from Usuarios ");
            rs = ps.executeQuery();
            while (rs.next()) {             
                Usuario usuario=new Usuario();
                usuario.setId(rs.getString("idusuario"));
                usuario.setDocumento(rs.getString("documento"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("Estado"));
                res.add(usuario);
                
            }
        } catch (Exception e) {
        }
        return res;
    }
    
        
    public int Elusuario(String id){
        int res=0;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=conn.prepareStatement("delete from Usuarios where idusuario=?");
            ps.setString(1, id);
            res=ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario");
        }
        return res;
    }
    
    
    public int Acusuario(String documento, String nombre, String contrasena, String rol, String estado, String idusuario){
        int res=0;
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=conn.prepareStatement(" update Usuarios set documento=?, nombre=?, contrasena=?, rol=?, estado=? where idusuario=?");
            ps.setString(1, documento);
            ps.setString(2, nombre);
            ps.setString(3, contrasena);
            ps.setString(4, rol);
            ps.setString(5, estado);
            ps.setString(6, idusuario);
            res=ps.executeUpdate();
            System.out.println("Datos modificados correctamente");
        } catch (Exception e) {
            System.out.println("Error al modifar datos");
        }
        
        return res;
    }
    
    
    public int Reproducto(String nombreproducto, String descripcion, String precio, String cantidad){
        int res=0;
        try {
            PreparedStatement stmt;
            stmt=conn.prepareStatement("insert into productos(nombreproducto,descripcion,precio,cantidad)values(?,?,?,?)");
           
            stmt.setString(1, nombreproducto);
            stmt.setString(2, descripcion);
            stmt.setString(3, precio);
            stmt.setString(4, cantidad); 
            res=stmt.executeUpdate();
            System.out.println("Producto registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar");
            System.out.println(e);
        }
        
        return res;
    }
    
    public ArrayList<Producto> ListarProducto(){
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Producto> res = new ArrayList<>();
        try {
            ps=conn.prepareStatement(" select * from productos ");
            rs = ps.executeQuery();
            while (rs.next()) {             
                Producto producto=new Producto();
                producto.setIdproducto(rs.getString("idproductos"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                res.add(producto);
                
            }
        } catch (Exception e) {
        }
        return res;
    }
      
    
        public int Acproducto(String nombreproducto, String descripcion, String precio, String cantidad, String idproductos){
        int res=0;
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=conn.prepareStatement(" update productos set nombreproducto=?, descripcion=?, precio=?, cantidad=? where idproductos=?");
            ps.setString(1, nombreproducto);
            ps.setString(2, descripcion);
            ps.setString(3, precio);
            ps.setString(4, cantidad);
            ps.setString(5, idproductos);
            res=ps.executeUpdate();
            System.out.println("Datos modificados correctamente");
        } catch (Exception e) {
            System.out.println("Error al modifar datos");
        }
        
        return res;
    }
      
    public int Elproducto(String id){
        int res=0;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=conn.prepareStatement("delete from productos where idproductos=?");
            ps.setString(1, id);
            res=ps.executeUpdate();
            System.out.println("Producto eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar producto");
        }
        return res;
    }
    public static void main(String[] args) {
        new ConexionDB();
  }
    
}


        