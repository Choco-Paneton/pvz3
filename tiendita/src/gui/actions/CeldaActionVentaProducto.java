/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.actions;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Jhoselyn
 */
public class CeldaActionVentaProducto extends AbstractCellEditor implements TableCellEditor{
    
    private ActionsVentasProductos actionvp;
    public CeldaActionVentaProducto(JPanel frame){
        actionvp = new ActionsVentasProductos(frame);
        actionvp.setCeldaEditor(this);
    };
    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        actionvp.setTabla(table);
        actionvp.setIndexFila(row);
        return actionvp;
    }
    
    public void lauchStopEdit(){
        this.fireEditingStopped();
    }
    
}
