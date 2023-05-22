
package controlador;

import modelo.Usuario;
import modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Ventas;



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
    
      public boolean existeUsuario(String documento) {
    boolean existe = false;
    try {
        PreparedStatement stmt;
        stmt = conn.prepareStatement("SELECT * FROM Usuarios WHERE documento=?");
        stmt.setString(1, documento);
        ResultSet rs = stmt.executeQuery();
        existe = rs.next();
    } catch (Exception e) {
        System.out.println("Error al consultar");
        System.out.println(e);
    }
    return existe;
}

public int Reusuario(String documento, String nombre, String contrasena, String rol, String estado){
    int res = 0;
    if (existeUsuario(documento)) {
        JOptionPane.showMessageDialog(null, "El usuario con documento " + documento + " ya existe");
    } else {
        try {
            PreparedStatement stmt;
            stmt=conn.prepareStatement("INSERT INTO Usuarios(documento, nombre, contrasena, rol, estado) VALUES (?, ?, ?, ?, ?)");

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
    
    public int Reproducto(String nombreproducto, String descripcion, String precio, String cantidad) {
    try {
        // Realizar una consulta a la base de datos para verificar si ya existe un registro con los mismos valores
        String query = "SELECT * FROM productos WHERE nombreproducto=? AND descripcion = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nombreproducto);
        ps.setString(2, descripcion);
        ResultSet rs = ps.executeQuery();

        // Si se encuentra un registro que coincide con los valores, retornar un valor específico para indicar que no se pudo agregar el producto
        if (rs.next()) {
            System.out.println("Producto ya existe");
            return -1;
        }

        // Si no se encuentra ningún registro que coincida con los valores, insertar los datos en la base de datos y retornar un valor específico para indicar que se agregó correctamente
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO productos(nombreproducto, descripcion, precio, cantidad) VALUES (?, ?, ?, ?)");
        stmt.setString(1, nombreproducto);
        stmt.setString(2, descripcion);
        stmt.setString(3, precio);
        stmt.setString(4, cantidad);
        int res = stmt.executeUpdate();
        System.out.println("Producto registrado correctamente");
        return res;
    } catch (Exception e) {
        System.out.println("Error al registrar");
        System.out.println(e);
        return 0;
    }
}

    /*public int Reproducto(String nombreproducto, String descripcion, String precio, String cantidad){
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
    }*/
    
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
    
public List<Producto> obtenerProductos() {
    List<Producto> productos = new ArrayList<>();
    try {
        PreparedStatement stmt;
        stmt = conn.prepareStatement("SELECT idproductos, nombreproducto, descripcion, precio, cantidad FROM productos");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("idproductos");
            String nombre = rs.getString("nombreproducto");
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");
            int cantidad = rs.getInt("cantidad");
            Producto producto = new Producto(id, nombre, precio, cantidad);
            productos.add(producto);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener productos");
        System.out.println(e);
    }
    return productos;
}

    
public Producto buscarProducto(String idproductos) {
    Producto producto = null;
    try {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos WHERE idproductos=?");
        stmt.setString(1, idproductos);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("nombreproducto");
            double precio = rs.getDouble("precio");
            int cantidad = rs.getInt("cantidad");
            producto = new Producto(idproductos, nombre, precio, cantidad);
        }
    } catch (Exception e) {
        System.out.println("Error al buscar producto");
        System.out.println(e);
    }
    return producto;
}



 public int Reventa(String idproductos, int cantidad, double totalventa) {
    try {

     // Si no se encuentra ningún registro que coincida con los valores, insertar los datos en la base de datos y retornar un valor específico para indicar que se agregó correctamente
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO ventas(idproductos, cantidad, totalventa) VALUES (?, ?, ?)");
        stmt.setString(1, idproductos);
        stmt.setInt(2, cantidad);
        stmt.setDouble(3, totalventa);
        int res = stmt.executeUpdate();
        System.out.println("Producto registrado correctamente");
        return res;
    } catch (Exception e) {
        System.out.println("Error al registrar");
        System.out.println(e);
        return 0;
    }
}
 
 
 
 // Método para insertar los datos de la venta en la tabla 'ventas'
    public void insertarVenta(int numero_factura, String fecha, double totalVentas) {
        try {

            // Preparar la consulta SQL para insertar la venta
            String consulta = "INSERT INTO ventas (numero_factura, fecha, total_ventas) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, numero_factura);
            statement.setString(2, fecha.toString());
            statement.setDouble(3, totalVentas);

            // Ejecutar la consulta
            statement.executeUpdate();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la venta en la base de datos: " + e.getMessage());
        }
    }
    
    // Método para insertar los detalles de la venta en la tabla 'detalle_venta'
    public void insertarDetalleVenta(int numero_factura, int productosid, String nombreProducto, int cantidadprod, double precio, double total) {
        try {

            // Preparar la consulta SQL para insertar el detalle de la venta
            String consulta = "INSERT INTO detalle_venta (numero_factura, productosid, cantidadprod, precio, total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, numero_factura);
            statement.setInt(2, productosid);
            statement.setInt(3, cantidadprod);
            statement.setDouble(4, precio);
            statement.setDouble(5, total);

            // Ejecutar la consulta
            statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el detalle de la venta en la base de datos: " + e.getMessage());
        }
    }
    
    public void actualizarCantidadProducto(int idproductos, int cantidad) {
    try {
       
        String query = "UPDATE productos SET cantidad = cantidad - ? WHERE idproductos = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, cantidad);
        statement.setInt(2, idproductos);
        statement.executeUpdate();
        statement.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
   public List<Ventas> buscarVentasPorFecha(String fechaInicio, String fechaFin) {
    List<Ventas> ventas = new ArrayList<>();
    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFin, formatter);

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ventas WHERE STR_TO_DATE(fecha, '%d/%m/%Y') BETWEEN ? AND ?");
        stmt.setDate(1, java.sql.Date.valueOf(inicio));
        stmt.setDate(2, java.sql.Date.valueOf(fin));
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int numeroFactura = rs.getInt("numero_factura");
            String fecha = rs.getString("fecha");
            double totalVentas = rs.getDouble("total_ventas");

            Ventas venta = new Ventas(numeroFactura, fecha, totalVentas);
            ventas.add(venta);
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ventas;
}

    
  
    
    public static void main(String[] args) {
        new ConexionDB();
  }
    
}


        