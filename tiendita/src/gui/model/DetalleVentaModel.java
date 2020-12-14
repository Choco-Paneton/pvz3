/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import entities.DetalleVenta;
import data.DetalleVentaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jhoselyn
 */
public class DetalleVentaModel extends AbstractTableModel {
    
    private List<DetalleVenta> list = new ArrayList();
    private String[] columns = {"Id", "Nombre categoria"};
    private Class[] columnsType = {Integer.class, String.class};

    public DetalleVentaModel() {
        list = DetalleVentaData.list("");
    }
    public DetalleVentaModel(String filter) {

        list = DetalleVentaData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        DetalleVenta p = (DetalleVenta) list.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return p.getCantidad();
            default:
                return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return columnsType[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    public Object getRow(int row) {
        this.fireTableRowsUpdated(row, row);
        return list.get(row);
    }
    
}
