/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author johna
 */
public class CustomRowRenderer extends DefaultTableCellRenderer {

    private static final int ROW_HEIGHT = 30; // altura deseada para las filas

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        table.setRowHeight(row, ROW_HEIGHT); // establecer altura de fila personalizada
        return cell;
    }
}