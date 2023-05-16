/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author johna
 */
public class EstadoCellRenderer extends DefaultTableCellRenderer {
    
        @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String estado = (String) value;
        if (estado.equals("En stock")) {
            cell.setBackground(new java.awt.Color(112, 235, 22));
        } else if (estado.equals("Pocas existencias")) {
            cell.setBackground(new java.awt.Color(239, 249, 32));
        } else {
            cell.setBackground(new java.awt.Color(235, 96, 22));
        }
        
        Font font = cell.getFont().deriveFont(Font.BOLD, 13f);
         cell.setFont(font);
        return cell;
    }
    
}
