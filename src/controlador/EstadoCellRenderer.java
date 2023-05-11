/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
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
            cell.setBackground(Color.GREEN);
        } else if (estado.equals("Pocas existencias")) {
            cell.setBackground(Color.YELLOW);
        } else {
            cell.setBackground(Color.RED);
        }
        return cell;
    }
    
}
