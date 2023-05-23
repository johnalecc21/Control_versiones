/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ConexionDB;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Ventas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author johna
 */
public class page5 extends javax.swing.JPanel {
 private int numeroFactura;
 private DateTimeFormatter formatoFecha;
    /**
     * Creates new form page5
     */
    public page5() {
        initComponents();
        MostrarTablaProducto();
        generarNumeroFactura();
        formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        mostrarFechaActual();
    }

    
    private void mostrarFechaActual() {
    LocalDate fechaActual = LocalDate.now();
    String fechaActualTexto = fechaActual.format(formatoFecha);
    TxtFecha.setText(fechaActualTexto);
}

    
    private void generarNumeroFactura() {
        // Generar un número de factura aleatorio
        Random random = new Random();
        numeroFactura = random.nextInt(1000) + 1;
        String numeroFacturaTexto = String.valueOf(numeroFactura);
        TxtNo.setText(numeroFacturaTexto);
    }

       public void MostrarTablaProducto(){

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Producto");
        modelo.addColumn("Nombre producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("precio");
        modelo.addColumn("Total");
        Listaventa.setModel(modelo);
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventas1 = new modelo.Ventas();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtCod = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtProd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtCant = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Listaventa = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        TxtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ventas");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 56, 120, 41));

        TxtNo.setEnabled(false);
        jPanel2.add(TxtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("No.");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 18, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ingrese la información de la venta");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 242, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Id producto:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 109, 35));

        TxtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCodActionPerformed(evt);
            }
        });
        TxtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodKeyTyped(evt);
            }
        });
        jPanel2.add(TxtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 140, 35));

        BtnBuscar.setBackground(new java.awt.Color(229, 190, 1));
        BtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 162, 120, 34));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Producto");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 227, 68, -1));

        TxtProd.setEnabled(false);
        TxtProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProdActionPerformed(evt);
            }
        });
        jPanel2.add(TxtProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 222, 312, 32));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Stock");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 278, -1, -1));

        TxtStock.setEnabled(false);
        jPanel2.add(TxtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 272, 312, 32));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 326, -1, -1));

        TxtCant.setEnabled(false);
        TxtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCantKeyTyped(evt);
            }
        });
        jPanel2.add(TxtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 322, 312, 31));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Precio");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 379, -1, -1));

        TxtPrecio.setEnabled(false);
        jPanel2.add(TxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 373, 312, 34));

        BtnAgregar.setBackground(new java.awt.Color(51, 153, 255));
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 425, 117, 48));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Fecha:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        TxtFecha.setEnabled(false);
        TxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaActionPerformed(evt);
            }
        });
        jPanel2.add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 15, 109, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 43, 438, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 440, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 440, 500));

        Listaventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Listaventa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 570, 390));

        jButton4.setBackground(new java.awt.Color(49, 211, 49));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("generar venta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 270, 50));

        TxtTotal.setEnabled(false);
        jPanel1.add(TxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 150, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Total a pagar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 90, 20));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1080, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCodActionPerformed

    private void TxtProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtProdActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        generarNumeroFactura();
        
        
        
        try {
            
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        String fechaActualTexto = fechaActual.format(formatoFecha);
        
        // Obtener el total a pagar
        double totalPagar = Double.parseDouble(TxtTotal.getText());
        
        // Guardar la venta en la base de datos
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.insertarVenta(numeroFactura, fechaActualTexto, totalPagar);
        
        // Guardar los detalles de la venta en la base de datos
        DefaultTableModel modelo = (DefaultTableModel) Listaventa.getModel();
        int filas = modelo.getRowCount();
        
        for (int i = 0; i < filas; i++) {
            int idProducto = (int) modelo.getValueAt(i, 0);
            String nombreProducto = (String) modelo.getValueAt(i, 1);
            int cantidad = (int) modelo.getValueAt(i, 2);
            double precio = (double) modelo.getValueAt(i, 3);
            double total = (double) modelo.getValueAt(i, 4);
            
            conexionDB.insertarDetalleVenta(numeroFactura, idProducto, nombreProducto, cantidad, precio, total);
        }
        
        JOptionPane.showMessageDialog(null, "Venta generada correctamente");
        
        // Limpiar la tabla y reiniciar los campos
        modelo.setRowCount(0);
        TxtCod.setText("");
        TxtPrecio.setText("");
        TxtCant.setText("");
        TxtProd.setText("");
        TxtStock.setText("");
        TxtTotal.setText("");
        
        // Generar un nuevo número de factura
        generarNumeroFactura();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar la venta verifique los campos " );
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
        
try {
    String codigo = TxtCod.getText();

    ConexionDB buscar = new ConexionDB();
    producto = buscar.buscarProducto(codigo);

    if (producto != null) {
        TxtProd.setText(producto.getNombreProducto());
        TxtPrecio.setText(String.valueOf(producto.getPrecio()));
        TxtStock.setText(producto.getEstado());
        TxtCant.setEnabled(true);
    } else {
        JOptionPane.showMessageDialog(null, "El producto con el código especificado no se encuentra");
        TxtCod.setText("");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + e.getMessage());
}


    }//GEN-LAST:event_BtnBuscarActionPerformed
    double totalVentas = 0.0; // Variable para llevar la suma acumulada de los precios

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
try {
    DefaultTableModel modelos = (DefaultTableModel) Listaventa.getModel();


    if (Integer.parseInt(TxtCant.getText()) <= producto.getCantidad()) {
        int idproducto = Integer.parseInt(TxtCod.getText());
        String nombreproducto = TxtProd.getText();
        double precio = Double.parseDouble(TxtPrecio.getText());
        int cantidad = Integer.parseInt(TxtCant.getText());
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.actualizarCantidadProducto(idproducto, cantidad);
        double total = precio * cantidad;

        Object[] ventaData = {idproducto, nombreproducto, cantidad, precio, total};
        modelos.addRow(ventaData);

        totalVentas += total; // Sumar el total al acumulador de ventas

        // Actualizar el campo TxtTotal con el total acumulado
        TxtTotal.setText(String.valueOf(totalVentas));

        // Limpiar los campos después de agregar la venta
        TxtCod.setText("");
        TxtPrecio.setText("");
        TxtCant.setText("");
        TxtProd.setText("");
        TxtStock.setText("");
        TxtCant.setEnabled(false);
    } else {
        JOptionPane.showMessageDialog(null, "No hay suficiente stock de este producto");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error al agregar la venta verifique los campos " );
}

        
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void TxtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCantKeyTyped
        // TODO add your handling code here:
            if (evt.getKeyChar()>=32 && evt.getKeyChar()<=47 || evt.getKeyChar()>=58 ) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permite el ingreso de numeros");
        }        // TODO add your handling code here:
    
        
    }//GEN-LAST:event_TxtCantKeyTyped

    private void TxtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodKeyTyped
        // TODO add your handling code here:
               if (evt.getKeyChar()>=32 && evt.getKeyChar()<=47 || evt.getKeyChar()>=58 ) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permite el ingreso de numeros");
        }
    }//GEN-LAST:event_TxtCodKeyTyped

    private void TxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaActionPerformed

    private Producto producto = new Producto();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JTable Listaventa;
    private javax.swing.JTextField TxtCant;
    private javax.swing.JTextField TxtCod;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtNo;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtProd;
    private javax.swing.JTextField TxtStock;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private modelo.Ventas ventas1;
    // End of variables declaration//GEN-END:variables
}
