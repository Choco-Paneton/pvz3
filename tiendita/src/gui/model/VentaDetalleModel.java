/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import data.Detalle_ventaData;
import entities.Detalle_venta;
import entities.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jhoselyn
 */
public class VentaDetalleModel extends AbstractTableModel{
    
    private List<Detalle_venta> lisDetalleVenta = new ArrayList();
    private String[] columns = {"#", "Descripcion", "Precio", "Cantidad", "Subtotal", "Acciones"};
    private Class[] columnsType = {Integer.class, String.class, Double.class, Double.class, Double.class, Object.class};

    public VentaDetalleModel() {}
    
    public VentaDetalleModel(Venta v){
        this.lisDetalleVenta = Detalle_ventaData.listByVenta(v.getId());
        this.lisDetalleVenta.add(new Detalle_venta());
    }
    
    public VentaDetalleModel(String f){
        lisDetalleVenta = Detalle_ventaData.list(f);
    }
    @Override
    public Object getValueAt(int row, int column){
        Detalle_venta vd = (Detalle_venta) lisDetalleVenta.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return vd.getProducto_id();
            case 2:
                return vd.getPrecio_unitario();
            case 3:
                return vd.getCantidad();
            case 4:
                return vd.getPrecio_total_producto();
            case 5:
                return "Add / Delete";
            
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object valor, int row, int column){
        Detalle_venta vd = (Detalle_venta) lisDetalleVenta.get(row);
        switch(column){
            case 3:
                double gr = 0;
                try {
                    gr = Double.parseDouble(valor + "");
                } catch (NumberFormatException e) {
                    System.err.println("" + e);
                }
                vd.setCantidad((int) gr);
                break;
            case 2:
                break;
        }
        this.fireTableRowsUpdated(row, row);
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
        return lisDetalleVenta.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    public void addRow(Detalle_venta vd) { // con db no se usa
        this.lisDetalleVenta.add(vd);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lisDetalleVenta.size(), lisDetalleVenta.size());
    }

    public void removeRow(int linha) { // con db no se usa
        this.lisDetalleVenta.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Object getRow(int row) { // usado para paintForm
        this.fireTableRowsUpdated(row, row);
        return lisDetalleVenta.get(row);
    }
    
}