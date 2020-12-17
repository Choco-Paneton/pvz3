/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.actions;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jhoselyn
 */
public class CeldaRenderVentaProducto implements TableCellRenderer{
    
    private ActionsVentasProductos actionvp;
    
    public CeldaRenderVentaProducto(final JPanel frame) {
       actionvp = new ActionsVentasProductos(frame);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object vslue, boolean isSelected, boolean hasFocus, int row, int column) {
        actionvp.setTabla(table);
        return actionvp;
    }
    
}
