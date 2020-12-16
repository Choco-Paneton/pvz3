/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import entities.DetalleVenta;
import data.DetalleVentaData;
import entities.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jhoselyn
 */
public class DetalleVentaModel extends AbstractTableModel {
    
    private List<DetalleVenta> list = new ArrayList();
    private String[] columns = {"#", "Cantidad", "Precio_unitario", "Precio_total_producto","Acciones"};
    private Class[] columnsType = {Integer.class, Integer.class, Float.class, Float.class, Object.class};

    public DetalleVentaModel() {
        //list = DetalleVentaData.list("");
    }
    public DetalleVentaModel(Venta v) {
        this.list = DetalleVentaData.listByVenta(v.getId_venta());
        this.list.add(new DetalleVenta());
    }
    public DetalleVentaModel(String filter) {

        list = DetalleVentaData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        DetalleVenta v = (DetalleVenta) list.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return v.getCantidad();
            case 2:
                return v.getPrecio_unitario();
            case 3:
                return v.getPrecio_total_producto();
            case 4:
                return "Add/delete";
                
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
